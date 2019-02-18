package AQS.exlusiveMode.threeThreadTest;

import sun.awt.Mutex;

public class ThreeThreadTest {

    private final static Mutex mutexLock = new Mutex();

    private static int count = 0;

    public static void main(String[] args) {

        //线程1：先加上锁，处理10秒钟，释放锁
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    mutexLock.lock();
                    Thread.sleep(10000);  //10s
                    System.out.println("当前count值为：" + ++count);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mutexLock.unlock();
                }
            }
        });

        //线程2：尝试获取锁，处理5秒钟，然后释放锁
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    mutexLock.lock();
                    Thread.sleep(5000);
                    System.out.println("当前count值为：" + ++count);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mutexLock.unlock();
                }
            }
        });

        //线程3：尝试获取锁，处理2秒钟，然后释放锁
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    mutexLock.lock();
                    Thread.sleep(2000);
                    System.out.println("当前count值为：" + ++count);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mutexLock.unlock();
                }
            }
        });


        //通过互斥锁，保证3个线程顺序执行
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
