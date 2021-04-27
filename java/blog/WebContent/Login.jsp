<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        html,body{
            width: 100%;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .login{
            width: 800px;
            height: 600px;
            background-color: aquamarine;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        table{
            width: 600px;
            height: 400px;
            color: white;
            border: solid black 1px;
            background-color: teal;
        }
        .title{
            height: 100px;
            background-color: rgb(45, 69, 209);
            color:white;
            font-size: 50px;
        }
    </style>
</head>
<body>
    <div class="login">
        <form action="/login" method="post">
        <table>
            <tr>
                <th colspan="4" class="title">
                    用户登录
                </th>
               
            </tr>
            <tr>
                <td rowspan="3">
                    <img src="/img/logon.jpg" >
                </td>
                <td>登录名</td>
                <td><input type="text" name="regName" id="regName"></td>
                <td></td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input type="password" name="pwd" id="pwd">
                </td>
                <td></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td>
                    <input type="text" name="code" id="code">
                </td>
                <td>
<% 
    String code = String.valueOf((int)((Math.random()*10000)));
    session.setAttribute("code", code);
    out.print(code);
%>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="checkbox" name="autoLogin" >10天免登录
                </td>
                <td>
                    <%
                        Object o = request.getAttribute("msg");
                        if(null != o){
                        	out.print(o);
                        }
                    %>
                    ${msg}
                </td>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
    </div>
</body>
</html>