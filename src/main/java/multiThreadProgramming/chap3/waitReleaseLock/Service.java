package multiThreadProgramming.chap3.waitReleaseLock;

public class Service {
    public void testMethod(Object lock){
        try{
           synchronized (lock){
               System.out.println("begin wait---" + System.currentTimeMillis());
               //lock.wait();
               Thread.sleep(4000);
               System.out.println("end wait---" + System.currentTimeMillis());
           }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }//end method
}
