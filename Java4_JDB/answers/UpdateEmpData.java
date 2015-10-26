import java.sql.*;

public class UpdateEmpData{
	public static void main(String args[]) {
		String empno, col, value;
		if(args.length != 3){
			System.err.println("�����ɕύX�Ώۂ̎Ј��ԍ��A�ύX�J�������A"
								+ "�ύX��̃f�[�^���w�肵�Ă�������");
			System.exit(1);
		}
		empno = args[0];
		col   = args[1];
		value = args[2];
		try {
			//JDBC�h���C�o�̓o�^
			Class.forName("org.postgresql.Driver");
			//�f�[�^�x�[�X�̎w��
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			//�f�[�^�x�[�X�Ƃ̐ڑ�
			Connection conn
				= DriverManager.getConnection(connect_string, "sql99", "");

			//Statement�I�u�W�F�N�g����
			Statement stmt = conn.createStatement();
			//SQL���s
			String updateSql = "UPDATE emp SET "+ col + "='" + value +
			                   "' WHERE empno='" + empno + "'";
			String selectSql = "SELECT * FROM emp";
			int updateNum = stmt.executeUpdate(updateSql);

			//�o��
			if(updateNum == 0) {
				System.err.println("EMPNO " + empno  + " �ɊY������Ј��͑��݂��܂���");
			}else{
				System.out.println(empno + " �� " + col + " �� " + value + " �ɕύX���܂����B");
				System.out.println();
				System.out.println("EMPNO\tENAME(KANA)\tJOB\tMGR\tSAL\tCOMM\t"
									+ "DEPTNO\tHIREDATE");
				ResultSet rset = stmt.executeQuery(selectSql);
				while(rset.next()){
					System.out.print(rset.getString("empno"));
					System.out.print(" " + rset.getString("ename"));
					System.out.print("("  + rset.getString("kana") + ")");
					System.out.print("�@" + rset.getString("job") );
					System.out.print("�@" + rset.getString("mgr") );
					System.out.print("�@" + rset.getString("sal") + " ");
					System.out.print("�@" + rset.getString("comm") + " ");
					System.out.print("�@" + rset.getString("deptno") + " ");
					System.out.println("�@" + rset.getString("hiredate"));
				}
			}
			conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
