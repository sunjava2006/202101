<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.wangrui.blog.bean.User,com.wangrui.blog.bean.Blog"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
   @import url('./css/blog.css')
</style>

<body>


    <div id="page">
        <div id="head">
            <div id="menu_bar">
                <div id="menu_bar_img">
                        <img src="/img/dot.jpg"  style="margin:6px;float:left"/>
                        <ul id="logon">
<c:choose>    
  <c:when test="${empty sessionScope.userInfo }">                  
                        
                            <li><a href="reg_protocal.html">注册</a></li>
                            <li><label>|</label></li>
                            <li><a href="/Login.jsp">登录</a></li>
                            <li><label>|</label></li>
   </c:when>
   <c:otherwise> 
                    <li><label>你好：${userInfo.regName}</label> </li>
                    <li><label>|</label></li>    
                    <li><a href="/logout">退出</a></li>
                    <li><label>|</label></li>    
   </c:otherwise>                             
</c:choose>                             
                        </ul>
                
                
                </div>
                <div id="select">
                   
                    <select name="selectType" style="margin-top:5px;" >
                        <option>文章名</option>
                        <option>文章分类</option>
                        <option>博客名</option>
                    </select>
                    <input type="text" name="key"/>
                    <input type="button" value="检索"/>
                </div>
                <div id="about_blog">
<c:if test="${sessionScope.userInfo != null }">    
  <c:choose>   
     <c:when test="${not empty sessionScope.blogInfo }">         
                    <a href="/MyBlog.jsp">我的博客</a>
      </c:when>   
      <c:otherwise>           
                    <a href="applyBlog.jsp">申请博客</a>
      </c:otherwise>
  </c:choose>
</c:if>                   
                </div>
            </div>
        </div>
        <!-- =============== end of  head ============================================================ -->
        
        <div id="content">
            <div id="left">
                <div class="list" style="height:50%">
                     <label>文章分类</label>
                     <ul class="none_list">
                         <li><a >编程技巧</a></li>
                         <li><a >数据库知识</a></li>
                         <li><a >Java Web开发</a></li>
                     </ul>
                </div>
                <div class="list" style="height:50%">
                    <label>博客排名</label>
                    <ul class="decimal_list">
                         <li><a>鸟叔的Linux之门</a></li>
                         <li><a>Java编程随笔</a></li>
                         <li><a>Java教学知识点集汇</a></li>
                     </ul>
                </div>
            </div>
           <iframe id="main" src="index_content.html"></iframe>
        </div>
        <!-- =============== end of  content ======================================================== -->
        <div id="foot">
             总访问数：${accessCount }
                在线用户数：${currCount }
        在线会员数：${vipCount }
                <br>
            copyright &copy; wang rui.wisezone ltd.
        </div>
        
    </div>




</body>
</html>
    