import java.sql.*;

public class SearchEmpByJOB2{
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
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			//�f�[�^�x�[�X�Ƃ̐ڑ�
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");

			//PreparedStatement�I�u�W�F�N�g���g�p�����ꍇ
			PreparedStatement ps 
				= conn.prepareStatement("SELECT * FROM emp WHERE job=?");
			ps.setString(1, job);
			ResultSet rset = ps.executeQuery();

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
