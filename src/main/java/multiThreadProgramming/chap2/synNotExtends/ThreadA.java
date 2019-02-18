package multiThreadProgramming.chap2.synNotExtends;

import multiThreadProgramming.chap3.waitReleaseLock.Service;

public class ThreadA extends Thread {

    private Sub subRef;

    public ThreadA(Sub subRef){
        super();
        this.subRef = subRef;
    }

    @Override
    public void run() {
        subRef.serviceMethod();
    }
}
