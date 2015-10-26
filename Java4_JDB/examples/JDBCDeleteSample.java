import java.sql.*;

public class JDBCDeleteSample {
	public static void main(String args[]) {
		try {
			// Step1:JDBCドライバの登録
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.postgresql.Driver");
			
			// Step2:データベースの指定
			//String connect_string = "jdbc:mysql://jsrv:3306/empdb";
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			
			// Step3:データベースとの接続
			//Connection conn
			//	= DriverManager.getConnection(connect_string, "user", "user");
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");
			
			// Step4:Statementオブジェクトの取得
			Statement stmt = conn.createStatement();

			// Step5:テーブル更新
			int del = stmt.executeUpdate("DELETE FROM emp WHERE empno='7211'");

			// Step6:結果表示
			if(del == 0){
				System.err.println("Delete Data is not found.");
			}else{
				System.out.println("Data is deleted.");
			}

			// Step7:接続のクローズ
				conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
