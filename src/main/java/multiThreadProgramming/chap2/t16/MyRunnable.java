package multiThreadProgramming.chap2.t16;

public class MyRunnable implements Runnable {

    volatile private boolean isRunning = true;  //开关变量

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    MyRunnable(){
        super();
    }

    @Override
    public void run() {
        System.out.println("---进入run()方法了---");

        while(isRunning){}  //模拟初始死循环

        System.out.println("---线程被停止了---");
    }
}
