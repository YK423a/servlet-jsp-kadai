package forms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormSevlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException {
		response.setContentType("text/html; charset=UTF-8");
		Cookie[] userCookies = request.getCookies();
		if(userCookies != null) {
			//配列内のクッキー名を順番に確認する
			for(Cookie cookie : userCookies) {
				//クッキー名に応じてデータを取得、保存
				switch(cookie.getName()) {
				case "name" : //お名前
					request.setAttribute("name" , cookie.getValue());
					break;
				case "mail" : //メール
					request.setAttribute("mail", cookie.getValue());
					break;
				case "address" : //住所
					request.setAttribute("address", cookie.getValue());
					break;
				case "tel" : //電話番号
					request.setAttribute("tel", cookie.getValue());
					break;
				default :
					break;
				}
			}
			
		}
		//フォワードによる画面遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/formPage.jsp");
		dispatcher.forward(request, response);						
	}
}
