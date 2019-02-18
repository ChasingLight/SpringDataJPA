package multiThreadProgramming.chap2.t16_1;

public class ThreadB extends Thread{

    private Service service;

    ThreadB(Service service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.stopRun();
    }
}
