package multiThreadProgramming.chap3.pipeReaderWriter;

import java.io.IOException;
import java.io.PipedWriter;

public class WriteData {

    public void writeMethod(PipedWriter out){
        try{
            System.out.println("---进入了管道字符流：write方法---");

            String content = "生活的厚度，值得你慢慢品味！";
            out.write(content);

            System.out.println(content);
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
