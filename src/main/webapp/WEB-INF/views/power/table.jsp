<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

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

</body>
</html>
