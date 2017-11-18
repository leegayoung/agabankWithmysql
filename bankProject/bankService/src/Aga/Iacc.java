package Aga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import databaseInfos.DataBaseWork;
import databaseInfos.dataSave;
public class Iacc{
	
	JFrame mainf = new JFrame();
	JPanel mainp = new JPanel();
	Font font1 = new Font("배달의민족 주아", Font.PLAIN, 50) ;
	Font font1_1 = new Font("배달의민족 주아", Font.PLAIN, 40) ;
	Font font2 = new Font("-윤고딕110", Font.PLAIN, 20) ;
	
	JTextField ta = new JTextField(){
		
		public void setBorder(Border border){}
		
	};
	
	public Iacc(){
		
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
	
		JLabel jla = new JLabel("입금 ");
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
		JLabel textl = new JLabel("입금할 계좌를 입력해주세요.");
		textl.setFont(font2);
		textl.setForeground(Color.gray);
		textp.setBackground(Color.white);
		textp.add(textl);
		textl.setSize(855,40);
		textp.setSize(855,40);
		textp.setLocation(290,210);
		input.add(textp);
	
		//ta = new JTextField("");
		//버튼 클릭할 때마다 계속 문장 추가해서 화면에 띄워야 함
		//while문이 좋으려나
		
		ImageIcon imgbar = new ImageIcon("image/bar.png");
		
		
		JPanel tfP = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(imgbar.getImage(), 0, 0, null);

			}
		};
		
		
		tfP.setSize(600,100);
		ta.setSize(400,50);
		//tf.setBounds(400,80,100,300);
		ta.setFont(font1_1);
		tfP.setLocation(130,250);
		ta.setLocation(250,270);
	
		
		JButton ipbt = new JButton(new ImageIcon("image/ipbt.png"));
		ipbt.setSize(100,50);
		ipbt.setLocation(380,350);
		

		ipbt.setBorderPainted(false);
		ipbt.setContentAreaFilled(false);
		ipbt.setFocusPainted(false);
		
		input.add(ipbt);
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
		
		ipbt.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
		    	dataSave ds = new dataSave();
		    	DataBaseWork dw = new DataBaseWork();
		    	ds.setMyacc(ta.getText());
		    	if(dw.Check_Acc(ds.getMyacc()))
		    	{
		    		ds.setName(dw.return_Name_Acc_Info(ds.getMyacc()));
		    		ds.setReceiverName(dw.return_Name_Acc_Info(ds.getMyacc()));
		    		Ipass Ipass= new Ipass();
		    	}
		    	else 
		    	{
		    		AgaMain Omoney= new AgaMain();
		    		Messege m = new Messege("계좌번호가 맞지않습니다.");
		    	}
				
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
			  if( result == null || result.length() < 16){
			  result = ta.getText()+value[index];
			  System.out.println(index);
			  ta.setText(result);
			  dataSave ds = new dataSave();
			  ds.setMyacc(result);
			  ds.setType(" ");
			  }
		  }else ta.setText("");
		  
		
		  
	  }
	  
	}

}