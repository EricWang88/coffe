package login.web;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
	private String username;  // ユーザ名
	private String password;  // パスワード

		public LoginForm() {
			username = password = "";
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
}
