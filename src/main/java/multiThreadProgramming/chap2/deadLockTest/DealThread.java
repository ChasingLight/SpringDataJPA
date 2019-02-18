package multiThreadProgramming.chap2.deadLockTest;

public class DealThread implements Runnable{

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    @Override
    public void run() {
        String currThreadName = Thread.currentThread().getName();

        if ("a".equals(currThreadName)){
            synchronized (lock1){
                try{
                    System.out.println("username=" + currThreadName + "已获得lock1对象监听器");

                    System.out.println("username=" + currThreadName + "持有lock1对象监听器：" + Thread.holdsLock(lock1));
                    System.out.println("username=" + currThreadName + "持有lock2对象监听器：" + Thread.holdsLock(lock2));

                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                synchronized (lock2){
                    System.out.println("username=" + currThreadName + "按lock1->lock2代码顺序执行了");
                }

            }
        }else{
            synchronized (lock2){
                try{
                    System.out.println("username=" + currThreadName + "已获得lock2对象监听器");

                    System.out.println("username=" + currThreadName + "持有lock1对象监听器：" + Thread.holdsLock(lock1));
                    System.out.println("username=" + currThreadName + "持有lock2对象监听器：" + Thread.holdsLock(lock2));


                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                synchronized (lock1){
                    System.out.println("username=" + currThreadName + "按lock2->lock1代码顺序执行了");
                }

            }
        }


    }//end method
}
