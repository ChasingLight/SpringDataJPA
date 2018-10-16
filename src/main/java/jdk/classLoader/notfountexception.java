package jdk.classLoader;

public class notfountexception {



    public static void main(String[] args) {
        try {
            //显式加载的三种方式
            Class.forName("notFountClass");  //Method1

            ClassLoader cl = ClassLoader.getSystemClassLoader();
            cl.loadClass("notFountClass");  //Method2

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        notfountexception nfe = new notfountexception();

        String currClassPath = nfe.getClass().getResource("").toString();
        System.out.println("当前的classPath路径：" + currClassPath);
    }
}
