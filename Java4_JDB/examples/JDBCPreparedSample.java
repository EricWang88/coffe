import java.sql.*;

public class JDBCPreparedSample{
	public static void main(String args[]){
		try{
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
			// Step4:PreparedStatement�I�u�W�F�N�g�̎擾
			PreparedStatement ps = 
			conn.prepareStatement("SELECT * FROM emp WHERE job=?");
			// Step5:�p�����[�^�̐ݒ�Ɩ₢���킹�̎��s
			// �p�����[�^�̍쐬
			String para[] = {"�c��", "�Ǘ���", "����"} ;
			for(int i = 0; i < para.length; i++) {
				// �p�����[�^�̐ݒ�
				ps.setString(1, para[i]);
				// �₢���킹�̎��s
				ResultSet rs = ps.executeQuery();
			// Step6:���ʕ\���i�f�[�^�̗L���m�F�j
				if(!rs.next()){
					System.out.println(para[i] + " is not in this table.");
					continue;
				}
			}
			// Step7:�ڑ��̃N���[�Y
				conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
