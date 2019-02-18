package multiThreadProgramming.chap2.t16_1;

//验证：静态变量，默认在多线程之间不具有"可见性"。
//     可以使用volatile，修饰静态变量实现可见性
public class Test {

    public static void main(String[] args) {

        Service service = new Service();

        Thread threadA = new ThreadA(service);

        threadA.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread threadB = new ThreadB(service);
        threadB.start();


    }
}
