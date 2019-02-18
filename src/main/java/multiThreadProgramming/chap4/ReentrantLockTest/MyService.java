package multiThreadProgramming.chap4.ReentrantLockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();  //默认创建的是“非公平锁”

    public void testMethod(){
        try{
            lock.lock();

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "---" + (i+1));
            }

        }finally {
            lock.unlock();
        }

    }//end method


}
