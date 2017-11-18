package Aga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import databaseInfos.DataBaseWork;
import databaseInfos.dataSave;


public class SearchAcc{
	
	JFrame mainf = new JFrame();
	JPanel mainp = new JPanel();
	Font font1 = new Font("배달의민족 주아", Font.PLAIN, 50) ;
	Font font1_1 = new Font("배달의민족 주아", Font.PLAIN, 40) ;
	Font font2 = new Font("-윤고딕110", Font.PLAIN, 20) ;
	Font font10 = new Font("-윤고딕110", Font.PLAIN, 15) ;
	JTextField ta = new JTextField(){
			
			public void setBorder(Border border){}
			
		};
	
	JPanel input;
	JPanel list;
	public SearchAcc(){
		
		mainf.setSize(1280,800);
		mainp.setSize(1280,800);
		
		JPanel action = new JPanel();
		JPanel board = new JPanel();
		JPanel keypad = new JPanel();
		JPanel pbt = new JPanel();
		input = new JPanel();
		mainf.setLayout(null);
		mainp.setLayout(null);
		action.setLayout(null);
		board.setLayout(null);
		keypad.setLayout(new GridLayout(4,3));
		input.setLayout(null);
		
		pbt.setSize(300,100); //액션바 버튼
		action.setSize(1280,100); //액션바
		board.setSize(1280,800); //하단 패널
		input.setSize(855,620); //입력창
		keypad.setSize(380,500); //키패드
		board.setLocation(0,-10);
		
		
		JButton jb = new JButton(new ImageIcon("image/backbt.png"));
		jb.setBorderPainted(false);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
		
		JLabel jla = new JLabel("계좌조회 ");
		jla.setFont(font1);
		jla.setForeground(Color.white);
	
		pbt.add(jb,BorderLayout.WEST);
		pbt.setBackground(new Color(46,89,138));
		pbt.add(jla);
		
		action.setBackground(new Color(46,89,138));
		action.add(pbt);
		
		input.setLocation(20,130);
		input.setBackground(Color.white);
		
		JPanel textp = new JPanel();
		textp.setLayout(null);
		
		
		String []value = {"계좌생성을 위한","                 [ 주민번호 ]",
				"                             를 입력해주세요"};
		
		JLabel text[] = new JLabel[3];
		for(int i = 0 ; i <= 2 ; i++){
			
			text[i] = new JLabel();
			text[i].setText(value[i]);
			
			if( i == 1) {
				
				text[i].setForeground(new Color(40,40,40));
				
			}else{
				
				text[i].setForeground(Color.gray);
			}
			
			
			text[i].setFont(font2);
			text[i].setSize(800,40);
			
			textp.add(text[i]);
		}
		
		
		JButton search = new JButton(new ImageIcon("image/search.png"));
		search.setBorderPainted(false);
		search.setContentAreaFilled(false);
		search.setFocusPainted(false);
		search.setLocation(600,170);
		search.setSize(62,62);
		input.add(search);
		
		showAcc sa = new showAcc();
		
		search.addActionListener(sa);
		
		textp.setBackground(Color.white);	
		textp.setSize(600,40);
		textp.setLocation(210,110);
		input.add(textp);
	
		
		
		list = new JPanel();
		list.setBackground(new Color(241,241,241));
		list.setSize(550,220);
	    list.setLocation(155,280);
	    input.add(list);

		
		String [] info={};
		
//		//dataSave ds = new dataSave();
		
		//버튼 클릭할 때마다 계속 문장 추가해서 화면에 띄워야 함
		//while문이 좋으려나
		
		ImageIcon imgbar = new ImageIcon("image/bar.png");
		
		
		JPanel tfP = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(imgbar.getImage(), 0, 0, null);

			}
		};
		
		
		tfP.setSize(600,100);
		ta.setSize(400,60);
		//tf.setBounds(400,80,100,300);
		ta.setFont(font1_1);
		tfP.setLocation(130,150);
		ta.setLocation(200,170);
	

		input.add(tfP);
		input.add(ta);
	
		keypad.setLocation(890,190);
		keypad.setBackground(new Color(209,216,240));
	
		board.setBackground(new Color(209,216,240));
		
		JButton b[] = new JButton[12];
	
		
		for(int i = 0 ; i < 12; i++){
			
			b[i] = new JButton(new ImageIcon("image/key"+i+".png"));	
			b[i].setBorderPainted(false);
			b[i].setContentAreaFilled(false);
			b[i].setFocusPainted(false);
			b[i].setFont(font1);
			b[i].setName(i+"b");
			
		}
		addText at = new addText();
		
		for(int i =0 ; i<12; i++)
		{
			b[i].addActionListener(at);	
		}
		
		keypad.add(b[7]);
		keypad.add(b[8]);
		keypad.add(b[9]);
		keypad.add(b[4]);
		keypad.add(b[5]);
		keypad.add(b[6]);
		keypad.add(b[1]);
		keypad.add(b[2]);
		keypad.add(b[3]);
		keypad.add(b[10]);
		keypad.add(b[0]);
		keypad.add(b[11]);
		
		
		board.add(input);
		board.add(keypad);
		


		mainp.add(action,BorderLayout.NORTH);
		mainp.add(board,BorderLayout.SOUTH);
		
		mainf.add(mainp);
		mainf.setVisible(true);
		mainf.setResizable(false);
		

		jb.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				AgaMenu AgaMenu= new AgaMenu();
		    }
		});
	
	
	}




class addText implements ActionListener{
	 
	   String result = null;
	   
	  public void actionPerformed(ActionEvent event) {
		  
		  
		  
		  String value[] ={"0","1","2","3","4","5","6","7","8","9","-","del"};
		  
		  JButton click= (JButton) event.getSource();
		  String name = click.getName();
		  int index = Integer.parseInt(name.substring(0,name.length()-1));
		
		  String ind = String.valueOf(index);
		  
		  
		  if(index != 11){
			  
			  
			  if( result == null || result.length() < 14){
				  
			  result = ta.getText()+value[index];
			  System.out.println(index);
			  ta.setText(result);
			  dataSave s = new dataSave();
			  s.setMyacc(ta.getText());
			  }
		  }else ta.setText("");
		  
		
		  
	  }
	  
	}


class showAcc implements ActionListener{
	
	  public void actionPerformed(ActionEvent event) {
		  
		 
		  
		//dataSave ds = new dataSave();
		  
			try{
				
			dataSave s = new dataSave();
			DataBaseWork db = new DataBaseWork();
			s.setMyacc(ta.getText());
			System.out.println(s.getMyacc());
			db.showAcc(s.getMyacc());

			
			//s.accAll[];
			//String [] info={"8161&16151&1651"};
		
			System.out.println("내가볼건이거야"+s.accAll.length+"dd");
			
			
			
//			if(s.accAll.length == 0){
//				
//				throw new NullPointerException();
//				
//			}
			
			
			
			
			String[] title={"이름","계좌번호","잔액"};
			
			String data[][] = new String[3][3];
			String nullChk = "-&-&-";
			
			for(int i = 0 ; i < 3 ; i++){
				System.out.println(i+" : "+s.accAll[i]);
				if(s.accAll[i].equals(null))s.accAll[i] =nullChk;
				if(i < s.accAll.length){
					System.out.println("!!!!!!");
					data[i] = s.accAll[i].split("&");
				}
				else{	
					System.out.println("????");
					data[i] = nullChk.split("&");
					}	
				System.out.println(i+" : "+data[i]);
				}
			
		
			JTable table = new JTable(data,title);
			table.setFont(font10);
			table.setRowHeight(50); 
			
			table.getColumnModel().getColumn(0).setMaxWidth(100); 
	        table.getColumnModel().getColumn(0).setMinWidth(100); 
			table.getColumnModel().getColumn(0).setWidth(100); 
			
			table.getColumnModel().getColumn(1).setMaxWidth(250); 
	        table.getColumnModel().getColumn(1).setMinWidth(250); 
			table.getColumnModel().getColumn(1).setWidth(250); 
			
			JScrollPane jsc = new JScrollPane(table);
			jsc.setPreferredSize(new java.awt.Dimension(550,173));
			jsc.setFont(font10);
			
			JLabel notil = new JLabel("한 주민번호 당, 3개의 계좌를 만들 수 있습니다.");
			notil.setFont(font2);
			notil.setBackground(new Color(250,250,250));
			
			list.add(jsc);
			list.add(notil);
			
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
			
			mainf.revalidate();
			
			
			
			}catch(NullPointerException npe){
		
				JLabel notil = new JLabel("생성된 계좌가 없습니다.");
				notil.setFont(font2);
				list.add(notil);
				mainf.revalidate();
				
			}
			
		
		  
	  }
	  
	}


}