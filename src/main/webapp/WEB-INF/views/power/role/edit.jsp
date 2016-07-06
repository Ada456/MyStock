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
    </style>
</head>
<body>
<form action="update" method="post" class="definewidth m20">
    <input type="hidden" name="roleid" value="${editRole.roleid}"/>
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">角色名</td>
            <td><input type="text" name="rolename" value="${editRole.rolename}"/></td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
            <input type="radio" name="state" value="0"
                   <c:if test="${editRole.state == 0}">checked</c:if>/> 启用
            <input type="radio" name="state" value="1"
                   <c:if test="${editRole.state == 1}">checked</c:if>/> 禁用
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td><input type="text" name="bz"  value="${editRole.bz}"/></td>
        </tr>
        <tr>
            <td class="tableleft">权限</td>
            <td>
                <ul>
                    <c:forEach items="${pmenus}" var="pmenu" varStatus="varStatus">

                        <li><label class='checkbox inline'>
                            <input type='checkbox' name='menuname' value='${pmenu.menuid}' checked/>${pmenu.menuname}</label>
                            <c:forEach items="${cmenus}" var="cmenu" varStatus="varStatus">
                                <c:if test="${cmenu.pid == pmenu.menuid}">
                                    <ul>
                                        <li><label class='checkbox inline'><input type='checkbox' name='menuname' value='${cmenu.menuid}' checked/>${cmenu.menuname}</label>
                                    </ul>
                                </c:if>
                            </c:forEach>
                        </li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" id="submit" class="btn btn-primary">保存</button>
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
        $(':checkbox[name="group[]"]').click(function () {
            $(':checkbox', $(this).closest('li')).prop('checked', this.checked);
        });

        $('#backid').click(function () {
            window.location.href = "index.jsp";
        });

    });
</script>