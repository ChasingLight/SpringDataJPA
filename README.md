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

