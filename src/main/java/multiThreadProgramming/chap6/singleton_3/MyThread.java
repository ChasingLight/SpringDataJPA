package multiThreadProgramming.chap6.singleton_3;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
