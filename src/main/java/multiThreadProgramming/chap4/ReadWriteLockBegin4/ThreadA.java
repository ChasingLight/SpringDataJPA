package multiThreadProgramming.chap4.ReadWriteLockBegin4;

public class ThreadA extends Thread{

    private Service service;

    public ThreadA(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        //service.read();
        service.write();
    }
}
