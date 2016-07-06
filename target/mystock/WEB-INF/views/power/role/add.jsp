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
            <td width="10%" class="tableleft">角色名称</td>
            <td><input type="text" name="rolename" /></td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
                <input type="radio" name="state" value="0" checked/> 启用  <input type="radio" name="state" value="1"/> 禁用
            </td>
        </tr>
        <tr>
            <td class="tableleft">备注</td>
            <td>
                <input type="text" name="bz"/>
            </td>
        </tr>
        <tr>
            <td class="tableleft">权限</td>
            <td>
                <ul> <c:forEach items="${pmenus}" var="pmenu" >

                    <li><label class='checkbox inline'>
                        <input type='checkbox' name='menuname' value='${pmenu.menuid}'/>${pmenu.menuname}</label>
                        <c:forEach items="${cmenus}" var="cmenu">
                            <c:if test="${cmenu.pid == pmenu.menuid}">
                                <ul>
                                    <li><label class='checkbox inline'><input type='checkbox' name='menuname' value='${cmenu.menuid}'/>${cmenu.menuname}</label>
                                </ul>
                            </c:if>
                        </c:forEach>
                    </li>
                </c:forEach>
                </ul>
            </td>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
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

		$('#backid').click(function(){
				window.location.href="index.jsp";
		 });
    });
</script>