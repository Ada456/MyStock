<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="index" method="get">
    用户名称：
    <input type="text" name="username" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    登陆账号：
    <input type="text" name="logincode" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button><button type="button" class="btn btn-success" id="addnew">新增用户</button>
</form>
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
</body>
</html>
<script>
    $(function () {
		$('#addnew').click(function(){
				window.location.href="add";
		 });
    });

	function del(id)
	{
		
		if(confirm("确定要删除吗？"))
		{
			
			window.location.href=id+"/delete";
		}
	}
</script>