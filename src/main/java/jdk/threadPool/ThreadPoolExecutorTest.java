package jdk.threadPool;

/**
 * Created by JadenOliver on 2018/4/3.
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池调用客户端
 * @author kang
 *
 */
public class ThreadPoolExecutorTest {

    //池中所保存的线程数，包括空闲线程。
    final static int corePoolSize = 5;
    //池中允许的最大线程数。
    final static int maximumPoolSize = 10;
    //当线程数大于核心线程时，此为终止前多余的空闲线程等待新任务的最长时间
    final static long keepAliveTime = 200;
    //执行前用于保持任务的队列5，即任务缓存队列
    final static BlockingQueue<Runnable> workQueue =new ArrayBlockingQueue<Runnable>(5);

    public static void main(String[] args) {
        //构建一个线程池，正常线程数量为5，最大线程数据为10，等待时间200
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MINUTES, workQueue);

        //线程池去执行15个任务
        for (int i = 0; i < 20; i++) {
            MyRunnable myRunnable = new MyRunnable(i);
            threadPoolExecutor.execute(myRunnable);
            System.out.println("线程池中现在的线程数目是："+threadPoolExecutor.getPoolSize()+",  队列中正在等待执行的任务数量为："+
                    threadPoolExecutor.getQueue().size());
        }
        //关掉线程池
        threadPoolExecutor.shutdown();

    }

}
