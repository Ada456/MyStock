<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
    </style>
</head>
<body>

<form action="update" method="post" class="definewidth m20">
    <input type="hidden" name="userid" value="${editUser.userid}"/>
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">登陆账号</td>
            <td><input type="text" name="logincode" value="${editUser.logincode}"/></td>
        </tr>
        <tr>
            <td class="tableleft">用户姓名</td>
            <td><input type="text" name="username" value="${editUser.username}"/></td>
        </tr>
        <%--<tr>--%>
        <%--<td class="tableleft">密码</td>--%>
        <%--<td><input type="password" name="password"/></td>--%>
        <%--</tr>--%>
        <tr>
            <td class="tableleft">角色</td>
            <td><select name="role.roleid">
                <c:forEach items="${sessionScope.roles}" var="role">
                <c:choose>
                    <c:when test="${role.roleid == editUser.role.roleid}">
                        <option value="${editUser.role.roleid}" selected>${editUser.role.rolename}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${role.roleid}">${role.rolename}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
                <input type="radio" name="state" value="0"
                       <c:if test="${editUser.state == 0}">checked</c:if>/>启用
                <input type="radio" name="state" value="1"
                       <c:if test="${editUser.state == 1}">checked</c:if>/> 禁用
            </td>
        </tr>
        <tr>
            <td class="tableleft">备注</td>
            <td><input type="text" name="bz" value="${editUser.bz}"/></td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary">保存</button>
                &nbsp;&nbsp;
                <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script>
    $(function () {
        $('#backid').click(function () {
            window.location.href = "{:U('User/index')}";
        });
    });
</script>