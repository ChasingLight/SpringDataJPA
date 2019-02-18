package multiThreadProgramming.chap2.throwExceptionNoLock;

public class Service {
    synchronized public void testMethod(){
        if ("a".equals(Thread.currentThread().getName())){
            System.out.println("ThreadName=" + Thread.currentThread().getName()
                    + " run beginTime=" + System.currentTimeMillis());

            System.out.println("ThreadName=" + Thread.currentThread().getName()
                    + " run exceptionTime=" + System.currentTimeMillis());

            Integer.parseInt("a");
        }else{
            System.out.println("ThreadName=" + Thread.currentThread().getName()
                    + " run beginTime=" + System.currentTimeMillis());
        }

    }
}
