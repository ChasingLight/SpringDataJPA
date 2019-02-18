package multiThreadProgramming.chap3.join_sleep_2;

public class ThreadA extends Thread{

    private ThreadB threadB;

    public ThreadA(ThreadB threadB){
        super();
        this.threadB = threadB;
    }

    @Override
    public void run() {
        try{
            threadB.start();
            threadB.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
