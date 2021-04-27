<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.List,com.wangrui.blog.bean.Article"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
.article{width:100%; margin-top:5px ; border-top:#06C solid 1px; border-right:white solid 3px;border-left:white solid 3px;}
.title{ font-size:14px; font-weight:bold; background:#9CF; border-bottom:#06c dotted 1px;}
.abs{ font-size:12px;}
.abs a{ font-size:12px; color:red; text-decoration:none}
.info{ text-align:right}
</style>

</head>

<body>
    <div style="border:#069 solid 1px; margin:0px 5px 5px 5px; width:98%; height:100%">
       <label style=" display:block; width:100%;  height:30px; line-height:30px; vertical-align:middle; text-align:left; font-size:14px; background:#069; color:white; "><font style="margin-left:10px;">最新文章</font></label>
        <!-- ------------------------------------------------------------------------->
   <c:forEach items="${requestScope.list }" var="i" varStatus="s">     
        <table class="article">
<%--             <tr> <td>${s.index }</td> --%>
                 <td class="title">${i.title }
                 </td>
            </tr>
            <tr>
                 <td class="abs" >
                   
                   ${f:substring(i.content,0,20)}
                   <a href="/showArticle?articleID=${i.aricleID }">阅读全文</a>
                 </td>
            </tr>
            <tr>
                 <td class="info" >
                         
                   <fm:formatDate value="${i.publishDate }" pattern="yyyy年MM月dd日"/>
                 </td>
            </tr>
        </table>
    </c:forEach>  
        <div>
           共${totalCount }文章，共${totalPage}页，当前是${currPage}第页.
    <c:if test="${currPage>1 }">      
           <a href="/ListArticleByBlog?blogID=${blogID}&page=${currPage-1}&size=8">上一页</a>
           
               <c:url value="/ListArticleByBlog" var="prePage" scope="page">
                  <c:param name="blogID" value="${blogID}"></c:param>
                  <c:param name="page" value="${currPage-1}"></c:param>
                  <c:param name="size" value="8"></c:param>
               </c:url>
          <a href=${prePage }>上页</a>
    </c:if>   
    <c:if test="${currPage<totalPage }">
           <a href="/ListArticleByBlog?blogID=${blogID}&page=${currPage+1}&size=8">下一页</a>
     </c:if>     
        </div>
    </div>
</body>
</html>
