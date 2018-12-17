package jdk.SimpleDateFormateUnsafe.formatOK2.tools;

//ThreadLocal.java源码示例中的demo

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {

    private static final AtomicInteger nextId = new AtomicInteger(10);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static Integer get() {
        return threadId.get();
    }


}

