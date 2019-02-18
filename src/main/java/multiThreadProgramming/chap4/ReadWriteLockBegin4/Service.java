package multiThreadProgramming.chap4.ReadWriteLockBegin4;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();  //可重入-读写锁

    public void read(){
        try {
            lock.readLock().lock();
            System.out.println("已获得读锁-共享锁---" + Thread.currentThread().getName() + "---" + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.readLock().unlock();
        }
    }//end method

    public void write(){
        try {
            lock.writeLock().lock();
            System.out.println("已获得写锁-排他锁---" + Thread.currentThread().getName() + "---" + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.writeLock().unlock();
        }
    }//end method
}
