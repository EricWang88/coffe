import java.sql.*;

public class SearchEmpByJOB{
	public static void main(String args[]) {
		String job;
		if(args.length == 0){
			System.err.println("�����Ɍ�������d�����w�肵�Ă�������");
			System.exit(1);;
		}
		job = args[0];
		try {
			//JDBC�h���C�o�̓o�^
			Class.forName("org.postgresql.Driver");
			//�f�[�^�x�[�X�̎w��
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/sql9901";
			//�f�[�^�x�[�X�Ƃ̐ڑ�
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");

			//Statement�I�u�W�F�N�g���g�p�����ꍇ
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM emp WHERE job='" + job + "'";
			ResultSet rset = stmt.executeQuery(sql);

			//�o��
			if(!rset.next()) {
				System.err.println("JOB " + job  + "�ɊY������Ј��͑��݂��܂���");
			}else{
				do {
					System.out.print(rset.getString("empno") );
					System.out.print("�@�@" + rset.getString("ename"));
					System.out.println("�i" + rset.getString("kana") + "�j");
				}while(rset.next());
			}
			conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
