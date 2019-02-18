package multiThreadProgramming.chap2.setNewPropertiesLockOne;

public class MyRunnable implements Runnable{

    private Service myService;
    private Userinfo userinfo;

    MyRunnable(Service myService, Userinfo userinfo){
        super();
        this.myService = myService;
        this.userinfo = userinfo;
    }

    @Override
    public void run() {
        myService.testMethod(userinfo);
    }
}
