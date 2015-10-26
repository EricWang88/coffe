import java.sql.*;

public class SearchEmpByJOB2{
	public static void main(String args[]) {
		String job;
		if(args.length == 0){
			System.err.println("引数に検索する仕事を指定してください");
			System.exit(1);;
		}
		job = args[0];
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//データベースの指定
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			//データベースとの接続
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");

			//PreparedStatementオブジェクトを使用した場合
			PreparedStatement ps 
				= conn.prepareStatement("SELECT * FROM emp WHERE job=?");
			ps.setString(1, job);
			ResultSet rset = ps.executeQuery();

			//出力
			if(!rset.next()) {
				System.err.println("JOB " + job  + "に該当する社員は存在しません");
			}else{
				do {
					System.out.print(rset.getString("empno") );
					System.out.print("　　" + rset.getString("ename"));
					System.out.println("（" + rset.getString("kana") + "）");
				}while(rset.next());
			}
			conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
