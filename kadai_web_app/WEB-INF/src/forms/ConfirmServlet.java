package forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		//リクエストレスポンスの設定
		response.setContentType("text/html; charset=UTF-8");
		//jspからのデータ取得
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		//リクエストスコープにデータ保存
		request.setAttribute("name", name);
		request.setAttribute("mail", mail);
		request.setAttribute("address", address);
		request.setAttribute("tel", tel);
		//データが存在しない場合は空文字に置き換え
		name = Objects.toString(name,"");
		mail = Objects.toString(mail,"");
		address = Objects.toString(address,"");
		tel = Objects.toString(tel,"");
		//バリデーションngの時のメッセージを格納するリスト
		ArrayList<String> errorList = new ArrayList<String>();
		//お名前のバリデーション
		if("".equals(name.trim())){
			//未入力の場合
			errorList.add("お名前を入力してください");
		}
		//メールアドレスのバリデーション
		if("".equals(mail.trim())) {
			//未入力の場合
			errorList.add("メールアドレスを入力してください");
		} else if(!mail.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+$")) {
			errorList.add("メールアドレスの形式が正しくありません");
		}
		//住所のバリデーション
		if("".equals(address.trim())) {
			//未入力の場合
			errorList.add("住所を入力してください");
		}
		
		System.out.println("元の入力値: [" + tel + "]");
		tel = tel.trim()
		    .replaceAll("ー", "-")
		    .replaceAll("−", "-")
		    .replaceAll("‐", "-")
		    .replaceAll("－", "-");
		System.out.println("クリーニング後の値: [" + tel + "]");

		
		
//		電話番号のバリデーション
		if("".equals(tel)) {
			//未入力の場合
			errorList.add("電話番号を入力してください");
		}
		else if(!tel.matches("^0\\d{1,4}-\\d{1,4}-\\d{4}$")) {
		    errorList.add("電話番号が正しくありません");
		}
		System.out.println("電話番号のチェック完了");
		//エラーリストが空かどうか
		if(!errorList.isEmpty()) {
			//エラーがある場合はリストをリクエストスコープに登録
			request.setAttribute("errorList",errorList);
		} else {
			//セッションの取得
			HttpSession session = request.getSession();
			//セッションへのデータ登録
			session.setAttribute("name",name);
			session.setAttribute("mail", session);
			session.setAttribute("address", address);
			session.setAttribute("tel", tel);
			//クッキーに保存
//			setCookie(response,"name",name);
//			setCookie(response,"mail",mail);
//			setCookie(response,"address",address);
//			setCookie(response,"tel",tel);
		}
		//フォワードによる画面遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/confirmPage.jsp");
		dispatcher.forward(request,response);
		//新しいクッキーを設定するメソッド
	}
//	private void setCookie(HttpServletResponse response, String name, String value) {
//		Cookie cookie = new Cookie(name,value);
//		cookie.setMaxAge(60*60);
//		response.addCookie(cookie);
//	}
}
