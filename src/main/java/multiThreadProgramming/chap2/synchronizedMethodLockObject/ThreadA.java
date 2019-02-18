package multiThreadProgramming.chap2.synchronizedMethodLockObject;

import multiThreadProgramming.chap2.t1.HasSelfPrivateNum;

public class ThreadA extends Thread {

    private MyObject myObject;

    public ThreadA(MyObject myObject){
        super();
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.methodA();
    }
}
