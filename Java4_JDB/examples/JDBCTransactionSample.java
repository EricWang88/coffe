import java.sql.*;

public class JDBCTransactionSample {
	public static void main(String args[]) {
		Connection conn = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//String connect_string = "jdbc:mysql://jsrv:3306/empdb";
			//conn = DriverManager.getConnection(connect_string, "user", "user");
			Class.forName("org.postgresql.Driver");
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			conn = DriverManager.getConnection(connect_string, "sql99", "");
			Statement stmt = conn.createStatement();

			//step1:�I�[�g�R�~�b�g���I�t
			conn.setAutoCommit(false);

			//step2:�g�����U�N�V�����̋L�q
			stmt.executeUpdate("INSERT INTO dept VALUES('70','�J��','���')");
			//DEPART_ID���d�����đ}��
			stmt.executeUpdate("INSERT INTO dept VALUES('70','DEVELOPMENT','�i��')");

			//step3-1:�G���[���Ȃ���΃R�~�b�g
			conn.commit();
		}catch(Exception e){
			if(conn != null){
				try{
					//step3-2:�G���[�����������烍�[���o�b�N
					System.err.println("depart_id���d�����Ă��邽�߃f�[�^��ǉ��ł��܂���B");
					conn.rollback();
				}catch(SQLException se){}
			}
		}finally{
			//�G���[���������Ă����Ȃ��Ă��ڑ����N���[�Y
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException se){}
			}
		}
	}
}
