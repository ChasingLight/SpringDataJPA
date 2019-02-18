package multiThreadProgramming.chap2.throwExceptionNoLock;

import multiThreadProgramming.chap2.t1.HasSelfPrivateNum;

public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
