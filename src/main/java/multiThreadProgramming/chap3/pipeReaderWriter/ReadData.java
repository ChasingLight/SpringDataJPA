package multiThreadProgramming.chap3.pipeReaderWriter;

import java.io.IOException;
import java.io.PipedReader;

public class ReadData {

    public void readMethod(PipedReader input){
        try{
            System.out.println("---进入了管道字符流：read方法---");

            char[] byteArray = new char[20];
            int readLength = input.read(byteArray);
            while( -1 != readLength){
                String content = new String(byteArray, 0, readLength);
                System.out.print(content);
                readLength = input.read(byteArray);
            }

            System.out.println();
            input.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
