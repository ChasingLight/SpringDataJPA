package multiThreadProgramming.chap2.setNewStringTwoLock;

public class MyService {

    private String lock = "123";

    public void testMethod(){

            try{
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
                    lock = "456";  //更改锁对象
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }

    }//end method
}
