package multiThreadProgramming.chap2.startAndRunMethod;

public class JadenThread implements Runnable {

    @Override
    public void run() {
        String currThreadName = Thread.currentThread().getName();

        try{
            System.out.println(currThreadName + " begin run()---" + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(currThreadName + " end run()---" + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }//end method
}
