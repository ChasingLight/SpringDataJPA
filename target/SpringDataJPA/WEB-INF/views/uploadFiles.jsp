<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
    <h2>多个文件上传实例</h2>
    <form action="/uploadFiles" method="post" enctype="multipart/form-data">
        <p> 选择文件:<input type="file" name="files">
        <p> 选择文件:<input type="file" name="files">
        <p> 选择文件:<input type="file" name="files">
        <input type="submit" value="提交">
    </form>
</body>
</html>

