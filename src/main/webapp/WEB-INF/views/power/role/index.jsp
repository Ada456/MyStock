<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    System.out.println();
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
            margin-top: 20px;
            margin-bottom: 10px;
            margin-right: 24px;
        }
    </style>
</head>
<body>
     <button type="button" class="btn btn-success"  id="addnew">新增角色</button>
<table class="table table-bordered table-hover definewidth m10" >
    <th>
    <tr>
        <th>序号</th>
        <th>角色名称</th>
        <th>状态</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    </th>
    <c:forEach items="${roles}" var="role" varStatus="varStatus">
        <tr>
            <td>${varStatus.index+1}</td>
            <td>${role.rolename}</td>
            <td><c:if test="${role.state == 0}">启用</c:if><c:if test="${role.state == 1}">禁用</c:if></td>
            <td>${role.bz}</td>
            <td>
                <a href="${role.roleid}/edit">编辑</a>&nbsp;&nbsp;
                <a href="javascript:del(${role.roleid})">删除</a>
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