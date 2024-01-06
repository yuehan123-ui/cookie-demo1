<%--
  Created by IntelliJ IDEA.
  User: 王政翔
  Date: 2022/11/10
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href='${returnURL}'>返回</a>
${rootname}下地市：</br>
<c:forEach items="${cityname}" var="i" varStatus="status">
    ${status.count}、 ${i}</br>
</c:forEach>
</body>
</html>
