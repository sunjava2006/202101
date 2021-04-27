<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    table{
        width: 600px;
        height: 300px;
        margin: auto;
        border: solid grey 2px;
    }
</style>
</head>
<body>
    <form action="applyBlog" method="POST" enctype="multipart/form-data">
        <table>
            <tr>
                <th colspan="3">
                    申请博客
                </th>
            </tr>
            <tr>
                <td>博客名</td>
                <td><input type="text" name="blogName"></td>
                <td></td>
            </tr>
            <tr>
                <td>昵称</td>
                <td><input type="text" name="nickName" ></td>
                <td></td>
            </tr>
            <tr>
                <td>照片</td>
                <td><input type="file" name="photo"></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td><input type="submit" value="申请"></td>
            </tr>
        </table>
    
    </form>
</body>
</html>