# SpringDataJPA:学习Spring相关知识点
Part1.SpringMVC:用MultipartFile上传单个文件,多个文件

前台页面：
upload.jsp(单文件上传) 
uploadFiles.jsp(多文件上传) 
上传结果展示页面：uploadSuccess.jsp和uploadFail.jsp 

控制器：FileUploadController

具体细节参照csdn博客：http://blog.csdn.net/u014746965/article/details/78772896

Part2.BootStrap-table + SpringDataJPA实现分页
前端界面：
booksList_bootstrap.jsp

后台：
实体：Books.java
控制层：BooksController.java
服务层：BooksService.java
DAO层：BooksRepository.java  查询语句：BookSpecs.java

运行：
配置好tomcat，服务启动后访问：http://localhost:8084/SpringDataJPA/bookListBoot

Part3. JNDI+Tomcat配置数据源
本质：将之前配置数据源细节，放在Tomcat中的/conf/context.xml中完成！
```
<?xml version="1.0" encoding="UTF-8"?>
<Context>

    <Resource name="jdbc/books"
     auth="Container"
     type="javax.sql.DataSource"
     url="jdbc:mysql://localhost:3306/jadenoliver_books"
     initialSize="2"
     maxActive="5"
     maxIdle="20"
     minIdle="2"
     maxWait="20"
     removeAbandoned="true"
     username="root"
     password="123456"
     driverClassName="com.mysql.jdbc.Driver" />

</Context>
```
然后在spring配置文件中引用即可：
注意：java:comp/env/是必写的，后面跟上之前在tomcat配置的JNDI的名字。
```
    <bean id="dataSourceJNDI" class="org.springframework.jndi.JndiObjectFactoryBean">
        <property name="jndiName">
            <value>java:comp/env/jdbc/books</value>
        </property>
    </bean>
```
参考：
1.[JNDI学习总结](https://www.cnblogs.com/xdp-gacl/p/3951952.html)
2.[tomcat配置jndi+spring使用jndi数据源](https://www.cnblogs.com/symbol/p/6738416.html)

Part4. Spring+Jedis使用redis
1.在pom.xml文件引入Jedis相关jar包：
```
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-redis</artifactId><!--使用工厂bean模式管理redis-->
            <version>1.6.0.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId><!--通过连接池来管理，通过池对象获取jedis实例-->
            <version>2.7.3</version>
        </dependency>
```
2.在spring配置文件中，配置Jedis连接池；
3.在控制器中注入Jedis连接池，进行使用。
