<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//セッションの取得
String name = (String) session.getAttribute("name");
%>
<h2><%= name %>さん、お問い合わせ内容を承りました。</h2>
<p>今後の参考にさせて頂きます。</p>
<%--  戻るボタンのフォーム   --%>
<button onclick="location.href='<%= request.getContextPath()  %>/form';">戻る</button>
</body>
</html>