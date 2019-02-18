package multiThreadProgramming.chap2.t16;

//验证：使用volatile关键字修饰"开关变量"(实例变量)，让死循环可以停下来。
public class Test {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread = new Thread(myRunnable);

        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myRunnable.setRunning(false);
        System.out.println("---主线程已经赋值为false了---");

    }
}
