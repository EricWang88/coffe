import java.sql.*;

public class JDBCTransactionSample {
	public static void main(String args[]) {
		Connection conn = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//String connect_string = "jdbc:mysql://jsrv:3306/empdb";
			//conn = DriverManager.getConnection(connect_string, "user", "user");
			Class.forName("org.postgresql.Driver");
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			conn = DriverManager.getConnection(connect_string, "sql99", "");
			Statement stmt = conn.createStatement();

			//step1:オートコミットをオフ
			conn.setAutoCommit(false);

			//step2:トランザクションの記述
			stmt.executeUpdate("INSERT INTO dept VALUES('70','開発','川崎')");
			//DEPART_IDを重複して挿入
			stmt.executeUpdate("INSERT INTO dept VALUES('70','DEVELOPMENT','品川')");

			//step3-1:エラーがなければコミット
			conn.commit();
		}catch(Exception e){
			if(conn != null){
				try{
					//step3-2:エラーが発生したらロールバック
					System.err.println("depart_idが重複しているためデータを追加できません。");
					conn.rollback();
				}catch(SQLException se){}
			}
		}finally{
			//エラーが発生してもしなくても接続をクローズ
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException se){}
			}
		}
	}
}
