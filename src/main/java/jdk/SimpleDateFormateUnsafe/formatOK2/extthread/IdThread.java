package jdk.SimpleDateFormateUnsafe.formatOK2.extthread;

import jdk.SimpleDateFormateUnsafe.formatOK2.tools.ThreadId;

public class IdThread extends Thread {

    private Integer id;

    @Override
    public void run(){

        id = ThreadId.get();

        System.out.println("ThreadName=" + this.getName() + "的线程id为：" + id);
    }


}
