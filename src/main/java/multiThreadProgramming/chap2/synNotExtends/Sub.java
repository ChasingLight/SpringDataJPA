package multiThreadProgramming.chap2.synNotExtends;

public class Sub extends Main{

    @Override
    public void serviceMethod() {
        try{
            System.out.println("int sub: begin method");
            Thread.sleep(3000);
            System.out.println("int sub: end method");
            super.serviceMethod();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
