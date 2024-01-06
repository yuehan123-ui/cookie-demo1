<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    Object error = request.getAttribute("error");
%>
<form action="loginServlet" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <span style="color: red; "><%=(error==null?"":error)%></span>
    <input type="submit" value="提交">
    <input type="reset" value="重置">

</form>
</body>
</html>