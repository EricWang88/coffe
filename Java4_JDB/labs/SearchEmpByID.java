import java.sql.*;

public class SearchEmpByID{
	public static void main(String args[]) {
		String empno;
		if(args.length == 0){
			System.err.println("引数に検索する社員番号を指定してください");
			return;
		}
		empno = args[0];
		try {
			/* ★JDBCドライバの登録 */
			
			/* ★データベースの指定 */

			/* ★データベースとの接続 */

			/* ★Statementオブジェクト生成 */

			/* ★SQL実行 */

			/* ★結果の出力 */

			/* ★接続のクローズ */

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
