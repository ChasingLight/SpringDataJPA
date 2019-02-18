package multiThreadProgramming.chap2.t16_1;

public class ThreadA extends Thread{

    private Service service;

    ThreadA(Service service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.alwaysRun();
    }
}
