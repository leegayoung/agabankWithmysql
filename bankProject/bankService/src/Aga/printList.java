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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Aga.Ipass.addText;
import databaseInfos.dataSave;

public class printList{
	
	JFrame mainf = new JFrame();
	JPanel mainp = new JPanel();
	Font font1 = new Font("배달의민족 주아", Font.PLAIN, 50) ;
	Font font1_1 = new Font("배달의민족 주아", Font.PLAIN, 40) ;
	Font font2 = new Font("-윤고딕110", Font.PLAIN, 20) ;
	
	public printList(){
		
		mainf.setSize(1280,800);
		mainp.setSize(1280,800);
		
		JPanel action = new JPanel();
		JPanel board = new JPanel();
		JPanel keypad = new JPanel();
		JPanel input = new JPanel();
		JPanel pbt = new JPanel();
		JPanel showP = new JPanel();
		JPanel showG = new JPanel();
		
		
		mainf.setLayout(null);
		mainp.setLayout(null);
		action.setLayout(null);
		board.setLayout(null);
		keypad.setLayout(new GridLayout(4,3));
		input.setLayout(null);
		showP.setLayout(null);
		showG.setLayout(new GridLayout(4,1));
		
	
		JPanel show[] = new JPanel[4];
		
		
		for(int  i = 0; i < 4 ; i++){

			show[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		}
		
		pbt.setSize(500,100); //액션바 버튼
		action.setSize(1280,100); //액션바
		board.setSize(1280,800); //하단 패널
		input.setSize(855,620); //입력창
		keypad.setSize(380,500); //키패드
		showP.setSize(400,310); //정보 확인 창
		showG.setSize(350,250); // 정보 확인 창에 붙일 패널
		
		
		board.setLocation(0,-10);
		
		JButton jb = new JButton(new ImageIcon("image/backbt.png"));
		jb.setBorderPainted(false);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
	
		JLabel jla = new JLabel("명세표 ");
		jla.setFont(font1);
		jla.setForeground(Color.white);
	
	
		pbt.add(jb,BorderLayout.WEST);
		pbt.setBackground(new Color(46,89,138));
		pbt.add(jla);
		
		action.setBackground(new Color(46,89,138));
		action.add(pbt);
	
		
		input.setLocation(20,130);
		input.setBackground(Color.white);
		
		JPanel textp = new JPanel(new FlowLayout());
		textp.setLayout(null);
		JLabel text1 = new JLabel("       입니다. 확인해주세요.");
		JLabel text2 = new JLabel("명세표");
		
		
		text1.setFont(font2);
		text1.setForeground(Color.gray);
		
		text2.setFont(font2);
		text2.setForeground(new Color(40,40,40));
		
		textp.setBackground(Color.white);
		textp.add(text2);
		textp.add(text1);
		text2.setSize(100,40);
		text1.setSize(400,40);
		
		textp.setSize(600,40);
		textp.setLocation(300,50);
		input.add(textp);
	
		
		
		showP.setLocation(230,120);
		showP.setBackground(new Color(241,241,241)); //e5e3e3
		
		
		JLabel s[] = new JLabel[4];
		String value[] ={"         입금자         |         ",
						"	         예금주         |         ",
						"	         금액             |         ",
						"	         분류             |         "};
		
		for(int i=0; i< 4 ; i++){
			
			s[i] = new JLabel(value[i]);
			show[i].add(s[i]);
			show[i].setSize(400,70);
		}
		
		
		dataSave ds = new dataSave();
		JLabel outputName = new JLabel("");
		JLabel inputName = new JLabel("");
		JLabel money = new JLabel("");
		JLabel type = new JLabel("");
		outputName.setText(ds.getName());
		inputName.setText(ds.getReceiverName());
		money.setText(ds.getMoney());
		type.setText(ds.getType());
		

		show[0].add(outputName);
	
		show[1].add(inputName);
		
		show[2].add(money);
		
		show[3].add(type);
		
		

		
		for(int i = 0 ; i < 4 ; i++){
			
			
			showG.add(show[i]);
		}
		
		
		showG.setLocation(15,15);
		
		showP.add(showG);
		
		input.add(showP);
		
		
		JButton ipbt = new JButton(new ImageIcon("image/ipbt.png"));
		ipbt.setSize(100,50);
		ipbt.setLocation(380,450);
		

		ipbt.setBorderPainted(false);
		ipbt.setContentAreaFilled(false);
		ipbt.setFocusPainted(false);
		
		input.add(ipbt);
		
		
		
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
		    	AgaMain AgaMain= new AgaMain();
		    }
		});
		

		
		mainp.add(action,BorderLayout.NORTH);
		mainp.add(board,BorderLayout.SOUTH);
		
		
		mainf.add(mainp);
		mainf.setVisible(true);
		mainf.setResizable(false);
		

	}

	

}