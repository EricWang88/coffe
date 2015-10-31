package login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		// ユーザが入力したユーザ名、パスワード取得
		String inputUserName = ((LoginForm) form).getUsername();
		String inputPassword = ((LoginForm) form).getPassword();

		// ユーザ認証後、画面遷移指定

		if (LoginCheck.certify(inputUserName, inputPassword)) {
			Object photo = null;
			Object name = null;
			Object basicinfo = null;
			Object likethis = null;
			Object mycomment = null;
			Object coupon = null;
			Object news = null;
			Object whatsnew = null;
			Object password = null;
			photo = LoginCheck.photo;
			name = LoginCheck.name;
			basicinfo = LoginCheck.basicinfo;
			likethis = LoginCheck.likethis;
			mycomment = LoginCheck.mycomment;
			coupon = LoginCheck.coupon;
			news = LoginCheck.news;
			password = LoginCheck.password;
			whatsnew = LoginCheck.whatsnew;
			request.setAttribute("photo", photo);
			request.setAttribute("name", name);
			request.setAttribute("basicinfo", basicinfo);
			request.setAttribute("likethis", likethis);
			request.setAttribute("mycomment", mycomment);
			request.setAttribute("coupon", coupon);
			request.setAttribute("news", news);
			request.setAttribute("whatsnew", whatsnew);
			request.setAttribute("password", password);
			return mapping.findForward("ok");
		} else {
			return mapping.findForward("ng");
		}
		// return super.execute(mapping, form, request, response);
	}
}
