package multiThreadProgramming.chap3.pipeReaderWriter;


import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

//验证：通过"字符流管道"，进行线程间的通信
public class Test {
    public static void main(String[] args) {

        final WriteData writeData = new WriteData();
        final ReadData readData = new ReadData();

        final PipedWriter pipedWriter = new PipedWriter();
        final PipedReader pipedReader = new PipedReader();

        try {
            pipedReader.connect(pipedWriter);
            //pipedWriter.connect(pipedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread threadWrite = new Thread(new Runnable() {
            @Override
            public void run() {
                writeData.writeMethod(pipedWriter);
            }
        });

        Thread threadRead = new Thread(new Runnable() {
            @Override
            public void run() {
                readData.readMethod(pipedReader);
            }
        });


        try {
            threadWrite.start();
            Thread.sleep(5000);
            threadRead.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }//end main
}
