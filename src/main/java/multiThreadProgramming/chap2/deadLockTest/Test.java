package multiThreadProgramming.chap2.deadLockTest;

//验证：1> 写出能展示-多线程死锁的代码;
//2> 可使用---Thread.holdsLock(object);---方法，判断当前线程是否持有object对象监听器。

public class Test {

    public static void main(String[] args) {
        DealThread dealThread = new DealThread();

        Thread threadA = new Thread(dealThread);
        threadA.setName("a");
        threadA.start();

        Thread threadB = new Thread(dealThread);
        threadB.setName("b");
        threadB.start();


    }
}
