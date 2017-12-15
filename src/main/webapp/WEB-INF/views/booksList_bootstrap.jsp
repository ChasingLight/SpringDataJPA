<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath();
%>

<html>
<head>
    <meta charset="utf-8"/>
    <title>jaden书社图书列表</title>

    <link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="<%=basePath%>/css/bootstrap-table.css" rel="stylesheet"/>

    <%--注意这里的js加载顺序，因为bootstrap依赖于jquery，故应先加载jquery--%>
    <script src="<%=basePath%>/js/jquery.js"></script>
    <script src="<%=basePath%>/js/jquery.form.js"></script>     <%--使用JQuery的ajaxForm提交表单，引入此js文件--%>
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap-table.js"></script>

</head>
<body>

<div class="panel-body" style="padding-bottom:0px;">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group" style="margin-top:15px">
                    <label class="control-label col-sm-1" for="txt_search_book_name">书籍名称</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_book_name">
                    </div>
                    <label class="control-label col-sm-1" for="txt_search_author">作者</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_author">
                    </div>
                    <div class="col-sm-4" style="text-align:left;">
                        <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary" onclick="search()">查询
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn btn-default" onclick="addBook()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <button id="btn_edit" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
        </button>
    </div>

    <!-- 新增的模态框 -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <%--这个是模态框右上角的x关闭符号--%>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="addModalLabel">新增图书</h4>
                </div>
                <form class="form-horizontal" role="form" id="form_data" method="post" action="${pageContext.request.contextPath}/books/add">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="bookName" class="col-sm-3 control-label">图书名称:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="bookName" name="name" placeholder="输入图书名称" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="author" class="col-sm-3 control-label">作者:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="author" name="author" placeholder="输入作者名" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="price" class="col-sm-3 control-label">书籍价格:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="price" name="price" placeholder="输入书籍价格" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-sm-3 control-label">书籍描述:</label>
                            <div class="col-sm-9">
                                <textarea rows="3" cols="20" id="description" class="form-control" name="description" placeholder="输入书籍描述" required="required"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" >保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- 编辑的模态框 -->
    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <%--这个是模态框右上角的x关闭符号--%>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="addModalLabel">编辑图书</h4>
                </div>
                <form class="form-horizontal" role="form" id="form_data_edit" method="post" action="${pageContext.request.contextPath}/books/edit">
                    <input type="hidden" id="bookId" name="id"/>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="bookName" class="col-sm-3 control-label">图书名称:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="bookName2" name="name" placeholder="输入图书名称" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="author" class="col-sm-3 control-label">作者:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="author2" name="author" placeholder="输入作者名" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="price" class="col-sm-3 control-label">书籍价格:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="price2" name="price" placeholder="输入书籍价格" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-sm-3 control-label">书籍描述:</label>
                            <div class="col-sm-9">
                                <textarea rows="3" cols="20" id="description2" class="form-control" name="description" placeholder="输入书籍描述" required="required"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" >更新</button>
                    </div>
                </form>
            </div>
        </div>
    </div>



    <table id="tb_books"></table>

</div>

<script type="text/javascript">

    $(function() {
        search();

        //方式一:新增图书使用JQuery的ajaxForm提交表单---如果使页面局部刷新，有优势
        $('#form_data').ajaxForm(
            function(data) {
                if(data == 'ok') {
                    alert('新增图书成功');
                    window.location.href="${pageContext.request.contextPath}/bookListBoot";  //重新加载页面，展示新增的记录
                }else {
                    alert("新增图书失败!");
                }
            }
        );

        $('#form_data_edit').ajaxForm(
            function(data) {
                if(data.msg == 'ok') {
                    alert('修改图书成功');
                    window.location.href="${pageContext.request.contextPath}/bookListBoot";  //重新加载页面，展示新增的记录
                }else {
                    alert("修改图书失败!");
                }
            }
        );


        //方式二:从源码入手，加以理解
//        $('#form_data1').bind('submit', function(){
//            ajaxSubmit(this, function(data){
//                alert(data);
//            });
//            return false;
//        });

    });

    //将form转为AJAX提交---begin
    function ajaxSubmit(frm, fn) {
        var dataPara = getFormJson(frm);
        $.ajax({
            url: frm.action,
            type: frm.method,
            data: dataPara,
            dataType:"text",
            success: fn
        });
    }

    //将form中的值转换为键值对。
    function getFormJson(frm) {
        var o = {};
        var a = $(frm).serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });

        return o;
    }
    //将form转为AJAX提交---end

    //使用bootstrap_table---begin
    function search(){
        $('#tb_books').bootstrapTable('destroy').bootstrapTable({
            url: '${pageContext.request.contextPath}/books/listBoot', //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: queryParams,           //传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //如果设置了分页，首页页码，默认为1
            pageSize: 5,                        //如果设置了分页，页面数据条数，默认为10（*）
            pageList: [5, 10, 20],              //可供选择的每页的行数（*）
            strictSearch: true,
            showRefresh: true,                  //是否显示刷新按钮
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            columns: [{
                checkbox: true
            }, {
                field: 'id',
                title: '书籍编号'
            }, {
                field: 'name',
                title: '书籍名称'
            }, {
                field: 'author',
                title: '书籍作者'
            }, {
                field: 'description',
                title: '描述'
            }, {
                title: '操作',
                formatter:function (value,row,index) {
                    return "<button id='check' type='button' class='btn btn-primary'>查看</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id='edit' type='button' class='btn btn-primary'>编辑</button>";
                },
                events:etevents
            }]
        });
    }

    //条件查询参数
    function queryParams(params) {  //配置参数
        var temp = {   //这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要对应改动为一样的
            limit: params.limit,   //每页多少条记录
            offset: params.offset,   //开始记录下标(从0开始)
            name: $('#txt_search_book_name').val(),
            author: $('#txt_search_author').val()
        };
        return temp;
    }
    //使用bootstrap_table---end


    //点击新增时，模态框展示
    function addBook(){
        $("#addModal").modal("show");
    }

    //编辑 点击事件的具体操作
    window.etevents={
        'click #edit':function(event,value,row,index){
            $.ajax({
                url:"${pageContext.request.contextPath}/books/getOne",
                type:"post",
                data:"id="+row.id,
                dataType:"json",
                success:function(msg){
                    $("#bookId").val(msg.id);
                    $("#bookName2").val(msg.name);
                    $("#author2").val(msg.author);
                    $("#price2").val(msg.price);
                    $("#description2").val(msg.description);
                    $("#editModal").modal("show");
                }

            });
        }
    }

</script>

</body>
</html>


