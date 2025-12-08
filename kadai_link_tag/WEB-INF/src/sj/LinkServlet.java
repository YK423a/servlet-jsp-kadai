package sj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException,IOException {
		//jspから送信されたnameパラメータを取得
		String name = request.getParameter("name");
		//受信したnameパラメータでメッセージを作成
		String message = "Servletからデータを受信しました" + name + "さん、こんにちは";
		//メッセージをリクエストスコープにセット
		request.setAttribute("message", message);
		//index,jspにフォワードとして表示
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
