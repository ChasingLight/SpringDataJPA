package multiThreadProgramming.chap6.singleton_3;

//验证：双重检查锁机制---才可以保证"懒汉模式"的线程安全性。
public class Test {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
