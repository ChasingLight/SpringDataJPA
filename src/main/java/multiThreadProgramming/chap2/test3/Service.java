package multiThreadProgramming.chap2.test3;

public class Service {

    public void testMethod1(MyObject myObject){

        //使用任意对象作为'对象监听器'
        synchronized (myObject){
           try{
               System.out.println("testMethod1___getLock time=" +
                       System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());
               Thread.sleep(5000);
               System.out.println("testMethod1___releaseLock time=" +
                       System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());

           }catch (InterruptedException e){
               e.printStackTrace();
           }

        }

    }//end method
}
