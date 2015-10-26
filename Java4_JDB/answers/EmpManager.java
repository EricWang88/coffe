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
		setTitle("従業員管理");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//フレーム上部---------------------------------------------------
		//タイトル
		JLabel titleLbl = new JLabel("従業員管理システム", JLabel.CENTER);
		titleLbl.setFont(new Font("SansSerif", Font.BOLD, 28));
		add(titleLbl, BorderLayout.NORTH);
		
		//操作ボタン
		newBtn = new JButton("新規登録");
		deleteBtn = new JButton("登録削除");
		updateBtn = new JButton("登録更新");
		searchBtn = new JButton("検索");
		displayBtn = new JButton("全データ表示");
		JPanel buttonP = new JPanel();
		buttonP.add(newBtn);
		buttonP.add(deleteBtn);
		buttonP.add(updateBtn);
		buttonP.add(searchBtn);
		buttonP.add(displayBtn);
	
		//フレーム中央---------------------------------------------------
		//DB情報を取得（OperateEmpData使用）
		oed = new OperateEmpData();
		
		//テーブルの項目名
		String columnNames[] = {"EMPNO", "ENAME", "KANA", "JOB", "SAL", "HIREDATE"};

		//テーブルのデータ取得
		list = oed.getAllEmpData();
		String data[][] = new String[list.size()][6];
		
		//リストにデータを追加
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
		//テーブル
		empTbl = new JTable(data, columnNames);
		//テーブルにスクロールバーを設定
		JScrollPane tblPane = new JScrollPane(empTbl);

		JPanel listP = new JPanel();
		listP.add(tblPane);
		
		JPanel centerP = new JPanel();
		centerP.setLayout(new BorderLayout());
		centerP.add(buttonP, BorderLayout.NORTH);
		centerP.add(listP, BorderLayout.CENTER);
		add(centerP, BorderLayout.CENTER);
		
		//リスナ登録
		newBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		displayBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		//新規登録
		if(e.getActionCommand().equals("新規登録")){
			System.out.println(e.getActionCommand());
		//登録削除
		}else if(e.getActionCommand().equals("登録削除")){
			System.out.println(e.getActionCommand());
		//登録更新
		}else if(e.getActionCommand().equals("登録更新")){
			System.out.println(e.getActionCommand());
		//検索
		}else if(e.getActionCommand().equals("検索")){
			System.out.println(e.getActionCommand());
		//全データ表示
		}else if(e.getActionCommand().equals("全データ表示")){
			list = oed.getAllEmpData();
		}
	}
	
	public static void main(String args[]){
		EmpManager frame = new EmpManager();
		frame.setVisible(true);
	}
}
