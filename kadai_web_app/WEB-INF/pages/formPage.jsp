<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Objects" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = (String) request.getAttribute("name");
String mail = (String) request.getAttribute("mail");
String address = (String) request.getAttribute("address");
String tel = (String) request.getAttribute("tel");
//データが存在しない場合は空文字に置き換え
name = Objects.toString(name,"");
mail = Objects.toString(mail,"");
address = Objects.toString(address,"");
tel = Objects.toString(tel,"");
%>
<h2>個人情報入力フォーム</h2>
<form action = "<%= request.getContextPath() %>/confirm" method="post">
<table>
	<tr>
		<td>氏名</td>
		<td>
			<input type="text" name = "name" value="<%= name %>">
		</td>
	</tr>
	<tr>
		<td>メールアドレス</td>
		<td>
			<input type="text" name= "mail" value="<%= mail %>">
		</td>
	</tr>
	<tr>
		<td>住所</td>
		<td>
			<input type="text" name="address" value="<%= address %>">
		</td>
	</tr>
	<tr>
		<td>電話番号</td>
		<td>
			<input type="text" name="tel" value="<%= tel %>">
		</td>
	</tr>
</table>
	<input type="submit" value="送信">
</form>
</body>
</html>