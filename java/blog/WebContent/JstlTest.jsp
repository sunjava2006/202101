<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set scope="page" var="name" value="wang"></c:set>
<c:set scope="application" var="msg" value="功能正常"/>
<c:set scope="application" var="message" value="功能正常!!!"/>
<c:remove var="message" scope="application"/>
${pageScope.name}
${applicationScope.msg}
<c:out value="${message}" default="不正常!!!"/>

<c:catch var="exe">
<%
int a = 0/0;
%>

</c:catch>
<c:out value="${exe}"/>

<ul>
<c:forTokens items="a,b,c,d" delims="," var="i">
   <li>${i }
</c:forTokens>
</ul>
</body>
</html>