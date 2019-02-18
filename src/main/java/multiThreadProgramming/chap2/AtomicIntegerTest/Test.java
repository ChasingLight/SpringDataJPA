package multiThreadProgramming.chap2.AtomicIntegerTest;

//验证：i++操作，除了使用synchronized关键字实现同步外，还可以使用AtomicInteger"原子类"。
public class Test {

    public static void main(String[] args) {
        AddCountThread addCountThread = new AddCountThread();

        Thread thread1 = new Thread(addCountThread);    //Thread类，本身底层就实现了Runnable接口
        Thread thread2 = new Thread(addCountThread);
        Thread thread3 = new Thread(addCountThread);
        Thread thread4 = new Thread(addCountThread);
        Thread thread5 = new Thread(addCountThread);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }



}
