package multiThreadProgramming.chap6.singleton_8;

public class MyObject {

    private static MyObject myObject;

    //静态代码块
    static {
        myObject = new MyObject();
    }

    private MyObject() {
    }

    public static MyObject getInstance() {
        return myObject;
    }


}
