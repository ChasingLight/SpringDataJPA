public class FinallyReturn {

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println("finish..");
    }
    private static int test() {
        int b = 20;
        try {
            System.out.println("try block");
            return b += 80;
        }
        finally {
            System.out.println("finally block");
            if (b > 20) {
                System.out.println("b = " + b);
            }
            // 若此行取消注释，参见输入2。
            return 1;
            // 若此行取消注释，参见输出3。
            //b = b + 200; // 方法的返回值在finally之前已经定了（可以理解为每个方法都有一个用来保存return值的内存空间），在此再修改b并不会影响返回值。
        }
    }
}
