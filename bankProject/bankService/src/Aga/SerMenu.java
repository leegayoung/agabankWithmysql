package Aga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SerMenu{

	JFrame mainf = new JFrame();
	JPanel mainp = new JPanel();
	Font font1 = new Font("배달의민족 주아", Font.PLAIN, 50) ;
	
	
	
	public SerMenu(){
		
	
		mainp.setSize(1280,800);
		mainf.setSize(1280,800);
		mainf.setLayout(null);
		mainp.setLayout(null);
		mainf.setTitle("고객센터 - Welcome to AgaBank");

	
	
		
		JPanel board = new JPanel();
		JPanel action = new JPanel();
		JPanel pbt = new JPanel();
		
		
		pbt.setSize(480,100);
		
		
		JButton jb1 = new JButton(new ImageIcon("image/backbt.png"));
		jb1.setBorderPainted(false);
		jb1.setContentAreaFilled(false);
		jb1.setFocusPainted(false);
	
		JLabel jla = new JLabel("처음으로 ");
		jla.setFont(font1);
		jla.setForeground(Color.white);
	
		pbt.add(jb1,BorderLayout.WEST);
		pbt.add(jla);
		
		
		action.setLayout(null);
	
		pbt.setBackground(new Color(46,89,138));
		action.add(pbt,BorderLayout.WEST);	
		
		action.setSize(1280,100);
		board.setSize(1280,680);
		
		action.setBackground(new Color(46,89,138));
		
		
		board.setLocation(0,100);
		board.setLayout(new GridLayout(1,3));
		
		
	
		JButton jb[] = new JButton[3];
		
		for(int i = 0 ; i < 3 ; i++){
			
			
			jb[i] = new JButton(new ImageIcon("image2/ser"+i+".png"));
			
			jb[i].setBorderPainted(false);
			jb[i].setContentAreaFilled(false);
			jb[i].setFocusPainted(false);
			
			board.add(jb[i]);
		
		}
		
	
		board.setBackground(Color.white);
	
		mainp.add(action,BorderLayout.NORTH);
		mainp.add(board,BorderLayout.SOUTH);
		
		mainf.add(mainp);
		mainf.setVisible(true);
		mainf.setResizable(false);
		
		

		
		jb[0].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				SVcreate Create = new SVcreate();
		    }
		});
		
		jb[1].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				SVsignup Signup = new SVsignup();
		    }
		});
		
		jb[2].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
		    	SVcorrect SVcorrect = new SVcorrect();
		    }
		});
		
		jb1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				AgaChz AgaChz= new AgaChz();
		    }
		});

		
		
		
		
		
//		jb1.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		    	mainf.revalidate();
//		    	mainf.dispose();
//				AgaBank06 j = new AgaBank06();
//		    }
//		});
		
	}

}