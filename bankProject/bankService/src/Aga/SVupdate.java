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
import databaseInfos.DataBaseWork;
import databaseInfos.dataSave;

public class SVupdate{
	
	JFrame mainf = new JFrame();
	JPanel mainp = new JPanel();
	Font font1 = new Font("배달의민족 주아", Font.PLAIN, 50) ;
	Font font1_1 = new Font("배달의민족 주아", Font.PLAIN, 40) ;
	Font font2 = new Font("-윤고딕110", Font.PLAIN, 20) ;
	
	public SVupdate(){
		
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
	
		JLabel jla = new JLabel("정보 수정 ");
		jla.setFont(font1);
		jla.setForeground(Color.white);
	
	
		pbt.add(jb,BorderLayout.WEST);
		pbt.setBackground(new Color(46,89,138));
		pbt.add(jla);
		
		action.setBackground(new Color(46,89,138));
		action.add(pbt);
	
		input.setLocation(20,130);
		input.setBackground(Color.white);
		

		keypad.setLocation(890,190);
		keypad.setBackground(new Color(209,216,240));

		board.setBackground(new Color(209,216,240));
		
		JButton ipbt = new JButton(new ImageIcon("image/ipbt.png"));
		ipbt.setSize(100,50);
		ipbt.setLocation(380,400);
		
		
		ipbt.setBorderPainted(false);
		ipbt.setContentAreaFilled(false);
		ipbt.setFocusPainted(false);
		
		input.add(ipbt);
		
		
		
		
		jb.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				SerMenu SerMenu= new SerMenu();
		    }
		});
		
		
		
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
		
		
		JPanel formP = new JPanel(new GridLayout(2,2));
		formP.setSize(400,100);
		formP.setLocation(30,30);
		
	
		
		JLabel name = new JLabel("* 이름 ");
		name.setForeground(new Color(40,40,40));
		name.setFont(font2);
		
		JLabel number = new JLabel("* 비밀번호");
		number.setForeground(new Color(40,40,40));
		number.setFont(font2);
		
		
		JTextField name1 = new JTextField();
		JTextField number1 = new JTextField();
	
		JPanel text = new JPanel(new FlowLayout());
		text.setSize(600,50);
		text.setBackground(Color.white);
		text.setLocation(140,150);
		
		JLabel title1 = new JLabel("[ 회원 정보 ]");
		title1.setFont(font2);
		title1.setForeground(new Color(40,40,40));
		
		JLabel title = new JLabel(" 를 변경 해주세요. ");
		title.setSize(500,50);
		title.setFont(font2);
		title.setForeground(Color.gray);
		title.setLocation(190,100);
		
		
		text.add(title1);
		text.add(title);
		
		input.add(text);
		
		
		formP.add(name);
		formP.add(name1);
		
		formP.add(number);
		formP.add(number1);
		
		
		JPanel form = new JPanel();
		form.setLayout(null);
		form.setSize(450,150);
		form.setLocation(200,210);
		form.setBackground(new Color(241,241,241));
		form.add(formP);
		
		input.add(form);
		//사용자의 이름, 주민번호
		
		board.add(input);
		
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
		    	dw.rename(ds.getSsNumber(),name1.getText());
		    	dw.repassword(ds.getSsNumber(),number1.getText());
		    	AgaChz AgaChz = new AgaChz();

				//여기서 랜덤으로 계좌 생성
		    }
		});
		
	}



}
