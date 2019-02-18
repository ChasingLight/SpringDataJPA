package multiThreadProgramming.chap2.synNotExtends;

//验证：当子类重写了父类的synchronized方法，则子类重写方法无法继承父类此方法的同步效果。
//如果子类不重写直接继承，则还具有同步效果。
public class Test {
    public static void main(String[] args) {
        Sub subRef = new Sub();

        ThreadA threadA = new ThreadA(subRef);
        threadA.start();
        ThreadB threadB = new ThreadB(subRef);
        threadB.start();

    }
}
