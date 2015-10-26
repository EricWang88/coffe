import java.sql.*;

public class JDBCDeleteSample {
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
			//	= DriverManager.getConnection(connect_string, "user", "user");
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");
			
			// Step4:Statement�I�u�W�F�N�g�̎擾
			Statement stmt = conn.createStatement();

			// Step5:�e�[�u���X�V
			int del = stmt.executeUpdate("DELETE FROM emp WHERE empno='7211'");

			// Step6:���ʕ\��
			if(del == 0){
				System.err.println("Delete Data is not found.");
			}else{
				System.out.println("Data is deleted.");
			}

			// Step7:�ڑ��̃N���[�Y
				conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
