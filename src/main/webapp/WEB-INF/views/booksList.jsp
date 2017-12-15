<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath();
    String MethodURL = basePath+"/books/list?page=";
%>

<html>
<head>
    <meta charset="utf-8"/>
    <title>jaden书社图书列表</title>
    <link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/js/jquery.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            var totalPages = Number(${totalPages});
            var totalElements = Number(${totalElements});
            var html = "";
            for (var i = 0; i < totalPages; i++) {
                var link_Url = "<li><a href=\"<%=MethodURL%>" + (i + 1) + "\">" + (i + 1) + "</a></li>";
                html += link_Url;
            }
            var fenyeDiv = document.getElementById("link");
            fenyeDiv.innerHTML = html;

        });

    </script>
</head>
<body>
<p>jaden书社图书列表</p>


<p>总页数：${totalPages}</p>
<p>总记录条数：${totalElements}</p>

<table class="table">
    <tr align="center">
        <td>书籍编号</td>
        <td>书名</td>
        <td>书籍作者</td>
    </tr>
    <c:choose>
        <c:when test="${!empty booksList}">
            <c:forEach items="${booksList}" var="list">
                <tr>
                    <td>${list.id}</td>
                    <td>${list.name}</td>
                    <td>${list.author}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="5">未能找到符合条件的数据!</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>

<!-- 列表分页的DIV,由JS动态填充内容-->
<ul class="pagination pagination-lg" id="link">

</ul><br>

</body>
</html>


