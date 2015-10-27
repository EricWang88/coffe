package login.web;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginCheck {
	// ユーザ名とパスワード
	// ログイン認証するメソッド
	// ユーザ名とパスワードが両方正しければ、trueを返す。
	public static boolean certify(String inputUserName, String inputPassword) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/wangbaosheng";

		// Database credentials
		final String USER = "root";
		final String PASS = "password";

		boolean certifyResult = false;

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT password FROM shiyang where name = '" + inputUserName + "';";
			ResultSet rs = stmt.executeQuery(sql);

			System.out.print(rs);
			// STEP 5: Extract data from result set
			while(rs.next()){
			String  check= rs.getString("password");
			if (check.equals(inputPassword) )
				certifyResult = true;
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try

		}// end try
		return certifyResult;

	}
}