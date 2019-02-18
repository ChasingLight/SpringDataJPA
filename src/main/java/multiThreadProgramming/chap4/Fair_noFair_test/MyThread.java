package multiThreadProgramming.chap4.Fair_noFair_test;

public class MyThread extends Thread{

    private Service service;

    public MyThread(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceMethod();
    }
}
