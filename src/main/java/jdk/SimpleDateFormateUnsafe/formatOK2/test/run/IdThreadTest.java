package jdk.SimpleDateFormateUnsafe.formatOK2.test.run;

import jdk.SimpleDateFormateUnsafe.formatOK2.extthread.IdThread;
import jdk.SimpleDateFormateUnsafe.formatOK2.extthread.MyThread;

public class IdThreadTest {

    public static void main(String[] args) {
        IdThread[] threadArray = new IdThread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new IdThread();
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}
