package multiThreadProgramming.chap2.synchronizedUpdateNewValue;

//验证：synchronized关键字，不仅具有原子性；同时也可以实现可见性。
public class Test {

    public static void main(String[] args) {

        try{
            Service service = new Service();

            Thread threadA = new ThreadA(service);
            Thread threadB = new ThreadB(service);

            threadA.start();

            Thread.sleep(1000);

            threadB.start();
            System.out.println("已经发起停止命令了");

        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }
}
