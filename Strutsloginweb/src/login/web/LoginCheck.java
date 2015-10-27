package login.web;

public class LoginCheck {
	// ユーザ名とパスワード
		private static String userName[] = {"taro", "hanako"};
		private static String password[] = {"taro123", "hanako123"};

		// ログイン認証するメソッド
		// ユーザ名とパスワードが両方正しければ、trueを返す。
		public static boolean certify(String u, String p) {
		    for(int i=0; i<userName.length; i++) {
		        if(u.equals(userName[i])) {
		            if(p.equals(password[i])) {
		                return true;
		            }
		            return false;
		        }
		    }
		    return false;
		}
}
