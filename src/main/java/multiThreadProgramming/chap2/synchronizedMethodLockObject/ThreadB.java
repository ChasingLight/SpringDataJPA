package multiThreadProgramming.chap2.synchronizedMethodLockObject;


import multiThreadProgramming.chap2.t1.HasSelfPrivateNum;

public class ThreadB extends Thread {

    private MyObject myObject;

    public ThreadB(MyObject myObject){
        super();
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.methodB();
    }
}
