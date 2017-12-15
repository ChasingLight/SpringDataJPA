<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath();
%>
<html>
<body>
<h2>Jaden Oliver, app.jsp access!</h2>

<span>模拟项目菜单栏</span>
<a href="<%=basePath%>/books/list" type="button">jaden书社图书一览</a>


<form id="myForm" action="<%=basePath%>/books/list" method="get">
    <input type="text" name="page" />
    <input type="text" name="size" />
    <input type="submit" value="提交">
</form>

</body>
</html>
