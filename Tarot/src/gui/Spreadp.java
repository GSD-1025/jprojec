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
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import card.MajorDTO;
import main.Load;
import spread.OneDAO;
import spread.OneDTO;
import spread.ThreeDTO;

public class Spreadp extends JPanel implements ActionListener{
	
	
	private static Spreadp sp=null;
	private Random ran=new Random();
	private Load load=Load.getInstance();
	private CardLayout card;
	private JPanel mpanel;
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JDialog d;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JList<String> ul;
	private JLabel cdptitle1;
	private JLabel cdptitle2;
	private JLabel ocard;
	private JLabel oct;
	private JTextField oinp;
	private Font f=new Font(Font.SERIF,Font.BOLD|Font.ITALIC,80);
	private Font f2=new Font(Font.SERIF,Font.BOLD|Font.ITALIC,15);
	private Color brown=new Color(88,64,52);
	private String user;
	private OneDTO ores=new OneDTO();
	private ThreeDTO tres=new ThreeDTO();
	
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
		cdptitle1=title();
		cdptitle1.setBounds(60, 0, 350, 50);
		btn4=new JButton("카드 뽑기");
		btn4.setBackground(brown);
		btn4.setFont(f2);
		btn4.setBorderPainted(false);
		btn4.setBounds(65, 55, 120, 40);
		btn4.addActionListener(this);
		btn6=new JButton("해석 결과");
		btn6.setBackground(brown);
		btn6.setFont(f2);
		btn6.setBorderPainted(false);
		btn6.setBounds(230, 562, 120, 40);
		btn6.addActionListener(this);
		ocard=new JLabel(cardimage("D:\\그림\\1카드.jpg"));
		ocard.setBounds(480, 117, 250, 410);
		oct=cardtitle();
		oct.setBounds(540, 70, 250, 50);
		oinp=new JTextField();
		oinp.setBounds(360, 567, 500, 30);
		panel.add(cdptitle1);
		panel.add(btn4);
		panel.add(ocard);
		panel.add(oct);
		panel.add(btn6);
		panel.add(oinp);
		return panel;
	}
	
	public JPanel threeP() {
		JPanel panel=new JPanel(null);
		panel.setOpaque(false);
		cdptitle2=title();
		cdptitle2.setBounds(60, 0, 350, 50);
		btn5=new JButton("카드 뽑기");
		btn5.setBackground(brown);
		btn5.setFont(f2);
		btn5.setBorderPainted(false);
		btn5.setBounds(65, 55, 140, 40);
		panel.add(cdptitle2);
		panel.add(btn5);
		return panel;
	}
	
	public void uresist() {
		d=new JDialog();
		d.setTitle("");
		d.setResizable(false);
		d.setLayout(new BorderLayout());
		d.setBounds(480, 335, 300, 150);
		d.getContentPane().setBackground(brown);
		JLabel lb1=new JLabel("카드 대상 등록",JLabel.LEFT);
		lb1.setFont(new Font(Font.SERIF,Font.BOLD|Font.ITALIC,16));
		lb1.setForeground(Color.BLACK);
		JPanel temp1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		temp1.setBackground(brown);
		JLabel lb2=new JLabel("이름 회원번호  ",JLabel.LEFT);
		lb2.setFont(new Font(Font.SERIF,Font.ITALIC,12));
		lb2.setForeground(Color.BLACK);
		btn3=new JButton("OK");
		btn3.setBackground(brown);
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
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			cdptitle1.setText("");
			cdptitle1.setVisible(false);
			cdptitle2.setText("");
			cdptitle2.setVisible(false);
			oct.setVisible(false);
			uresist();
			card.show(mpanel,"p2");
		}else if(e.getSource()==btn2) {
			cdptitle1.setText("");
			cdptitle1.setVisible(false);
			cdptitle2.setText("");
			cdptitle2.setVisible(false);
			oct.setVisible(false);
			uresist();
			card.show(mpanel,"p3");
		}else if(e.getSource()==btn3) {
			user=ul.getSelectedValue();
			String[] s=user.split(" ");
			ores.setUnum(s[1]);
			cdptitle1.setText(user);
			cdptitle1.setVisible(true);
			cdptitle2.setText(user);
			cdptitle2.setVisible(true);
			d.dispose();
		}else if(e.getSource()==btn4) {
			int r=ran.nextInt(44);
			MajorDTO mj=load.getmajor(r);
			ores.setMnum(mj.getMajornum());
			String imgpath=mj.getImagepath();
			oct.setText(mj.getName()+"-"+mj.getWay());
			oct.setVisible(true);
			ocard.setIcon(cardimage(imgpath));
		}else if(e.getSource()==btn6) {
			ores.setInterpret(oinp.getText());
			OneDAO odao=new OneDAO();
			odao.insert(ores);
			oinp.setText("");
			oct.setText("");
			ocard.setIcon(cardimage("D:\\그림\\1카드.jpg"));
		}
	}
	private JLabel title() {
		JLabel lb=new JLabel(user);
		lb.setFont(new Font(Font.SERIF,Font.BOLD|Font.ITALIC,35));
		lb.setForeground(Color.ORANGE);
		return lb;
	}
	private JLabel cardtitle() {
		JLabel lb=new JLabel("");
		lb.setFont(new Font(Font.SERIF,Font.BOLD|Font.ITALIC,20));
		lb.setForeground(Color.WHITE);
		return lb;
	}
	private ImageIcon cardimage(String imgpath) {
		Image image1=new ImageIcon(imgpath).getImage();
		Image scalp1=image1.getScaledInstance(250, 410, Image.SCALE_SMOOTH);
		ImageIcon icon=new ImageIcon(scalp1);
		return icon;
	}
	
	
	public JPanel getMpanel() {
		return mpanel;
	}
	public JList getUl() {
		return ul;
	}
	
}
