package multiThreadProgramming.chap6.singleton_3;

public class MyObject {

    volatile private static MyObject instance;

    private MyObject() {
    }

    public static MyObject getInstance() {
        try{
            if (null == instance){  //第一检查锁: 多线程实例，提高代码执行效率

                //模拟创建对象的一些准备工作
                Thread.sleep(3000);

                synchronized (MyThread.class){  //MyObject.class
                    if (null == instance){  //第二检查锁：判断其他线程是否已经先创建了实例，防止创建多个实例
                        instance = new MyObject();
                    }
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return instance;

    }


}
