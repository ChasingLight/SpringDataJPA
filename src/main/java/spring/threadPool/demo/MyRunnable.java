package spring.threadPool.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by JadenOliver on 2018/3/27.
 */
public class MyRunnable implements Runnable{

    private CountDownLatch latch;

    private int num;  //序号

    private static StringBuffer batchResult = new StringBuffer();

    MyRunnable(){}

    MyRunnable(CountDownLatch latch){
        this.latch = latch;
    }

    MyRunnable(CountDownLatch latch, int num){
        this.latch = latch;
        this.num = num;
    }

    public static StringBuffer getBatchResult() {
        return batchResult;
    }

    public static void setBatchResult(StringBuffer batchResult) {
        MyRunnable.batchResult = batchResult;
    }

    @Override
    public void run() {

        String currResult = null;

        try {
            long startTime=System.currentTimeMillis();

            System.out.println(num + "线程开始运行");

            ThreadLocalRandom random = ThreadLocalRandom.current();
            Thread.sleep(random.nextInt(0,1000));  //等待0~10s之间的随机交易时间, 模拟交易处理时间

            long endTime=System.currentTimeMillis();

            currResult = num + "---" + this.hashCode() + "线程:" + "已完成! 开始结束时间:" + startTime + " ~ " + endTime;

        } catch (Exception e) {
            //e.printStackTrace();
            currResult = num + "---" + this.hashCode() + "线程处理出现异常:" + e.getMessage();
        }finally {

            // 批次处理结果集合
            batchResult.append(currResult).append(System.getProperty("line.separator"));

            if (latch != null){
                latch.countDown();
            }
        } //end finally

    }//end run
}
