package spring.threadPool.demo;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by JadenOliver on 2018/3/23.
 */
@Controller
@RequestMapping("thread")
public class ThreadController {

    @Autowired
    private ThreadPoolTaskExecutor myTaskExecutor;

    @RequestMapping(value = "/multi", method = RequestMethod.GET)
    @ResponseBody
    public String multiThreadAndSingleton(HttpServletRequest request, HttpServletResponse response)
            throws InterruptedException,IOException {

        int countTask = 30;

        CountDownLatch latch = new CountDownLatch(countTask);

        for (int i = 1; i <= countTask; i++) {  //500 80
            MyRunnable myRunnable = new MyRunnable(latch, i);
            myTaskExecutor.execute(myRunnable);
        }

        // 当线程池中的全部完毕之后，打印结果
        latch.await();

        System.out.println(MyRunnable.getBatchResult().toString());

        // 将最终批次处理结果，保存到指定名字的文件之中
        String txtFilePath = "/Users/jaden/Jaden_Data/2_Personal/1_个人项目/SpringDataJPA/src/main/webapp/upload";
        String txtFileName = "e拍保上级网点导入结果.txt";
        String pathName = FilenameUtils.concat(txtFilePath, txtFileName);;
        File txtFile = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            txtFile = new File(pathName);
            fw = new FileWriter(txtFile);
            bw = new BufferedWriter(fw);

            bw.write(MyRunnable.getBatchResult().toString());
        } finally {
            bw.flush();
            bw.close();
            fw.close();
        }

        return "finish request";
    }

    @RequestMapping(value = "/showActive", method = RequestMethod.GET)
    @ResponseBody
    public String multiThreadShowActive(HttpServletRequest request, HttpServletResponse response){

        System.out.println("---当前处于活动状态的线程数：" + myTaskExecutor.getActiveCount() + " ---线程池核心线程数：" + myTaskExecutor.getPoolSize());

        return "finish request";
    }
}
