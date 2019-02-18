package multiThreadProgramming.chap2.synLockIn_1;


//验证：synchronized锁重入:即一个线程得到一个对象锁之后，再次请求此对象锁还可以再次获得。
public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

    }
}
