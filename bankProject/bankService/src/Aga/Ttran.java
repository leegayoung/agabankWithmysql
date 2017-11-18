package Aga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import databaseInfos.DataBaseWork;
import databaseInfos.dataSave;

public class Ttran{
	
	public JFrame mainf = new JFrame();
	public JPanel mainp = new JPanel();
	Font font1 = new Font("배달의민족 주아", Font.PLAIN, 50) ;
	Font font1_1 = new Font("배달의민족 주아", Font.PLAIN, 40) ;
	Font font2 = new Font("-윤고딕110", Font.PLAIN, 20) ;
	JTable table;
	DefaultTableModel m;
	
	public Ttran(){
		
		mainf.setSize(1280,800);
		mainp.setSize(1280,800);
		
		JPanel action = new JPanel();
		JPanel board = new JPanel();
		JPanel keypad = new JPanel();
		JPanel input = new JPanel();
		JPanel pbt = new JPanel();
		
		mainf.setLayout(null);
		mainp.setLayout(null);
		action.setLayout(null);
		board.setLayout(null);
		keypad.setLayout(new GridLayout(5,3));
		input.setLayout(null);
		
		pbt.setSize(300,100); //액션바 버튼
		action.setSize(1280,100); //액션바
		board.setSize(1280,800); //하단 패널
		input.setSize(855,620); //입력창
		keypad.setSize(370,620); //키패드
		
		board.setLocation(0,-10);
		
		JButton jb = new JButton(new ImageIcon("image/backbt.png"));
		jb.setBorderPainted(false);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
	
		JLabel jla = new JLabel("잔액조회 ");
		jla.setFont(font1_1);
		jla.setForeground(Color.white);
	
	
		pbt.add(jb,BorderLayout.WEST);
		pbt.setBackground(new Color(46,89,138));
		pbt.add(jla);
		
		action.setBackground(new Color(46,89,138));
		action.add(pbt);
	
		
		input.setLocation(20,130);
		input.setBackground(Color.white);
		
		
		
		//통장화면 만들기
		ImageIcon bg = new ImageIcon("image/bankbook.png");
		
		DataBaseWork db = new DataBaseWork();
		dataSave ds1 = new dataSave();
		String s = db.allInfo_Acc_Info(ds1.getMyacc(),3);
		
		
		JLabel money = new JLabel(s);
		
		money.setFont(font1);
		money.setLocation(180,20);
		money.setSize(1000,100);
		money.setForeground(new Color(207,169,120));
	
		
		
		JPanel bankbook = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bg.getImage(), 0, 0, null);

			}
		};
		bankbook.setLayout(null);
		bankbook.setBounds(0, 0, 835, 600);
		bankbook.setLocation(10,20);
		
		input.add(money);
	
		dataSave ds = new dataSave();
		
		String[] title={"날짜","입금자","예금주","분류","거래내역","잔액","비고","계좌번호"};
		String[] info ={"161651&16516165&65165156&65165156&16516165&65165156&16516165&65165156",null,null,null,null};
		
		String data[][] = new String[5][8];
		String nullChk ="-&-&-&-&-&-&-&-";
		
		for(int i = 0 ; i < 5 ; i++){
		
			if(ds.info[i]==null){
				
				data[i] = nullChk.split("&");
				
			}else  if( i < ds.info.length ){
				
			data[i] = ds.info[i].split("&");
			
			}
			
			System.out.println("#######"+data[i]);
		}
		
		
		//JTable 	table= new JTable(data,title);
		
		//DefaultTableModel m = (DefaultTableModel) table.getModel();
		//m.setRowCount(0);
		
		 m = new DefaultTableModel(data, title);
		
		
		table = new JTable(m);
		m.fireTableDataChanged();
		
		
		
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setWidth(200);
		
		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		 
		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		 
		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule = table.getColumnModel();
		 
		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		
		
		table.setSize(800,600);
		JScrollPane jsc = new JScrollPane(table);
		jsc.setBounds( 50, 170, 720, 400 );
		bankbook.add(jsc);

		input.add(bankbook);
	
		keypad.setLocation(890,130); 
		keypad.setBackground(new Color(209,216,240));
		
	
		board.setBackground(new Color(209,216,240));
		

		String []types = {"간식","경조사비","교통비","관리비","식비","생활비","악세사리","여가","의류","의료","통신비","학용품","회식","기타"};

		JButton tb[] = new JButton[14];
		
		for(int i = 0 ; i < 14 ;i++){
			
			tb[i] = new JButton(types[i]);
			
			tb[i].setFont(font2);
			tb[i].setBackground(Color.white);
			tb[i].setBorder(new LineBorder(new Color(194,201,225), 3));
			
			keypad.add(tb[i]);
		}
				
		
		//보드에 추가하기
		board.add(input);
		board.add(keypad);
		
		
		board.add(input);
		board.add(keypad);
		

		
		mainp.add(action,BorderLayout.NORTH);
		mainp.add(board,BorderLayout.SOUTH);
		
	
		
		mainf.add(mainp);
		mainf.setVisible(true);
		mainf.setResizable(false);
		

		actTestLis2 te = new actTestLis2();
		for(int i =0 ; i<14; i++)
		{
			tb[i].addActionListener(te);	
		}
		
		jb.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				AgaMenu AgaMenu= new AgaMenu();
		    }
		});
		
		
	}

	
	
	class actTestLis2 implements ActionListener{
		 
		   String type =null;
		  public void actionPerformed(ActionEvent event) {
			 
		//	DefaultTableModel m = (DefaultTableModel) table.getModel();
			//m.setRowCount(0);
			
			  
			  String []types = {"간식","경조사비","교통비","관리비","식비","생활비","악세사리","여가","의류","의료","통신비","학용품","회식","기타"};
			  JButton bu = (JButton) event.getSource();
			  System.out.println("여기들어옴...");
			  for(int i =0; i<14; i++){
				  if (bu.getText().equals(types[i])){
					  type = types[i];
			   }
			  }
			 
			  dataSave ds = new dataSave();
			  ds.setType(type);
			  DataBaseWork dw= new DataBaseWork();
			  dw.typecheck(ds.getMyacc(), ds.getType());
			  table = null;
			  m.setNumRows(0);
			  mainf.revalidate();
			  mainf.dispose();
			  Ttran AgaMenu= new Ttran();
			  
		  }
		  
		  public String getType(){
			  return type;
		  }
		  
	}

	
}




