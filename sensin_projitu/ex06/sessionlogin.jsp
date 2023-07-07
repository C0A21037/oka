<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>  
    <head>
        <meta charset="UTF-8">
        <title>テスト</title>
    </head>      
<body>
<h1 align="center">オカルトサイト</h1>
<p align="center">ログインしてください</p>

<form action= "./LoginSessionServlet" method="post">
<p align="center">ユーザ名：<input type="text" name="userid" required></p>
<p align="center">パスワード：<input type="password" name="pass"  required></p>
<p align="center"><input type="submit" value="認証"></p>
<p align="center"><a href="newuser.jsp" type="submit" >新規登録</a></p>
</form>
</body>
</html>