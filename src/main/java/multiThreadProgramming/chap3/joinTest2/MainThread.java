package multiThreadProgramming.chap3.joinTest2;

public class MainThread extends Thread{

    @Override
    public void run() {
        try{
            System.out.println("---主线程执行之前的代码111---");

            System.out.println("---主线程执行之前的代码222---");

            System.out.println("currentThread=" + Thread.currentThread().getName());

            //主线程创建且启动子线程，直到子线程销毁后，才执行主线程后续代码
            Thread subThread = new SubThread();
            subThread.start();
            subThread.join();

            System.out.println("---主线程等待子线程run()完毕，执行后续代码---");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
