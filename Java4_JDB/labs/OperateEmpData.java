import java.util.*;
import java.sql.*;

public class OperateEmpData{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	//�R���X�g���N�^
	public OperateEmpData(){
		//�f�[�^�x�[�X�ڑ�
		Class.forName("org.postgresql.Driver");
		String connect_string = "jdbc:postgresql://172.16.1.100:5432/user01";
		conn = DriverManager.getConnection(connect_string, "sql99", "");
		//Statement�擾
		stmt = conn.createStatement();
	}
	
	//�S���R�[�h���R���N�V�����ŕԂ�
	public ArrayList<EmpData> getAllEmpData(){
		/* ��getAllEmpData()���\�b�h�̏��� */
	}
}
