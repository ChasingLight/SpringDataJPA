package multiThreadProgramming.chap2.synMoreObjectStaticOneLock;

//验证：synchronized静态方法 || synchronized(Class)
// 添加的'Class锁'对类的所有实例起作用。
public class Test {
    public static void main(String[] args) {
        try {
        Service serviceA = new Service();
        Service serviceB = new Service();

        ThreadA threadA = new ThreadA(serviceA);
        threadA.setName("A");
        threadA.start();

        Thread.sleep(100);

        ThreadB threadB = new ThreadB(serviceB);
        threadB.setName("B");
        threadB.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
