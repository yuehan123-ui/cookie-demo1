<%--
  Created by IntelliJ IDEA.
  User: 王政翔
  Date: 2022/12/10
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP登录</title>
    <style type="text/css">

    </style>
</head>
<body>

<form method = "POST" name = "login" action="systemLoginServlet">
    <input type ="text" name ="name"  value="${name}" ></br>
    <input type = "password" name="password" value="${password}" ></br>
    <span>
     	    <font color="red">  ${error}  </font>
     	 </span>
    </br>
    <input type="submit" name="登录">
    <input type = "reset" name="重置" >


</form>
</body>
</html>