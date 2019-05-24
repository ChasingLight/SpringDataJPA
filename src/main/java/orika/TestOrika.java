package orika;


import com.alibaba.fastjson.JSON;
import jdk.completableFuture.LambdaUtil;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import orika.util.EntityMapper;

import javax.swing.text.html.parser.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static ma.glasnost.orika.MappingContext.*;

public class TestOrika {

    public static void main(String[] args) {
        /*Source src = new Source(112233L, "飞翔", 30);
        SourceStu sourceStu = new SourceStu("jaden", "reading", "2012010104");
        src.setSourceStu(sourceStu);

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        src.setIntegers(integers);

        Dest dest = EntityMapper.getInstance().map(src, Dest.class);
        System.out.println(dest);*/

        try{
            ClassLoader outThreadClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println("tomcat中线程名:" + Thread.currentThread().getName());
            System.out.println("tomcat中线程的classpath:" + Thread.currentThread().getContextClassLoader().getResource("").toString());

            MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
            CompletableFuture<String> result = CompletableFuture.supplyAsync(LambdaUtil.tryOf(() -> {
                // 将外部tomcat线程的类加载器传递到CompleteFuture内部线程---不能删除否则实体映射会有NPE  mark by jinhd 2019-05-16
                //Thread.currentThread().setContextClassLoader(outThreadClassLoader);

                ClassLoader poolThreadClassLoader = Thread.currentThread().getContextClassLoader();
                System.out.println("CompletableFuture内线程池中Thread的名字" + Thread.currentThread().getName());
                System.out.println("CompletableFuture内线程池中Thread的classpath:");
                System.out.println(poolThreadClassLoader == null ? "contextClassLoader为null" : poolThreadClassLoader.getResource("").toString());

                MapperFacade mapper = mapperFactory.getMapperFacade();
                Source src = new Source(112233L, "飞翔", 30);
                Dest dest = mapper.map(src, Dest.class);

                return JSON.toJSONString(dest);
            })).exceptionally(e -> {
                e.printStackTrace();
                return e.getMessage();
            });

            System.out.println("异步执行结果：" + result.get());
        }catch (Exception e) {
            e.printStackTrace();
        }



    }
}
