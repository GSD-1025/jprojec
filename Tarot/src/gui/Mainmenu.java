package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mainmenu extends JFrame implements ActionListener {
	private Image back=new ImageIcon("D:\\그림\\배경.jpg").getImage();
	private String mt="Main Title";
	private Font f=new Font(Font.SERIF,Font.BOLD|Font.ITALIC,70);
	private Mpanel mp=new Mpanel();
	
	private JPanel bk=new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			Image backimage=back;
			g.drawImage(backimage, 0, 0, 1208, 825, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	};
	
	public Mainmenu() {
		this.setTitle("프로그램");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(1208, 860);
		this.setResizable(false);
		bk.setLayout(new BorderLayout());
		this.add(bk);
		title();
		bk.add("Center",Mpanel.panel());
		btn();
		this.setVisible(true);
	}
	
	private void btn() {
		JPanel btnp=new JPanel();
		btnp.setOpaque(false);
		JButton btn1=new JButton("카드 정보");
		JButton btn2=new JButton("이용자  정보");
		JButton btn3=new JButton("카드  펼치기");
		btnp.setLayout(new FlowLayout());
		btnp.add(btn1);
		btnp.add(new JLabel("                          "));
		btnp.add(btn2);
		btnp.add(new JLabel("                          "));
		btnp.add(btn3);
		bk.add("South",btnp);
	}
	

	
	
	private void title() {
		JLabel lb1=new JLabel(mt);
		lb1.setHorizontalAlignment(JLabel.CENTER);
		lb1.setOpaque(false);
		lb1.setFont(f);
		bk.add("North",lb1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
	}

}
