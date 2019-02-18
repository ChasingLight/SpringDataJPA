package multiThreadProgramming.chap2.synNotExtends;

import multiThreadProgramming.chap3.waitReleaseLock.Service;

public class ThreadB extends Thread {

    private Sub subRef;

    public ThreadB(Sub subRef){
        super();
        this.subRef = subRef;
    }

    @Override
    public void run() {
        subRef.serviceMethod();
    }
}
