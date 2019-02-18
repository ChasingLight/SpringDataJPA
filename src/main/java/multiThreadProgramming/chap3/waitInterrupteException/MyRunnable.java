package multiThreadProgramming.chap3.waitInterrupteException;

public class MyRunnable implements Runnable{

    private Object lock;

    public MyRunnable(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}
