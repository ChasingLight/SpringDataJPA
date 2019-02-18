package multiThreadProgramming.chap2.volatileTestThread;

public class MyRunnable implements Runnable {

    volatile private int count;

    @Override
    synchronized public void run() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count = " + count);
    }
}
