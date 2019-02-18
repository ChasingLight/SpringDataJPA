package multiThreadProgramming.chap4.ReentrantLockTest;

public class MyRunnable implements Runnable{

    private MyService myService;

    public MyRunnable(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
