package multiThreadProgramming.chap3.test1;

//验证结论：只能在同步方法或同步代码块中，才能调用wait()/notify()方法；否则会报异常-IllegalMonitorStateException
public class Test1 {
    public static void main(String[] args) {
        try{
            String str = new String("");
            str.wait();
            str.notify();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
