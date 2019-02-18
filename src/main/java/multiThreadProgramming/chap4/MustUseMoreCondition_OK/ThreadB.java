package multiThreadProgramming.chap4.MustUseMoreCondition_OK;

public class ThreadB extends Thread {
    private MyService service;

    public ThreadB(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
