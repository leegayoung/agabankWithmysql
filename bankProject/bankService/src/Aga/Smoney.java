package Aga;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Aga.Ipass.addText;
import databaseInfos.DataBaseWork;
import databaseInfos.dataSave;


public class Smoney{
	
	JFrame mainf = new JFrame();
	JPanel mainp = new JPanel();
	Font font1 = new Font("배달의민족 주아", Font.PLAIN, 50) ;
	Font font1_1 = new Font("배달의민족 주아", Font.PLAIN, 40) ;
	Font font2 = new Font("-윤고딕110", Font.PLAIN, 20) ;
	NumberField ta = new NumberField(){
			
			public void setBorder(Border border){}
			
		};
	
	
	public Smoney(){
		
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
		keypad.setSize(380,500); // 키패드
		
		board.setLocation(0,-10);
		
		JButton jb = new JButton(new ImageIcon("image/backbt.png"));
		jb.setBorderPainted(false);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
	
		JLabel jla = new JLabel("송금 ");
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
		JLabel textl = new JLabel("보낼 금액과 분류를 입력해주세요.");
		textl.setFont(font2);
		textl.setForeground(Color.gray);
		textp.setBackground(Color.white);
		textp.add(textl);
		textl.setSize(855,40);
		textp.setSize(855,40);
		textp.setLocation(280,140);
		input.add(textp);
		
		JPanel type = new JPanel(new GridLayout(2,7));
		type.setSize(850,200);
		
		type.setLocation(3,290);
		
		JButton b[] = new JButton[14];
		
		
		JButton []bts = new JButton[14];
		String []types = {"간식","경조사비","교통비","관리비","식비","생활비","악세사리","여가","의류","의료","통신비","학용품","회식","기타"};
		for(int i =0 ; i<14; i++)
		{
			bts[i] = new JButton(types[i]);
			bts[i].setSize(110,100);
			bts[i].setFont(font2);
			bts[i].setBackground(new Color(214,231,255));
			bts[i].setBorder(new LineBorder(Color.white, 3));
			type.add(bts[i]);
		}
		
		
		
		input.add(type);
		
		actTestLis te = new actTestLis();
		for(int i =0 ; i<14; i++)
		{
			bts[i].addActionListener(te);	
		}
		
		
	
		
		
		
		//버튼 클릭할 때마다 계속 문장 추가해서 화면에 띄워야 함
		//while문이 좋으려나
		
		JButton ipbt = new JButton(new ImageIcon("image/ipbt.png"));
		ipbt.setSize(100,50);
		ipbt.setLocation(380,500);
		

		ipbt.setBorderPainted(false);
		ipbt.setContentAreaFilled(false);
		ipbt.setFocusPainted(false);
		
		input.add(ipbt);
		
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
		tfP.setLocation(130,180);
		ta.setLocation(250,200);
		
		input.add(tfP);
		input.add(ta);
	
		
		keypad.setLocation(890,190); 
		keypad.setBackground(new Color(209,216,240));
	
		board.setBackground(new Color(209,216,240));
		
		JButton b1[] = new JButton[12];
	
		
		for(int i = 0 ; i < 12; i++){
			
			b1[i] = new JButton(new ImageIcon("image/key"+i+".png"));	
			b1[i].setBorderPainted(false);
			b1[i].setContentAreaFilled(false);
			b1[i].setFocusPainted(false);
			b1[i].setFont(font1);
			b1[i].setName(i+"b");
			
		}
		
		
		addText at = new addText();
		
		for(int i =0 ; i<12; i++)
		{
			b1[i].addActionListener(at);	
		}
		
		

		keypad.add(b1[7]);
		keypad.add(b1[8]);
		keypad.add(b1[9]);
		keypad.add(b1[4]);
		keypad.add(b1[5]);
		keypad.add(b1[6]);
		keypad.add(b1[1]);
		keypad.add(b1[2]);
		keypad.add(b1[3]);
		keypad.add(b1[10]);
		keypad.add(b1[0]);
		keypad.add(b1[11]);
		
		
		board.add(input);
		board.add(keypad);
		
		
	
		
		
		mainp.add(action,BorderLayout.NORTH);
		mainp.add(board,BorderLayout.SOUTH);
		
	
		
		mainf.add(mainp);
		mainf.setVisible(true);
		mainf.setResizable(false);
		

		ipbt.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
		    	dataSave ds = new dataSave();
		    	DataBaseWork dw = new DataBaseWork();
		    	if(dw.remittance(ds.getMyacc(),ds.getReceiverAcc() ,ds.getMoney(), ds.getType()))
		    	{
		    		printList print = new printList();
		    	}
		    	else 
		    	{
		    		AgaMain Omoney= new AgaMain();
		    		if(ds.getWidthDrawPos() ==1)
		    		{
		    			Messege m = new Messege("잔액이 부족합니다.");
		    		}
		    		else if(ds.getWidthDrawPos() == 2)
		    		{
		    			Messege m = new Messege("하루 지출한도가 넘은 금액입니다.");
		    		}
		    		else if(ds.getWidthDrawPos() == 3)
		    		{
		    			Messege m = new Messege("한달 지출한도가 넘은 금액입니다.");
		    		}
		    	}
		    }
		});
		

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
			  
			  
			  if(index != 11 && index != 10){
			
			
				  result = ta.getText()+value[index];
				  System.out.println(index);
				  ta.setText(result);
				  
				  
				 
				  
			  }else if(index == 10){
				  
				  result = ta.getText();
				  ta.setText(result);
				  
				  
			  }else ta.setText("");
			  dataSave ds = new dataSave();
			  ds.setMoney(result);
			
			  
		  }
		  
		}
	
	}




