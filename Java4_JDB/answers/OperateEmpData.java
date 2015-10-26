import java.util.*;
import java.sql.*;

public class OperateEmpData{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	//コンストラクタ
	public OperateEmpData(){
		try{
			//データベース接続
			Class.forName("org.postgresql.Driver");
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			conn = DriverManager.getConnection(connect_string, "sql99", "");
			//Statement取得
			stmt = conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//全レコードをコレクションで返す
	public ArrayList<EmpData> getAllEmpData(){
		//返却値用のコレクション（ArrayList）
		ArrayList<EmpData> list = new ArrayList<EmpData>();
		try{
			rs = stmt.executeQuery("SELECT * FROM emp");

			//1レコードを格納するオブジェクト（EmpData）
			EmpData empdata;

			while(rs.next()){
				//レコードの値をEmpDataオブジェクトに設定
				empdata = new EmpData();

				empdata.setEmpno(rs.getString("EMPNO"));
				empdata.setEname(rs.getString("ENAME"));
				empdata.setKana(rs.getString("KANA"));
				empdata.setJob(rs.getString("JOB"));
				empdata.setMgr(rs.getString("MGR"));
				empdata.setSal(rs.getInt("SAL"));
				empdata.setComm(rs.getInt("COMM"));
				empdata.setDeptno(rs.getString("DEPTNO"));
				empdata.setHiredate(rs.getString("HIREDATE").substring(0,10));
				list.add(empdata);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
