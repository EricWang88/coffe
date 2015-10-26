import java.sql.*;

public class JDBCSample {
	public static void main(String args[]) {
		try {
			// Step1:JDBC�h���C�o�̓o�^
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.postgresql.Driver");

			// Step2:�f�[�^�x�[�X�̎w��
			//String connect_string = "jdbc:mysql://jsrv:3306/empdb";
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			
			// Step3:�f�[�^�x�[�X�Ƃ̐ڑ�
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");

			// Step4:Statement�I�u�W�F�N�g�̎擾
			Statement stmt = conn.createStatement();

			// Step5:�₢���킹�̎��s
			ResultSet rset = stmt.executeQuery("SELECT * FROM emp");

			// Step6:���ʂ̕\��
			while( rset.next() ) {
				System.out.print( rset.getString("empno") + " ");
				System.out.println( rset.getString("ename") );
			}
			// Step7:�ڑ��̃N���[�Y
				conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}