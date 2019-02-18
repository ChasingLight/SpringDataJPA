package multiThreadProgramming.chap6.singleton_8;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
