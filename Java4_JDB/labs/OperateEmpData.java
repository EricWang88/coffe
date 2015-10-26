import java.util.*;
import java.sql.*;

public class OperateEmpData{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	//コンストラクタ
	public OperateEmpData(){
		//データベース接続
		Class.forName("org.postgresql.Driver");
		String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
		conn = DriverManager.getConnection(connect_string, "sql99", "");
		//Statement取得
		stmt = conn.createStatement();
	}
	
	//全レコードをコレクションで返す
	public ArrayList<EmpData> getAllEmpData(){
		/* ★getAllEmpData()メソッドの処理 */
	}
}
