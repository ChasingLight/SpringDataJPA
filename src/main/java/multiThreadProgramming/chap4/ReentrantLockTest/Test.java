package multiThreadProgramming.chap4.ReentrantLockTest;

//验证：简单使用ReentrantLock的---lock()和unlock()方法
public class Test {
    public static void main(String[] args) {
        MyService service = new MyService();
        MyRunnable myRunnable = new MyRunnable(service);

        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);
        Thread thread4 = new Thread(myRunnable);
        Thread thread5 = new Thread(myRunnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
