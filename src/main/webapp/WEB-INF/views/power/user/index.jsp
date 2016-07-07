<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <jsp:include page="../../common/common.jsp"/>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }

        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }

        #addnew {
            float: right;
        }

        .page {
            position: fixed;
            bottom: 10px;
            right: 5px;
            font-size: 17px;
        }

        .small-text {
            width: 32px;
            text-align: center;

        }
    </style>
</head>
<body>
<form id="mainForm" class="form-inline definewidth m20" action="index" method="get">
    <input id="currentPage" name="currentPage" type="hidden" value=""/>
    用户名称：
    <input type="text" name="username" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    登陆账号：
    <input type="text" name="logincode" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>
    <button type="button" class="btn btn-success" id="addnew">新增用户</button>
</form>
<div id="flushDIV">
<table class="table table-bordered table-hover definewidth m10">
    <th>
        <tr>
            <th>编号</th>
            <th>登陆账号</th>
            <th>用户姓名</th>
            <th>用户角色</th>
            <th>操作</th>
        </tr>
    </th>
    <c:forEach items="${users}" var="user" varStatus="varStatus">
        <tr>
            <td>${varStatus.index+1}</td>
            <td>${user.logincode}</td>
            <td>${user.username}</td>
            <td>${user.role.rolename}</td>
            <td>
                <a href="${user.userid}/edit">编辑</a>&nbsp;&nbsp;
                <a href="javascript:del(${user.userid})">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

<div class='inline pull-right page'>
    共 ${page.totalNumber} 条
    <a href="javascript:changeCurrentPage('1')">首页</a>
    <a href="javascript:changeCurrentPage('${page.currentPage-1}')" class='pre'>上一页</a>
    当前第<span>${page.currentPage}/${page.totalPage}</span>页
    <a href="javascript:changeCurrentPage('${page.currentPage+1}')" class='next'>下一页</a>
    <a href="javascript:changeCurrentPage('${page.totalPage}')" class='last'>末页</a>
    跳至&nbsp;<input id="currentPageText" type='text' value='${page.currentPage}' class="input-small small-text"/>&nbsp;页&nbsp;
    <a href="javascript:changeCurrentPage($('#currentPageText').val())">GO</a>
</div>
</div>
</body>
</html>
<script>
    $(function () {
        $('#addnew').click(function () {
            window.location.href = "add";
        });
    });

    function del(id) {

        if (confirm("确定要删除吗？")) {

            window.location.href = id + "/delete";
        }
    }

    /**
     * 修改当前页码，调用后台重新查询
     */
    function changeCurrentPage(currentPage) {
        $('#flushDIV').html("");
        $.ajax({
            type:'post',
            url: 'list',
            dataType: "html",
            data:'currentPage='+currentPage,
            success: function (data) {
//                alert("成功"+data);
                $('#flushDIV').html(data);
            },
            error: function (data) {
                alert("失败"+data);
            }
        });

//        $("#currentPage").val(currentPage);
//        $("#mainForm").submit();

    }
</script>