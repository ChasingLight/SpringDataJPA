package multiThreadProgramming.chap2.synMoreObjectStaticOneLock;

public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod1();
    }
}
