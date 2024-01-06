<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="now" value="<%= new Date()%>"/>
<h1>欢迎${user.username}来到Java web！页面</h1>
当前登录时间：
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>  </br>
当前省份: <a href="${pageContext.request.contextPath}/CityServlet?rootname=${rootname}&returnURL=${returnURL}" >${rootname} </a> </br>
该省份下的城市：</br>
<c:forEach items="${cityname}" var="i" varStatus="status">
    ${status.count}、<a href="${pageContext.request.contextPath}/CityServlet?rootname= ${i}&returnURL=${returnURL}" > ${i} </a></br>
</c:forEach>
</body>
</html>