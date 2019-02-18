package multiThreadProgramming.chap4.Fair_noFair_test;

import multiThreadProgramming.chap4.MutexLockTest.Mutex;

import java.util.concurrent.locks.ReentrantLock;

public class Service {
    private ReentrantLock lock;

    //private Mutex lock;

    public Service(boolean isFair){
        super();
        lock = new ReentrantLock(isFair);
        //lock = new Mutex();
    }

    public void serviceMethod(){
        try {
            System.out.println("***线程" + Thread.currentThread().getName() + "尝试获取锁---");
            lock.lock();
            System.out.println("---线程" + Thread.currentThread().getName() + "已经获取锁---");
        }finally {
            lock.unlock();
        }
    }//end method
}
