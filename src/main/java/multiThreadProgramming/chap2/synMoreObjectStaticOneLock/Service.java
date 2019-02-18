package multiThreadProgramming.chap2.synMoreObjectStaticOneLock;

public class Service {

    synchronized static public void testMethod1(){

        //synchronized (Service.class){
           try{
               System.out.println("testMethod1___begin time=" +
                       System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());
               Thread.sleep(3000);
               System.out.println("testMethod1___end time=" +
                       System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());

           }catch (InterruptedException e){
               e.printStackTrace();
           }

        //}

    }//end method
}
