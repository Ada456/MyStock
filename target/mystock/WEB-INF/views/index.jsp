<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>库存管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="<%=basePath%>resources/assets/css/dpl-min.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/assets/css/bui-min.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/assets/css/main-min.css" type="text/css"/>
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">root</span><a href="/chinapost/index.php?m=Public&a=logout"
                                                                    title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform">
            <div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div>
        </div>
        <ul id="J_Nav" class="nav-list ks-clear">
            <c:forEach items="${pmenus}" var="menu" varStatus="varStatus">
                <c:if test="${menu.pid==0}">
                    <c:choose>
                        <c:when test="${varStatus.last}">
                            <li class="nav-item dl-selected">
                                <div class="nav-item-inner nav-home">${menu.menuname}</div>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item dl-selected">
                                <div class="nav-item-inner nav-order">${menu.menuname}</div>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </c:forEach>

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="<%=basePath%>resources/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/assets/js/bui-min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/assets/js/config-min.js"></script>
<script>
    var p=0;
    var c=10;
    BUI.use('common/main', function () {
        var config = [
            <c:forEach items="${pmenus}" var="menu1" varStatus="varStatus1">
            <c:if test="${!varStatus1.last}">
            {
                id: ++p,
//                homePage: c,
                menu: [{
                    text: '${menu1.menuname}',
                    items: [
                        <c:forEach items="${cmenus}" var="menu2" varStatus="varStatus2">
                        <c:if test="${menu2.pid== menu1.menuid && !varStatus2.last}">
                        {id: c++, text: '${menu2.menuname}', href: '${menu2.menuurl}'},
                        </c:if>

                        <c:if test="${menu2.pid== menu1.menuid && varStatus2.last}">
                        {id: '${varStatus1.index+varStatus2.index+2}', text: '${menu2.menuname}', href: '${menu2.menuurl}'}
                        </c:if>

                        </c:forEach>
                    ]
                }]
            },
            </c:if>
            <c:if test="${varStatus1.last}">
            {
                id: ++p,
                homePage: c,
                menu: [{
                    text: '${menu1.menuname}',
                    items: [
                        <c:forEach items="${cmenus}" var="menu2" varStatus="varStatus2">
                        <c:if test="${menu2.pid== menu1.menuid && !varStatus2.last}">
                        {id: c++, text: '${menu2.menuname}', href: '${menu2.menuurl}'},
                        </c:if>

                        <c:if test="${menu2.pid== menu1.menuid && varStatus2.last}">
                        {id: c++, text: '${menu2.menuname}', href: '${menu2.menuurl}'}
                        </c:if>
                        </c:forEach>
                    ]
                }]
            }
            </c:if>
            </c:forEach>, {
                id: '7',
                homePage: '9',
                menu: [{text: '业务管理', items: [{id: '9', text: '查询业务', href: 'Node/index.html'}]}]
            }];
        new PageUtil.MainPage({
            modulesConfig: config
        });
    });
</script>
</body>
</html>