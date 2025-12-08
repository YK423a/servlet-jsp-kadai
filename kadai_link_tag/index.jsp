<%@ page contentType = "text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>トップ画面</title>
</head>
<body>
    <p>
        <a href="LinkServlet?name=侍太郎">名前「侍太郎」をServletに送信</a>
    </p>
    <%-- ↓Servletからのメッセージを表示（あれば） --%>
    <%
        String msg = (String)request.getAttribute("message");
        if (msg != null) {
    %>
            <%= msg %>
    <%
        }
    %>
</body>
</html>