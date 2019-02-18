package multiThreadProgramming.chap2.t16_1;

public class Service {
    volatile static boolean isRunning = true;  //静态-开关变量

    public void alwaysRun(){
        System.out.println("---进入alwaysRun()方法了---");

        while(isRunning){}  //模拟初始死循环

        System.out.println("---停止alwaysRun()方法了---");
    }

    public void stopRun(){
        Service.isRunning = false;

        System.out.println("---静态开关变量-已经赋值为false了---");
    }
}
