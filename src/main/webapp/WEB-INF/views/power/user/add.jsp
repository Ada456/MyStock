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


    </style>
</head>
<body>
<form action="add" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">账号</td>
        <td><input type="text" name="logincode"/></td>
    </tr>
    <tr>
        <td class="tableleft">密码</td>
        <td><input type="password" name="password"/></td>
    </tr>
    <tr>
        <td class="tableleft">用户名</td>
        <td><input type="text" name="username"/></td>
    </tr>

    <tr>
        <td class="tableleft">状态</td>
        <td>
            <input type="radio" name="state" value="0" checked/> 启用
           <input type="radio" name="state" value="1"/> 禁用
        </td>
    </tr>
    <tr>
        <td class="tableleft">角色</td>
        <td>
            <select name="role.roleid">
            <option value="" selected>--请选择--</option>
            <c:forEach items="${sessionScope.roles}" var="role">
                <option value="${role.roleid} ">${role.rolename}</option>
            </c:forEach>
        </select>

        </td>
    </tr>
    <tr>
        <td class="tableleft">备注</td>
        <td><input type="text" name="bz"/></td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {
		$('#backid').click(function(){
				window.location.href="index.jsp";
		 });
    });
</script>