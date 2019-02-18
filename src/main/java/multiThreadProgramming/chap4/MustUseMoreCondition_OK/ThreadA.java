package multiThreadProgramming.chap4.MustUseMoreCondition_OK;

public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}
