<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.util.List,com.wangrui.blog.bean.Type"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <style>
            table{
                width: 800px;
                margin: auto;
                border: solid red 1px;
            }
        </style>
    </head>
    <body>
       <form action="/publishArticle" method="POST">
        <table>
            <tr>
                <td>文件标题<input type="text" name="title"></td>
            </tr>
            <tr>
                <td>文件类型
                    <select name="type" id="">
                    <% List<Type> list = (List<Type>)request.getAttribute("typeList");
                    out.print(list.size());
                       for(Type t: list){
                    %>
                        <option value="<%=t.getTypeID() %>"><%=t.getType() %></option>
                    <% } %>    
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <textarea name="content"  cols="100" rows="40"  ></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="发表">
                </td>
            </tr>
        </table>
    </form>
    </body>
    </html>