<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アイテム</title>
</head>
<body>
	<h1>アイテム更新</h1>
	<hr>

	<form action="/itemsystem_git/control" method="post">
		<input type="hidden" name="action" value="update_exec">
		
		コード:<input type="text" name="code" value="${item.code}" readonly><br>
		カテゴリコード:<input type="text" name="categoryCode" value="${item.categoryCode}"><br>
		名前:<input type="text" name="name" value="${item.name}"><br>
		価格:<input type="text" name="price" value="${item.price}"><br>
		<br>
		<input type="submit" value="更新">
	</form>
</body>
</html>