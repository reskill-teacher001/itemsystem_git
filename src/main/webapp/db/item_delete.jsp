<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キヤノン社員名簿</title>
</head>
<body>
	<h1>社員削除</h1>
	<hr>
	
	削除ボタンを押せば削除できます。

	<form action="/itemsystem_git/control" method="post">
		<input type="hidden" name="action" value="delete_exec">
		<input type="hidden" name="id" value="${user.id}">
		
		ID:${user.id}<br>
		名前:"${user.name}<br>
		年齢:"${user.age}<br>
		<br>
		<input type="submit" value="削除">
	</form>
</body>
</html>