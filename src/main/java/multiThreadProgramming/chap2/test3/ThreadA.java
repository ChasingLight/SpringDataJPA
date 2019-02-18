package multiThreadProgramming.chap2.test3;


public class ThreadA extends Thread {

    private Service service;
    private MyObject myObject;

    public ThreadA(Service service, MyObject myObject){
        super();
        this.service = service;
        this.myObject = myObject;
    }

    @Override
    public void run() {
        service.testMethod1(myObject);
    }
}
