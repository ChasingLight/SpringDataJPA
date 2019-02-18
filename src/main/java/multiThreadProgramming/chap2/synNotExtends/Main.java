package multiThreadProgramming.chap2.synNotExtends;

public class Main {

    synchronized public void serviceMethod(){
        try{
            System.out.println("int main: begin method");
            Thread.sleep(3000);
            System.out.println("int main: end method");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
