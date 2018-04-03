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
@RequestMapping("thread")
public class ThreadController {

    @Autowired
    private ThreadPoolTaskExecutor myTaskExecutor;

    @Autowired
    private MyRunnable myRunnable;

    @RequestMapping(value = "/multi", method = RequestMethod.GET)
    @ResponseBody
    public String multiThreadAndSingleton(HttpServletRequest request, HttpServletResponse response){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderNo = sdf.format(new Date());

        myRunnable.setOrderNo(orderNo);
        myTaskExecutor.execute(myRunnable);

        return "finish request";
    }

    @RequestMapping(value = "/showActive", method = RequestMethod.GET)
    @ResponseBody
    public String multiThreadShowActive(HttpServletRequest request, HttpServletResponse response){

        System.out.println("---当前处于活动状态的线程数：" + myTaskExecutor.getActiveCount() + " ---线程池核心线程数：" + myTaskExecutor.getPoolSize());

        return "finish request";
    }
}
