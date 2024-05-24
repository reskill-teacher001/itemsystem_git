<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>
	<h1>商品一覧</h1>
	<hr>
	
	<table border="1">
		<tr>
			<th>コード</th>
			<th>カテゴリコード</th>
			<th>商品名</th>
			<th>価格</th>
			<th>更新</th>
			<th>削除</th>
		</tr>
		
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.code}</td>
				<td>${item.categoryCode}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>
					<form action="/itemsystem_git/control" method="get">
						<input type="hidden" name="action" value="update">
						<input type="hidden" name="code" value="${item.code}">
						
						<input type="submit" value="更新">
					</form>
				</td>
				<td>
					<form action="/itemsystem_git/control" method="get">
						<input type="hidden" name="action" value="delete_exec">
						<input type="hidden" name="code" value="${item.code}">
						
						<input type="submit" value="削除">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="/itemsystem_git/control?action=insert">新規登録</a>
</body>
</html>