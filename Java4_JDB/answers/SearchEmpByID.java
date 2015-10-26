import java.sql.*;

public class SearchEmpByID{
	public static void main(String args[]) {
		String empno;
		if(args.length == 0){
			System.err.println("引数に検索する社員番号を指定してください");
			System.exit(1);
		}
		empno = args[0];
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//データベースの指定
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			//データベースとの接続
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");

			//Statementオブジェクトを使用した場合
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM emp WHERE empno='" + empno + "'";
			ResultSet rset = stmt.executeQuery(sql);
			//PreparedStatementオブジェクトを使用した場合
			// String sql = "SELECT * FROM empJ WHERE empno=?";
			//PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1, empno);
			//ResultSet rset = ps.executeQuery();

			//出力
			if(rset.next()) {
				System.out.print("名　前：" + rset.getString("ename"));
				System.out.println("（" + rset.getString("kana") + "）");
				System.out.println("職　　：" + rset.getString("job") );
				System.out.println("月　給：" + rset.getString("sal") + " ");
				System.out.println("歩合給：" + rset.getString("comm") + " ");
				System.out.println("入社日：" + rset.getString("hiredate"));
			}else{
				System.err.println("EMPNO " + empno  + " に該当する社員は存在しません");
			}
				conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
