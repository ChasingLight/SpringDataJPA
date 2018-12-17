package jdk.threadLocal;

public class SimpleUseThreadLocal {

    private static ThreadLocal t1 = new ThreadLocal();

    private static ThreadLocal t2 = new ThreadLocal();

    public static void main(String[] args) {

        Thread currThread = Thread.currentThread();
        System.out.println("当前线程的hashCode：" + currThread.hashCode());

        if (t1.get() == null){
            System.out.println("从未放过值");
            t1.set("t1---我的值");
        }

        System.out.println(t1.get());

        if (t2.get() == null){
            System.out.println("从未放过值");
            t2.set("t2---我的值");
        }

        System.out.println(t2.get());

    }
}
