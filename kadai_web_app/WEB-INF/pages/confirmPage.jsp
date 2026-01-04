<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>入力内容をご確認ください</h2>
<p>問題がなければ「確定」、修正する場合は「キャンセル」をクリックしてください</p>
<table border="1">
	<tr>
		<th>項目</th>
		<th>入力内容</th>
	</tr>
	<tr>
		<td>氏名</td>
		<td>${name }</td>
	</tr>
	<tr>
		<td>メールアドレス</td>
		<td>${email }</td>
	</tr>
	<tr>
		<td>住所</td>
		<td>${address }</td>
	</tr>
	<tr>
		<td>電話番号</td>
		<td>${phone_number }</td>
	</tr>
</table>

<%
//バリデーションのチェック結果をservletから取得
ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("errorList");
//バリデーションngなら確定ボタンを無効化する
String disableconfirm =  (errorList != null) ? "disabled" : "";
%>
<p>
<%-- 確定ボタン（登録に成功した前提で完了画面遷移 --%>
<button onclick="location.href='<%= request.getContextPath() %>/complete';" <%= disableconfirm %>>確定</button>
<%-- キャンセル画面（前の画面に戻る --%>
<button onclick="history.back();">戻る</button>
</p>
<%
//バリデーションngならエラーメッセージを表示
if(errorList != null) {
	for(String errorMessage : errorList) {
		out.println("<font color=\"red\">" + errorMessage + "</font><br>");
	}
}
%>
</body>
</html>