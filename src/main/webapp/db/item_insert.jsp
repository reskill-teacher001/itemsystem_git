<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アイテム登録</title>
</head>
<body>
	<h1>アイテム登録</h1>
	<hr>

	<form action="/itemsystem_git/control" method="post">
		<input type="hidden" name="action" value="insert_exec">
		
		カテゴリコード:<input type="text" name="categoryCode"><br>
		名前:<input type="text" name="name"><br>
		価格:<input type="text" name="price"><br>
		<br>
		<input type="submit" value="登録">
	</form>
</body>
</html>