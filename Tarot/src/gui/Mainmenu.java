package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Load;

public class Mainmenu extends JFrame implements ActionListener, MouseListener {
	private Load load=Load.getInstance();
	private Spreadp spreadp=Spreadp.getInstance();
	private Image back=new ImageIcon("D:\\그림\\배경.jpg").getImage();
	private String mt="Main Title";
	private Font f=new Font(Font.SERIF,Font.BOLD|Font.ITALIC,70);
	private JPanel mp=Mpanel.panel();
	private JPanel sp=spreadp.getMpanel();
	private JButton btn1=new JButton("카드 정보");
	private JButton btn2=new JButton("이용자  정보");
	private JButton btn3=new JButton("카드  펼치기");
	private CardLayout cl = (CardLayout) mp.getLayout();
	private CardLayout cp = (CardLayout) sp.getLayout();
	private Color brown=new Color(88,64,52);
	private static Image ranimg;
	

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
		bk.add("Center",mp);
		btn();
		this.setVisible(true);
		JButton a=new JButton();// 마우스 포인터
		a.addMouseListener(this);
		a.setOpaque(false);
		this.add(a);
		a.setBounds(0, 0, 100, 100);
		
		
	}
	
	private void btn() {
		JPanel btnp=new JPanel();
		btnp.setOpaque(false);
		btnp.setLayout(new FlowLayout());
		btn1.addActionListener(this);
		btn1.setBackground(brown);
		btnp.add(btn1);
		btnp.add(new JLabel("                          "));
		btn2.addActionListener(this);
		btn2.setBackground(brown);
		btnp.add(btn2);
		btnp.add(new JLabel("                          "));
		btn3.addActionListener(this);
		btn3.setBackground(brown);
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
		if(e.getSource()==btn1) {
			cl.show(mp, "Panel2");	
		}else if(e.getSource()==btn2) {
			cl.show(mp, "Panel3");
			String ranimgpath=null;
			Random r=new Random();
			int r1=r.nextInt(2)+1;
			int r2=r.nextInt(22);
			int r3=r.nextInt(56);
			if(r1==1) {
				ranimgpath=load.getimagepath(1, r2);
			}else if(r1==2) {
				ranimgpath=load.getimagepath(2, r3);
			}
			ranimg=new ImageIcon(ranimgpath).getImage();
		}else if(e.getSource()==btn3) {
			cl.show(mp,"Panel4");
			cp.show(sp, "p1");
		}
	}

	public static Image getRanimg() {
		return ranimg;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX()+" "+e.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
