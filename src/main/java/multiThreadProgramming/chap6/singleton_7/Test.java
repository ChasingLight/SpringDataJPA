package multiThreadProgramming.chap6.singleton_7;

//验证：使用静态内部类实现“单例模式”
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
