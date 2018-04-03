package spring.threadPool.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JadenOliver on 2018/3/23.
 */
@Controller
@RequestMapping("threadInner")
public class ThreadInnerController {

    @Autowired
    private ThreadPoolTaskExecutor myTaskExecutor;


    @RequestMapping(value = "/multi", method = RequestMethod.GET)
    @ResponseBody
    public String multiThreadAndSingleton(HttpServletRequest request, HttpServletResponse response){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderNo = sdf.format(new Date());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    long startTime=System.currentTimeMillis();
                    Thread.sleep(10000);  //等待10s, 模拟交易处理时间
                    long endTime=System.currentTimeMillis();
                    System.out.println("进程:" + this.hashCode() + "已完成! 开始结束时间:" + startTime + " ~ " + endTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        System.out.println("线程池中激活状态的线程数：" + myTaskExecutor.getActiveCount());
        myTaskExecutor.execute(runnable);


        return "finish request";
    }
}
