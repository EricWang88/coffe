import java.sql.*;

public class JDBCPreparedSample{
	public static void main(String args[]){
		try{
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
			// Step4:PreparedStatementオブジェクトの取得
			PreparedStatement ps = 
			conn.prepareStatement("SELECT * FROM emp WHERE job=?");
			// Step5:パラメータの設定と問い合わせの実行
			// パラメータの作成
			String para[] = {"営業", "管理者", "事務"} ;
			for(int i = 0; i < para.length; i++) {
				// パラメータの設定
				ps.setString(1, para[i]);
				// 問い合わせの実行
				ResultSet rs = ps.executeQuery();
			// Step6:結果表示（データの有無確認）
				if(!rs.next()){
					System.out.println(para[i] + " is not in this table.");
					continue;
				}
			}
			// Step7:接続のクローズ
				conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
