<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
    <h2>文件上传实例</h2>
    <form action="/uploadFile" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="file">
        <input type="submit" value="提交">
    </form>
</body>
</html>

