import java.sql.*;

public class UpdateEmpData{
	public static void main(String args[]) {
		String empno, col, value;
		if(args.length != 3){
			System.err.println("引数に変更対象の社員番号、変更カラム名、"
								+ "変更後のデータを指定してください");
			System.exit(1);
		}
		empno = args[0];
		col   = args[1];
		value = args[2];
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//データベースの指定
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			//データベースとの接続
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");

			//Statementオブジェクト生成
			Statement stmt = conn.createStatement();
			//SQL実行
			String updateSql = "UPDATE emp SET "+ col + "='" + value +
			                   "' WHERE empno='" + empno + "'";
			String selectSql = "SELECT * FROM emp";
			int updateNum = stmt.executeUpdate(updateSql);

			//出力
			if(updateNum == 0) {
				System.err.println("EMPNO " + empno  + " に該当する社員は存在しません");
			}else{
				System.out.println(empno + " の " + col + " を " + value + " に変更しました。");
				System.out.println();
				System.out.println("EMPNO\tENAME(KANA)\tJOB\tMGR\tSAL\tCOMM\t"
									+ "DEPTNO\tHIREDATE");
				ResultSet rset = stmt.executeQuery(selectSql);
				while(rset.next()){
					System.out.print(rset.getString("empno"));
					System.out.print(" " + rset.getString("ename"));
					System.out.print("("  + rset.getString("kana") + ")");
					System.out.print("　" + rset.getString("job") );
					System.out.print("　" + rset.getString("mgr") );
					System.out.print("　" + rset.getString("sal") + " ");
					System.out.print("　" + rset.getString("comm") + " ");
					System.out.print("　" + rset.getString("deptno") + " ");
					System.out.println("　" + rset.getString("hiredate"));
				}
			}
			conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
