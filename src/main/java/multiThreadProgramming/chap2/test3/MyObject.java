package multiThreadProgramming.chap2.test3;

public class MyObject {

    synchronized public void speedPrintString(){
        System.out.println("speedPrintString___getLock tims=" +
                System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());
        System.out.println("--------jaden-----------");
        System.out.println("speedPrintString___releaseLock tims=" +
                System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());

    }
}
