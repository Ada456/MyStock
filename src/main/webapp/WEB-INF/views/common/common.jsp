<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/3 0003
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = "http://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//String basePath = "https://"+request.getServerName()+path+"/";
%>

    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/Css/style.css" />
    <script type="text/javascript" src="<%=basePath%>resources/Js/jquery.js"></script>
    <%--<script type="text/javascript" src="<%=basePath%>resources/Js/jquery.sorted.js"></script>--%>
    <script type="text/javascript" src="<%=basePath%>resources/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/Js/common.js"></script>

