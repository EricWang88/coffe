import java.util.*;
import java.sql.*;

public class OperateEmpData{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	//�R���X�g���N�^
	public OperateEmpData(){
		try{
			//�f�[�^�x�[�X�ڑ�
			Class.forName("org.postgresql.Driver");
			String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
			conn = DriverManager.getConnection(connect_string, "sql99", "");
			//Statement�擾
			stmt = conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//�S���R�[�h���R���N�V�����ŕԂ�
	public ArrayList<EmpData> getAllEmpData(){
		//�ԋp�l�p�̃R���N�V�����iArrayList�j
		ArrayList<EmpData> list = new ArrayList<EmpData>();
		try{
			rs = stmt.executeQuery("SELECT * FROM emp");

			//1���R�[�h���i�[����I�u�W�F�N�g�iEmpData�j
			EmpData empdata;

			while(rs.next()){
				//���R�[�h�̒l��EmpData�I�u�W�F�N�g�ɐݒ�
				empdata = new EmpData();

				empdata.setEmpno(rs.getString("EMPNO"));
				empdata.setEname(rs.getString("ENAME"));
				empdata.setKana(rs.getString("KANA"));
				empdata.setJob(rs.getString("JOB"));
				empdata.setMgr(rs.getString("MGR"));
				empdata.setSal(rs.getInt("SAL"));
				empdata.setComm(rs.getInt("COMM"));
				empdata.setDeptno(rs.getString("DEPTNO"));
				empdata.setHiredate(rs.getString("HIREDATE").substring(0,10));
				list.add(empdata);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
