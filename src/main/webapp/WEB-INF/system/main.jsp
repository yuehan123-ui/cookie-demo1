<%--
  Created by IntelliJ IDEA.
  User: 王政翔
  Date: 2022/12/10
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理端</title>
</head>
<body>


<c:set  var="jstlDate"  value="<%=new Date() %>"></c:set>

欢迎 ${user.username} 来到Java Web 后台管理页面,当前登录时间：
<fmt:formatDate value="${jstlDate}" pattern="yyyy-MM-dd HH:mm:ss" />

<ul>
    <li> <!-- 使用绝对地址 -->
        <a href = "${pageContext.request.contextPath}/SysUserController" >用户管理</a>
    </li>
</ul>



</body>
</html>