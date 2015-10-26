import java.sql.*;

public class JDBCSample {
	public static void main(String args[]) {
		try {
			// Step1:JDBCドライバの登録
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.postgresql.Driver");

			// Step2:データベースの指定
			//String connect_string = "jdbc:mysql://jsrv:3306/empdb";
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			
			// Step3:データベースとの接続
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");

			// Step4:Statementオブジェクトの取得
			Statement stmt = conn.createStatement();

			// Step5:問い合わせの実行
			ResultSet rset = stmt.executeQuery("SELECT * FROM emp");

			// Step6:結果の表示
			while( rset.next() ) {
				System.out.print( rset.getString("empno") + " ");
				System.out.println( rset.getString("ename") );
			}
			// Step7:接続のクローズ
				conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}