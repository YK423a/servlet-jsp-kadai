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
String email = (String) request.getAttribute("email");
String address = (String) request.getAttribute("address");
String phone_number = (String) request.getAttribute("phone_number");
//データが存在しない場合は空文字に置き換え
name = Objects.toString(name,"");
email = Objects.toString(email,"");
address = Objects.toString(address,"");
phone_number = Objects.toString(phone_number,"");
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
			<input type="text" name= "email" value="<%= email %>">
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
			<input type="text" name="phone_number" value="<%= phone_number %>">
		</td>
	</tr>
</table>
	<input type="submit" value="送信">
</form>
</body>
</html>