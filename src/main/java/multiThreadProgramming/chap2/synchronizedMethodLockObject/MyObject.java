package multiThreadProgramming.chap2.synchronizedMethodLockObject;

public class MyObject {

        synchronized public void methodA(){
           try{
               System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
               Thread.sleep(5000);
               System.out.println("end methodA threadName=" + Thread.currentThread().getName());
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        }

        public void methodB(){
            try{
                System.out.println("begin methodB threadName=" + Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("end methodB threadName=" + Thread.currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
}
