<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    pageContext.setAttribute("msg", "pageMsg");
    request.setAttribute("msg", "requestMsg");
    session.setAttribute("msg", "sessionMsg");
    application.setAttribute("msg", "appMsg");
    String[] interesting = request.getParameterValues("interesting");
    for(String s: interesting){
    	System.out.println(s);
    }
    
%>

   ${pageScope.msg}
   ${requestScope.msg }
   ${sessionScope.msg }
   ${applicationScope.msg }
   
   ${param.name}
   ${param.age}
   ${paramValues.interesting[0] }
   ${paramValues.interesting[1] }
   ${paramValues.interesting[2] }
   <hr>
   ${2*7}
   ${param.name+param.age}
   <form action="#" method="get">
      <input type="checkbox" name="interesting" value="read">阅读
      <input type="checkbox" name="interesting" value="travel">旅行
      <input type="checkbox" name="interesting" value="swimming">游泳
      <input type="submit">
   </form>
</body>
</html>