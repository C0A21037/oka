<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>  
    <head>
        <meta charset="UTF-8">
        <title>テスト</title>
    </head>      
<body bgcolor="#000000" text="#ff0000" alink="#1e90ff" vlink="#8a2be2">
    <span style="font-family: NemukeMedium">
<h1 align="center">オカルトマップ</h1>
<p align="center">新規登録してください</p>

<form action= "./LoginSessionServlet" method="post">
<p align="center">ユーザ名：<input type="text" name="userid" required></p>
<p align="center">パスワード：<input type="password" name="pass"  required></p>
<p align="center"><input type="submit" value="認証"></p>
<p align="center"><a href="sessionlogin.jsp">ログイン画面へ</a></p>
</form>
</span>
</body>
</html>