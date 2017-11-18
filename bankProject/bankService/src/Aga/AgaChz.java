package Aga;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AgaChz extends JFrame{

	private Font font1 = new Font("배달의민족 주아", Font.PLAIN, 80) ;
	
	public AgaChz(){
		
		this.setSize(1280,800);
		setTitle("메뉴를 선택하세요");
		super.setLayout(new GridLayout(1,2));
		
		JButton jb1 = new JButton("은행업무");
		JButton jb2 = new JButton("고객센터");
	
		  
		jb1.setFont(font1);
		jb2.setFont(font1);
		
		jb1.setBackground(new Color(46,89,138));
		jb2.setBackground(new Color(236,249,249));
		
		jb2.setForeground(new Color(46,89,138));
		jb1.setForeground(new Color(236,249,249));

		jb1.setSize(640,400);
		jb2.setSize(640,400);
		
		add(jb1);
		add(jb2);
	
		setVisible(true);
		setResizable(false);
		
		
		jb1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	revalidate();
		    	dispose();
				AgaMenu AgaMenu= new AgaMenu();
		    }
		});
		jb2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	revalidate();
		    	dispose();
				SerMenu SerMenu= new SerMenu();
		    }
		});
	}
	


}
