package designPattern.DecoratorPattern;

import java.io.*;

public class BufferedInputStreamUsing {

    public static void main(String[] args){

        File file = new File("/Users/jaden/Jaden_Data/2_Personal/1_个人项目/SpringDataJPA/src/main/java/designPattern/DecoratorPattern/file.txt");

        byte[] bytes = new byte[1024];
        StringBuffer sb = new StringBuffer();

        try{
            //使用java I/O中的 装饰模式
            InputStream in = new BufferedInputStream((new FileInputStream(file)));

            while(in.read(bytes) != -1){
               sb.append(new String(bytes,"UTF-8"));
            }

            System.out.println(sb.toString());

        }catch (IOException e){
            e.printStackTrace();
        }

    }//end main
}
