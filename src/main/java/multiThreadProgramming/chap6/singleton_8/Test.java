package multiThreadProgramming.chap6.singleton_8;

//验证：使用static静态代码块实现“单例模式”
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
