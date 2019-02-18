package multiThreadProgramming.chap2.setNewStringTwoLock;

public class MyRunnable implements Runnable{

    private MyService myService;

    MyRunnable(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
