package jdk.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

//文章引用:[Java 8 CompletableFuture 教程](https://juejin.im/post/5adbf8226fb9a07aac240a67#heading-7)
//文章引用:[Java8：当 Lambda 遇上受检异常](https://segmentfault.com/a/1190000007832130)
public class CompletableFutureDemoTest {

    public static void main(String[] args) {

        // Method1: 使用thenApply-收集-处理结果
        List<String> resultList = new ArrayList<>();

        // 组合多个CompletableFuture，且使用allOf，且使用thenAccept
        List<CompletableFuture<String>> futureList = new ArrayList<>();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {

            // 当 Lambda 遇上受检异常要求必须处理
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "靳浩东";
        });
        future1.thenAccept(friendName -> resultList.add(friendName));
        futureList.add(future1);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "陈隆基";
        });
        future2.thenAccept(friendName -> resultList.add(friendName));
        futureList.add(future2);

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "邢华阳";
        });
        future3.thenAccept(friendName -> resultList.add(friendName));
        futureList.add(future3);

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "李阳";
        });
        future4.thenAccept(friendName -> resultList.add(friendName));
        futureList.add(future4);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]));
        System.out.println("---beginTime:" + System.currentTimeMillis());

        allFutures.join();

        System.out.println("---endTime:" + System.currentTimeMillis());

        System.out.println(resultList);
    }
}
