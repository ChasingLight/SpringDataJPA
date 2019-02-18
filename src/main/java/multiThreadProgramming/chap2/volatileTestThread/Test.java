package multiThreadProgramming.chap2.volatileTestThread;

//验证：volatile关键字，虽然可以保证实例变量(也叫：成员变量)在多线程之间的"可见性"，但是并不具备"原子性"。
public class Test {

    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        Thread[] threads = new Thread[100];

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(myRunnable);
            threads[i] = thread;
        }

        for (int i = 0; i < 100 ; i++) {
            threads[i].start();
        }

    }
}
