import java.sql.*;

public class SearchEmpByID{
	public static void main(String args[]) {
		String empno;
		if(args.length == 0){
			System.err.println("�����Ɍ�������Ј��ԍ����w�肵�Ă�������");
			System.exit(1);
		}
		empno = args[0];
		try {
			//JDBC�h���C�o�̓o�^
			Class.forName("org.postgresql.Driver");
			//�f�[�^�x�[�X�̎w��
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			//�f�[�^�x�[�X�Ƃ̐ڑ�
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");

			//Statement�I�u�W�F�N�g���g�p�����ꍇ
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM emp WHERE empno='" + empno + "'";
			ResultSet rset = stmt.executeQuery(sql);
			//PreparedStatement�I�u�W�F�N�g���g�p�����ꍇ
			// String sql = "SELECT * FROM empJ WHERE empno=?";
			//PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1, empno);
			//ResultSet rset = ps.executeQuery();

			//�o��
			if(rset.next()) {
				System.out.print("���@�O�F" + rset.getString("ename"));
				System.out.println("�i" + rset.getString("kana") + "�j");
				System.out.println("�E�@�@�F" + rset.getString("job") );
				System.out.println("���@���F" + rset.getString("sal") + " ");
				System.out.println("�������F" + rset.getString("comm") + " ");
				System.out.println("���Г��F" + rset.getString("hiredate"));
			}else{
				System.err.println("EMPNO " + empno  + " �ɊY������Ј��͑��݂��܂���");
			}
				conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
