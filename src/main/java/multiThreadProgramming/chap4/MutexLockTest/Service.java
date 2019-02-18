package multiThreadProgramming.chap4.MutexLockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service {

    private Mutex lock = new Mutex();  //排他锁---为不可重入锁
    //private ReentrantLock lock = new ReentrantLock();  //可重入锁

    // 读写锁---读锁、写锁皆是 可重入的
    //private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //private ReentrantReadWriteLock.ReadLock lock = readWriteLock.readLock();
    //private ReentrantReadWriteLock.WriteLock lock = readWriteLock.writeLock();


    public void service1(){
        try{
            lock.lock();
            System.out.println("service1");
            service2();
        }finally {
            lock.unlock();
        }
    }

    public void service2(){
        try{
            lock.lock();
            System.out.println("service2");
            service3();
        }finally {
            lock.unlock();
        }
    }

    public void service3(){
        try{
            lock.lock();
            System.out.println("service3");
        }finally {
            lock.unlock();
        }
    }

}
