package Aga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Messege extends JDialog implements ActionListener{
	
	
	JLabel jlb = new JLabel("");
	Font font2 = new Font("-윤고딕110", Font.PLAIN, 20) ;
	
	public Messege(String str){
	
		
		ImageIcon bg = new ImageIcon("image3/notice.png");
				
		
		JPanel back = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bg.getImage(), 0, 0, null);
	
			}
		};
			
	
		back.setLayout(null);
		
	
		jlb.setText(str.toString());
		jlb.setFont(font2);
	
		JPanel jp1 = new JPanel();
		jp1.setBackground(Color.white);	
		JButton ipbt = new JButton(new ImageIcon("image/ipbt.png"));
		
		ipbt.setBounds(150,120,100,50);
		ipbt.setBorderPainted(false);
		ipbt.setContentAreaFilled(false);
		ipbt.setFocusPainted(false);

		ipbt.addActionListener(this);
		
		jp1.add(jlb);
	
		jp1.setBounds(50,75,300,40);
		
		
	
		back.add(jp1);
		back.add(ipbt);
		back.setSize(400,150);
		getContentPane().add(back);

	
		this.setLocation(400,400);
		this.setSize(415,240);
		this.setModal(true);
		this.setVisible(true);
		
		
		
		
		
	}
	
	 public void actionPerformed(ActionEvent e) {
		 
	      dispose();
	  }
	 
	public void setTitle(String str){
		
		this.setTitle(str);
		
		
	}

}