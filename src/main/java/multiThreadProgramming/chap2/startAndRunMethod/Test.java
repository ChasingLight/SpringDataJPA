package multiThreadProgramming.chap2.startAndRunMethod;

//验证：线程start()和run()方法的区别：1>只有调用start()方法才体现出多线程的特性；2>调用run()方法，是串行执行的。
public class Test {

    public static void main(String[] args) {
        JadenThread jadenThread = new JadenThread();

        Thread threadA = new Thread(jadenThread);
        threadA.setName("A");
        threadA.start();

        Thread threadB = new Thread(jadenThread);
        threadB.setName("B");
        threadB.start();


    }
}
