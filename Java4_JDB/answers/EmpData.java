import java.io.*;

//�V���A���C�[�[�V�������ꂽ�N���X
public class EmpData implements Serializable{
	private String empno;
	private String ename;
	private String kana;
	private String job;
	private String mgr;
	private int sal;
	private int comm;
	private String deptno;
	private String hiredate;
	
	//public�A�����Ȃ��̃R���X�g���N�^
	public EmpData(){}
	
	//�e�����o�ϐ��̃A�N�Z�T�E���\�b�h
	public void setEmpno(String empno){
		this.empno = empno;
	}
	public String getEmpno(){
		return empno;
	}
	public void setEname(String ename){
		this.ename = ename;
	}
	public String getEname(){
		return ename;
	}
	public void setKana(String kana){
		this.kana = kana;
	}
	public String getKana(){
		return kana;
	}
	public void setJob(String job){
		this.job = job;
	}
	public String getJob(){
		return job;
	}
	public void setMgr(String mgr){
		this.mgr = mgr;
	}
	public String getMgr(){
		return mgr;
	}
	public void setSal(int sal){
		this.sal = sal;
	}
	public int getSal(){
		return sal;
	}
	public void setComm(int comm){
		this.comm = comm;
	}
	public int getComm(){
		return comm;
	}
	public void setDeptno(String deptno){
		this.deptno = deptno;
	}
	public String getDeptno(){
		return deptno;
	}
	public void setHiredate(String hiredate){
		this.hiredate = hiredate;
	}
	public String getHiredate(){
		return hiredate;
	}
}
