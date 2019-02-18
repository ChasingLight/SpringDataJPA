package multiThreadProgramming.chap2.test3;


import multiThreadProgramming.chap2.throwExceptionNoLock.Service;

public class ThreadB extends Thread {

    private MyObject myObject;

    public ThreadB(MyObject myObject){
        super();
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.speedPrintString();
    }
}
