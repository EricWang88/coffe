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
		String inputUserName = ((LoginForm)form).getUsername();
		String inputPassword = ((LoginForm)form).getPassword();

		// ユーザ認証後、画面遷移指定
		if(LoginCheck.certify(inputUserName, inputPassword)) {
			return mapping.findForward("ok");
		} else {
			return mapping.findForward("ng");
		}
		//return super.execute(mapping, form, request, response);
	}
}
