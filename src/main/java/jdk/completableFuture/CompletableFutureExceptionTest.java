package jdk.completableFuture;

import java.util.concurrent.CompletableFuture;

// 对CompletableFuture使用中，子线程抛出的异常进行定制化处理
public class CompletableFutureExceptionTest {


    public static void main(String[] args) {

        int num = 12;


        try {

            CompletableFuture<Integer> result1 = CompletableFuture.supplyAsync(LambdaUtil.tryOf(() -> {
                System.out.println("code before the exception");

                int value = createException();
                System.out.println(value);
                System.out.println(value + 2);

                System.out.println("code after the exception");

                return 0;
            })).exceptionally(ex -> {
                System.out.println("---子线程内捕获到异常信息---");
                ex.printStackTrace();
                return 0;
            });

            System.out.println(result1.join() + 1);

        } catch (Throwable ex) {
            System.out.println("---进入了自定义catch块----");
            ex.printStackTrace();
        }


    }

    public static int createException() throws Exception{
        return 12 / 0;
    }
}
