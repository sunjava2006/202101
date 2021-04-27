<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List,java.util.Set" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册信息</title>
</head>
<body>
 <%--@ include file="home.html" --%>

<%!
   String aa = "";

   void a(){
	   
   }
%>
<%
   // void b(){
	
    //}

    String a = "";
    String regName = (String)request.getAttribute("regName"); 
    String regInfo = (String)request.getAttribute("regInfo"); 
    out.write(regName+regInfo);
     
%>
<%=regName+regInfo %>
   <button onclick="location='/'">返回首页</button>
</body>
</html>