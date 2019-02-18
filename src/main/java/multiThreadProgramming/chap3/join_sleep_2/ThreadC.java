package multiThreadProgramming.chap3.join_sleep_2;

public class ThreadC extends Thread{

    private ThreadB threadB;

    public ThreadC(ThreadB threadB){
        super();
        this.threadB = threadB;
    }

    @Override
    public void run() {
        threadB.bService();
    }
}
