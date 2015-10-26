import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class EmpManager extends JFrame implements ActionListener{
	private JButton newBtn, deleteBtn, updateBtn, searchBtn, displayBtn;
	private JTable empTbl;
	ArrayList<EmpData> list;
	OperateEmpData oed;
	
	public EmpManager(){
		setTitle("�]�ƈ��Ǘ�");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//�t���[���㕔---------------------------------------------------
		//�^�C�g��
		JLabel titleLbl = new JLabel("�]�ƈ��Ǘ��V�X�e��", JLabel.CENTER);
		titleLbl.setFont(new Font("SansSerif", Font.BOLD, 28));
		add(titleLbl, BorderLayout.NORTH);
		
		//����{�^��
		newBtn = new JButton("�V�K�o�^");
		deleteBtn = new JButton("�o�^�폜");
		updateBtn = new JButton("�o�^�X�V");
		searchBtn = new JButton("����");
		displayBtn = new JButton("�S�f�[�^�\��");
		JPanel buttonP = new JPanel();
		buttonP.add(newBtn);
		buttonP.add(deleteBtn);
		buttonP.add(updateBtn);
		buttonP.add(searchBtn);
		buttonP.add(displayBtn);
	
		//�t���[������---------------------------------------------------
		//DB�����擾�iOperateEmpData�g�p�j
		oed = new OperateEmpData();
		
		//�e�[�u���̍��ږ�
		String columnNames[] = {"EMPNO", "ENAME", "KANA", "JOB", "SAL", "HIREDATE"};

		//�e�[�u���̃f�[�^�擾
		list = oed.getAllEmpData();
		String data[][] = new String[list.size()][6];
		
		//���X�g�Ƀf�[�^��ǉ�
		int i = 0;
		for(EmpData ed : list){
			data[i][0] = ed.getEmpno();
			data[i][1] = ed.getEname();
			data[i][2] = ed.getKana();
			data[i][3] = ed.getJob();
			data[i][4] = Integer.toString(ed.getSal());
			data[i][5] = ed.getHiredate();
			i++;
		}
		//�e�[�u��
		empTbl = new JTable(data, columnNames);
		//�e�[�u���ɃX�N���[���o�[��ݒ�
		JScrollPane tblPane = new JScrollPane(empTbl);

		JPanel listP = new JPanel();
		listP.add(tblPane);
		
		JPanel centerP = new JPanel();
		centerP.setLayout(new BorderLayout());
		centerP.add(buttonP, BorderLayout.NORTH);
		centerP.add(listP, BorderLayout.CENTER);
		add(centerP, BorderLayout.CENTER);
		
		//���X�i�o�^
		newBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		displayBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		//�V�K�o�^
		if(e.getActionCommand().equals("�V�K�o�^")){
			System.out.println(e.getActionCommand());
		//�o�^�폜
		}else if(e.getActionCommand().equals("�o�^�폜")){
			System.out.println(e.getActionCommand());
		//�o�^�X�V
		}else if(e.getActionCommand().equals("�o�^�X�V")){
			System.out.println(e.getActionCommand());
		//����
		}else if(e.getActionCommand().equals("����")){
			System.out.println(e.getActionCommand());
		//�S�f�[�^�\��
		}else if(e.getActionCommand().equals("�S�f�[�^�\��")){
			list = oed.getAllEmpData();
		}
	}
	
	public static void main(String args[]){
		EmpManager frame = new EmpManager();
		frame.setVisible(true);
	}
}
