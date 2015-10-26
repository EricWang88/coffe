import java.sql.*;
import java.util.*;

public class JDBCCollectionSample {
	public static void main(String args[]) {
		try {
			// Step1:JDBC�h���C�o�̓o�^
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.postgresql.Driver");
			// Step2:�f�[�^�x�[�X�̎w��
			//String connect_string = "jdbc:mysql://jsrv:3306/empdb";
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			// Step3:�f�[�^�x�[�X�Ƃ̐ڑ�
			//Connection conn 
			//  = DriverManager.getConnection(connect_string, "user", "user");
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");
			// Step4:Statement�I�u�W�F�N�g�̎擾
			Statement stmt = conn.createStatement();
			// Step5:�₢���킹�̎��s
			ResultSet rset = stmt.executeQuery("SELECT * FROM emp");

			// Step6:�R���N�V�����ɕۑ�����
			ArrayList<Employee> list = new ArrayList<Employee>();
			while( rset.next() ) {
				int id = rset.getInt("empno");
				String name = rset.getString("ename");
				list.add(new Employee(id, name));
			}
			// Step7:�ڑ��̃N���[�Y
			conn.close();
			//���ʂ̕\��
			//�f�[�^�x�[�X�Ƃ̐ڑ����N���[�Y���Ă��A�f�[�^�𗘗p�ł���
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
