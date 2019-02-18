package multiThreadProgramming.chap2.synMoreObjectStaticOneLock;


public class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod1();
    }
}
