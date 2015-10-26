import java.sql.*;
import java.util.*;

public class JDBCCollectionSample {
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
			//  = DriverManager.getConnection(connect_string, "user", "user");
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");
			// Step4:Statementオブジェクトの取得
			Statement stmt = conn.createStatement();
			// Step5:問い合わせの実行
			ResultSet rset = stmt.executeQuery("SELECT * FROM emp");

			// Step6:コレクションに保存する
			ArrayList<Employee> list = new ArrayList<Employee>();
			while( rset.next() ) {
				int id = rset.getInt("empno");
				String name = rset.getString("ename");
				list.add(new Employee(id, name));
			}
			// Step7:接続のクローズ
			conn.close();
			//結果の表示
			//データベースとの接続をクローズしても、データを利用できる
			for(Employee emp : list){
					System.out.println(emp.getId() + " " + emp.getName());
			}
		} catch(Exception e) {
			System.out.println( e.getMessage() );
			e.printStackTrace();
		}
	}
}

class Employee{
	private int id;
	private String name;
	public Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
}
