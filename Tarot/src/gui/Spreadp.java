package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import main.Load;

public class Spreadp extends JPanel implements ActionListener{
	
	
	private static Spreadp sp=null;
	private Load load=Load.getInstance();
	private CardLayout card;
	private JDialog urd;
	private JPanel mpanel;
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JDialog d;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JList<String> ul;
	private JLabel cdptitle1;
	private JLabel cdptitle2;
	private Font f=new Font(Font.SERIF,Font.BOLD|Font.ITALIC,80);
	private String user;
	
	
	private Spreadp() {
		
	}
	public static Spreadp getInstance() {
		if(sp== null) {
			sp=new Spreadp();
		}
		return sp;
	}
	
	public JPanel panel() {
		mpanel=new JPanel(new CardLayout());
		mpanel.setOpaque(false);
		jp1=startP();
		jp2=oneP();
		jp3=threeP();
		mpanel.add(jp1,"p1");
		mpanel.add(jp2,"p2");
		mpanel.add(jp3,"p3");
		card=(CardLayout) mpanel.getLayout();
		return mpanel;
	}
	
	public JPanel startP() {
		JPanel panel=new JPanel(new GridLayout(1,2));
		panel.setOpaque(false);
		Image image1=new ImageIcon("D:\\그림\\1카드.jpg").getImage();
		Image scalp1=image1.getScaledInstance(200, 340, Image.SCALE_SMOOTH);
		JLabel title1=new JLabel("1CARD");
		title1.setHorizontalAlignment(JLabel.CENTER);
		title1.setFont(f);
		title1.setForeground(Color.LIGHT_GRAY);
		btn1=new JButton(new ImageIcon(scalp1));
		btn1.setLayout(new BorderLayout());
		btn1.setBackground(Color.WHITE);
		btn1.setOpaque(false);
		btn1.setBorderPainted(false);
		btn1.setFocusPainted(false);
		btn1.add(title1);
		btn1.addActionListener(this);
		Image image2=new ImageIcon("D:\\그림\\3카드.jpg").getImage();
		Image scalp2=image2.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
		JLabel title2=new JLabel("3CARD");
		title2.setHorizontalAlignment(JLabel.CENTER);
		title2.setFont(f);
		title2.setForeground(Color.LIGHT_GRAY);
		btn2=new JButton(new ImageIcon(scalp2));
		btn2.setLayout(new BorderLayout());
		btn2.setBackground(Color.WHITE);
		btn2.setOpaque(false);
		btn2.setBorderPainted(false);
		btn2.setFocusPainted(false);
		btn2.add(title2);
		btn2.addActionListener(this);
		panel.add(btn1);
		panel.add(btn2);
		return panel;
	}
	public JPanel oneP() {
		JPanel panel=new JPanel(null);
		panel.setOpaque(false);
		cdptitle1=settitle();
		cdptitle1.setBounds(50, 0, 400, 50);
		panel.add(cdptitle1);
		return panel;
	}
	
	public JPanel threeP() {
		JPanel panel=new JPanel(null);
		panel.setOpaque(false);
		cdptitle2=settitle();
		cdptitle2.setBounds(50, 0, 400, 50);
		panel.add(cdptitle2);
		return panel;
	}
	
	public JDialog uresist() {
		d=new JDialog();
		d.setTitle("");
		d.setResizable(false);
		d.setLayout(new BorderLayout());
		d.setBounds(500, 335, 300, 150);
		d.getContentPane().setBackground(new Color(88,64,52));
		JLabel lb1=new JLabel("카드 대상 등록",JLabel.LEFT);
		lb1.setFont(new Font(Font.SERIF,Font.BOLD|Font.ITALIC,16));
		lb1.setForeground(Color.BLACK);
		JPanel temp1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		temp1.setBackground(new Color(88,64,52));
		JLabel lb2=new JLabel("이름 회원번호  ",JLabel.LEFT);
		lb2.setFont(new Font(Font.SERIF,Font.ITALIC,12));
		lb2.setForeground(Color.BLACK);
		btn3=new JButton("OK");
		btn3.setBackground(new Color(88,64,52));
		btn3.addActionListener(this);
		ul=new JList(load.getuserlsit());
		ul.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane js1=new JScrollPane(ul);
		js1.setPreferredSize(new Dimension(230,50));
		temp1.add(lb2);
		temp1.add(js1);
		d.add("North",lb1);
		d.add("East", btn3);
		d.add("Center",temp1);
		d.setVisible(true);
		return null;
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			System.out.println("실행");
			cdptitle1.setText("");
			cdptitle2.setText("");
			urd=uresist();
			card.show(mpanel,"p2");
		}else if(e.getSource()==btn2) {
			System.out.println("실행");
			cdptitle1.setText("");
			cdptitle2.setText("");
			urd=uresist();
			card.show(mpanel,"p3");
		}else if(e.getSource()==btn3) {
			user=ul.getSelectedValue();
			System.out.println(user);
			cdptitle1.setText(user);
			cdptitle2.setText(user);
			d.dispose();
		}
	}
	public JLabel settitle() {
		JLabel lb=new JLabel(user);
		lb.setFont(new Font(Font.SERIF,Font.BOLD|Font.ITALIC,35));
		lb.setForeground(Color.ORANGE);
		lb.setBorder(new LineBorder(Color.YELLOW,3,true));
		return lb;
	}
	
	public JPanel getMpanel() {
		return mpanel;
	}
	public JList getUl() {
		return ul;
	}
	
}
