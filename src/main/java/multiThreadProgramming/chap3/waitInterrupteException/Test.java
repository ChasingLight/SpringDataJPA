package multiThreadProgramming.chap3.waitInterrupteException;

//验证：当线程处于wait()状态时，再调用线程的interrupt()方法，会抛出InterruptException
public class Test {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        MyRunnable myRunnable = new MyRunnable(lock);
        Thread thread = new Thread(myRunnable);

        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}
