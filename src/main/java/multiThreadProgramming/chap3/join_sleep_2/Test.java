package multiThreadProgramming.chap3.join_sleep_2;

//验证：join()方法释放锁
//     额外说明：Object.wait()方法，指的是"当前线程"进入等待状态。
public class Test {
    public static void main(String[] args) {
        try{
            ThreadB b = new ThreadB();
            Thread a = new ThreadA(b);
            a.start();
            Thread.sleep(1000);
            ThreadC c = new ThreadC(b);
            c.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
