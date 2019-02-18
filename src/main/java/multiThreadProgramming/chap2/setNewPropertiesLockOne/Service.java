package multiThreadProgramming.chap2.setNewPropertiesLockOne;

public class Service {

    public void testMethod(Userinfo userinfo){

            try{
                synchronized (userinfo){
                    System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());

                    userinfo.setUsername("jadenoliver");  //核心点：更改锁对象的属性
                    Thread.sleep(2000);

                    System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }

    }//end method
}
