import java.sql.*;
//JDBCTransactionSampleの実行結果を確認するためのプログラム
//deptJテーブルの depart_id に、70が追加されていないことを確認
public class ConfirmTransactionSample{
	public static void main(String args[]) {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//String connect_string = "jdbc:mysql://jsrv:3306/empdb";
			//Connection conn
			//	= DriverManager.getConnection(connect_string, "user", "user");
			Class.forName("org.postgresql.Driver");
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM dept");
			while( rset.next() ) {
				System.out.print( rset.getString("deptno") + " ");
				System.out.print( rset.getString("dname") + " ");
				System.out.println( rset.getString("loc") );
			}
				conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}