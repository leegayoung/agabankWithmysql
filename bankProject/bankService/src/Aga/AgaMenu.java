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

public class AgaMenu{

	JFrame mainf = new JFrame();
	JPanel mainp = new JPanel();
	Font font1 = new Font("배달의민족 주아", Font.PLAIN, 50) ;
	
	
	
	public AgaMenu(){
		
	
		mainp.setSize(1280,800);
		mainf.setSize(1280,800);
		mainf.setLayout(null);
		mainp.setLayout(null);
		mainf.setTitle("은행업무 - Welcome to AgaBank");

	
	
		
		JPanel board = new JPanel();
		JPanel action = new JPanel();
		JPanel pbt = new JPanel();
		
		
		pbt.setSize(480,100);
		
		
		JButton jb = new JButton(new ImageIcon("image/backbt.png"));
		jb.setBorderPainted(false);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
	
		JLabel jla = new JLabel("처음으로 ");
		jla.setFont(font1);
		jla.setForeground(Color.white);
	
		pbt.add(jb,BorderLayout.WEST);
		pbt.add(jla);
		
		
		action.setLayout(null);
	
		pbt.setBackground(new Color(46,89,138));
		action.add(pbt,BorderLayout.WEST);	
		
		action.setSize(1280,100);
		board.setSize(1280,680);
		
		action.setBackground(new Color(46,89,138));
		
		
		board.setLocation(0,100);
		board.setLayout(new GridLayout(2,3));
		board.setBackground(Color.white);
		
		
		JButton bt[] = new JButton[6];
		for(int i = 0 ; i < 6 ; i++){
		
				bt[i] = new JButton(new ImageIcon("image/menu"+(i+1)+".png"));
			
			
			bt[i].setBorderPainted(false);
			bt[i].setContentAreaFilled(false);
			bt[i].setFocusPainted(false);
			
			board.add(bt[i]);
			
			
		}
	
		mainp.add(action,BorderLayout.NORTH);
		mainp.add(board,BorderLayout.SOUTH);
		
		mainf.add(mainp);
		mainf.setVisible(true);
		mainf.setResizable(false);
		
		
	
		
		bt[0].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				Iacc Iacc = new Iacc();
		    }
		});
		
		bt[1].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				Oacc1 Oacc1 = new Oacc1();
		    }
		});

		
		bt[2].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				Smyacc Smyacc= new Smyacc();
		    }
		});
		
		
		bt[3].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				Nmynum Nmynum= new Nmynum();
		    }
		});
		

		bt[4].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				Tacc Tacc= new Tacc();
		    }
		});
	
		
		bt[5].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
				SearchAcc SearchAcc = new SearchAcc();
		    }
		});
		
		
		jb.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	mainf.revalidate();
		    	mainf.dispose();
		    	AgaChz AgaChz = new AgaChz();
		    }
		});
		
		

	}

}