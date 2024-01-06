<%--
  Created by IntelliJ IDEA.
  User: 王政翔
  Date: 2022/12/10
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>后台管理端-用户管理页面</title>
</head>
<body>

<table  border="1">
  <tr>
    <td>用户Id</td>
    <td>用户名</td>
    <td>性别</td>
    <td>地址</td>
    <td>管理</td>
  </tr>
  <!--  使用JSTL循环 -->

  <c:forEach items="${userList}" var="user"> <%--items: 被遍历的容器 var：产生的临时变量--%>
    <tr>
      <td>${user.userId}</td>
      <td>${user.userName}</td>
      <td>${user.sex}</td>
      <td>${user.address}</td>
      <td>
        <a href="">详情</a>
        <a href="">删除</a>
        <a href="">修改</a>
      </td>
    </tr>
  </c:forEach>

</table>




</body>
</html>