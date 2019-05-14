package jdk.completableFuture;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 对会抛出异常的函数进行包装，使其不抛出受检异常。
 * 这个功能的主要用途在java的Lambda表达式中，因为java的Lambda表达式要求必须主动catch异常，烦死了。
 * 详见链接：https://segmentfault.com/a/1190000007832130
 * Created by tan_w on 2018/3/21.
 */
public class LambdaUtil {

    /**
     * 对Lambda表达式的Function做封装，使其不抛出受检异常
     *
     * @param mapper 包装类
     * @param <T>    参数T
     * @param <R>    参数R
     * @return
     */
    public static <T, R> Function<T, R> tryOf(UncheckedFunction<T, R> mapper) {
        Objects.requireNonNull(mapper);
        return t -> {
            try {
                return mapper.apply(t);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    /**
     * 对Lambda表达式的Supplier做封装，使其不抛出受检异常
     *
     * @param mapper 包装类
     * @param <U>    参数U
     * @return
     */
    public static <U> Supplier<U> tryOf(UncheckedSupplier<U> mapper) {
        Objects.requireNonNull(mapper);
        return () -> {
            try {
                return mapper.get();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    /**
     * 对Lambda表达式的Consumer做封装，使其不抛出受检异常
     *
     * @param mapper 包装类
     * @param <T>    参数T
     * @return
     */
    public static <T> Consumer<T> tryOf(UncheckedConsumer<T> mapper) {
        Objects.requireNonNull(mapper);
        return t -> {
            try {
                mapper.accept(t);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    /**
     * 对Lambda表达式的Runnable做封装,使其不抛出受检异常
     *
     * @param mapper Runnable的包装类
     * @return
     */
    public static Runnable tryof(UncheckedRunnable mapper) {
        Objects.requireNonNull(mapper);

        return () -> {
            try {
                mapper.run();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    @FunctionalInterface
    public interface UncheckedFunction<T, R> {
        R apply(T t) throws Exception;
    }

    @FunctionalInterface
    public interface UncheckedSupplier<U> {
        U get() throws Exception;
    }

    @FunctionalInterface
    public interface UncheckedConsumer<T> {
        void accept(T t) throws Exception;
    }

    @FunctionalInterface
    public interface UncheckedRunnable {
        void run() throws Exception;
    }
}
