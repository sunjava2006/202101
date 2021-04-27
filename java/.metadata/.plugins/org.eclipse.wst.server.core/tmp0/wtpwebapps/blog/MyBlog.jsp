<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="com.wangrui.blog.bean.*"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/blog.css" rel="stylesheet"></link>
    <style>
        #head{
            height: 138px;
            font-size: 80px;
            text-indent: 80px;
            color: white;
        }
        #menu_bar{
            top: 0;
        }
        .photo{
            width: 160px;
            height:200px;
           
            
        }
        .list{
            display: flex;
            justify-content: center;
            align-items:center;
            flex-direction:column;
        }
        .nickName{
            text-align:center;
        }
    </style>
    </head>
    
    <body>
    
    
        <div id="page">
            <div id="head" style="background-image:url('img/banel_b.jpg');">
                <%-- Object o = session.getAttribute("blogInfo");
                   Blog blog =null;
                   if(null != o){
                	   blog = (Blog)o;
                	   out.write(blog.getBlogName());
                   }
                --%>
                ${blogInfo.blogName}
            </div>
            <div id="menu_bar">
                <div id="menu_bar_img">
                        <img src="img/dot.jpg"  style="margin:6px;float:left"/>
                        <ul id="logon">
                            <li><a href="/NewArticlePag" target="main">新建博文</a></li>
                           
                            
                        </ul>
                
                
                </div>
               
                <div id="about_blog">
                   
                    <a href="/">首页</a>
                </div>
            </div>
            <!-- =============== end of  head ============================================================ -->
            
            <div id="content">
                <div id="left">
                    <div class="list" style="height:50%">
                        <img src='/photos/${sessionScope.blogInfo["photo"] }' class="photo">
                        <div class="nickName">
		                   ${blogInfo.nickName}
		                </div>
                    </div>
                   
                </div>
               <iframe name="main" src="/ListArticleByBlog?blogID=${sessionScope.blogInfo.blogID }"
                style="width:941px; height:768px; border:0;overflow-y: scroll;"></iframe>
            </div>
            <!-- =============== end of  content ======================================================== -->
            <div id="foot">
                copyright &copy; wang rui.wisezone ltd.
            </div>
            
        </div>
    
    
    
    
    </body>
    </html>
    