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

import card.DrawcDAO;
import card.DrawcDTO;
import card.MajorDTO;
import card.MinorDTO;
import main.Load;
import spread.OneDAO;
import spread.OneDTO;
import spread.ThreeDAO;
import spread.ThreeDTO;
import user.UserDAO;

@SuppressWarnings("serial")
public class Spreadp extends JPanel implements ActionListener{
	
	
	private static Spreadp sp=null;
	private Userp userp=Userp.getInstance();
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
	private JButton btn7;
	private JList<String> ul;
	private JList<String> inpway;
	private JLabel cdptitle1;
	private JLabel cdptitle2;
	private JLabel ocard;
	private JLabel oct;
	private JLabel tcard1;
	private JLabel tcard2;
	private JLabel tcard3;
	private JLabel tct1;
	private JLabel tct2;
	private JLabel tct3;
	private JTextField oinp;
	private JTextField tinp;
	private Font f=new Font(Font.SERIF,Font.BOLD|Font.ITALIC,80);
	private Font f2=new Font(Font.SERIF,Font.BOLD|Font.ITALIC,15);
	private Color brown=new Color(88,64,52);
	private String user;
	private int tcnt=0;
	private int dpnum1=-1;
	private int dpnum2=-1;
	private int pack1=-1;
	private int pack2=-1;
	private OneDTO ores=new OneDTO();
	private ThreeDTO tres=new ThreeDTO();
	private DrawcDTO dcard=new DrawcDTO();
	
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
		JLabel title1=new JLabel("1CARD");
		title1.setHorizontalAlignment(JLabel.CENTER);
		title1.setFont(f);
		title1.setForeground(Color.LIGHT_GRAY);
		btn1=new JButton(cardimage("D:\\그림\\3-1.jpg",248,410));
		btn1.setLayout(new BorderLayout());
		btn1.setBackground(Color.WHITE);
		btn1.setOpaque(false);
		btn1.setBorderPainted(false);
		btn1.setFocusPainted(false);
		btn1.add(title1);
		btn1.addActionListener(this);
		JLabel title2=new JLabel("3CARD");
		title2.setHorizontalAlignment(JLabel.CENTER);
		title2.setFont(f);
		title2.setForeground(Color.LIGHT_GRAY);
		btn2=new JButton(cardimage("D:\\그림\\3카드.jpg",700,500));
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
		btn5=new JButton("해석 결과");
		btn5.setBackground(brown);
		btn5.setFont(f2);
		btn5.setBorderPainted(false);
		btn5.setBounds(230, 562, 120, 40);
		btn5.addActionListener(this);
		ocard=new JLabel(cardimage("D:\\그림\\3-1.jpg",248,410));
		ocard.setBounds(480, 117, 250, 410);
		oct=cardtitle();
		oct.setBounds(540, 70, 250, 50);
		oinp=new JTextField();
		oinp.setBounds(360, 567, 500, 30);
		panel.add(cdptitle1);
		panel.add(btn4);
		panel.add(ocard);
		panel.add(oct);
		panel.add(btn5);
		panel.add(oinp);
		return panel;
	}
	
	public JPanel threeP() {
		JPanel panel=new JPanel(null);
		panel.setOpaque(false);
		cdptitle2=title();
		cdptitle2.setBounds(60, 0, 350, 50);
		btn6=new JButton("카드 뽑기");
		btn6.setBackground(brown);
		btn6.setFont(f2);
		btn6.setBorderPainted(false);
		btn6.setBounds(65, 55, 140, 40);
		btn6.addActionListener(this);
		btn7=new JButton("해석 결과");
		btn7.setBackground(brown);
		btn7.setFont(f2);
		btn7.setBorderPainted(false);
		btn7.setBounds(230, 562, 120, 40);
		btn7.addActionListener(this);
		tinp=new JTextField();
		tinp.setBounds(360, 567, 500, 30);
		tcard1=new JLabel(cardimage("D:\\그림\\3-2.jpg",248,410));
		tcard1.setBounds(100, 117, 250, 410);
		tct1=cardtitle();
		tct1.setBounds(160, 525, 250, 50);
		tcard2=new JLabel(cardimage("D:\\그림\\3-1.jpg",248,410));
		tcard2.setBounds(480, 117, 250, 410);
		tct2=cardtitle();
		tct2.setBounds(540, 525, 250, 50);
		tcard3=new JLabel(cardimage("D:\\그림\\3-3.jpg",248,410));
		tcard3.setBounds(860, 117, 250, 410);
		tct3=cardtitle();
		tct3.setBounds(920, 525, 250, 50);
		String[] list= {"인과","시제","시간"};
		inpway=new JList<String>(list);
		inpway.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		inpway.setBounds(870, 567, 50, 60);
		panel.add(cdptitle2);
		panel.add(btn6);
		panel.add(btn7);
		panel.add(tinp);
		panel.add(tcard1);
		panel.add(tcard2);
		panel.add(tcard3);
		panel.add(tct1);
		panel.add(tct2);
		panel.add(tct3);
		panel.add(inpway);
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
		ul=new JList<String>(load.getuserlsit());
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
	private ImageIcon cardimage(String imgpath, int w, int h) {
		Image image1=new ImageIcon(imgpath).getImage();
		Image scalp1=image1.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		ImageIcon icon=new ImageIcon(scalp1);
		return icon;
	}
	
	public JPanel getMpanel() {
		return mpanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			cdptitle1.setText("");
			cdptitle1.setVisible(false);
			cdptitle2.setText("");
			cdptitle2.setVisible(false);
			ocard.setIcon(cardimage("D:\\그림\\3-1.jpg",248,410));
			uresist();
			card.show(mpanel,"p2");
		}else if(e.getSource()==btn2) {
			cdptitle1.setText("");
			cdptitle1.setVisible(false);
			cdptitle2.setText("");
			cdptitle2.setVisible(false);
			ocard.setIcon(cardimage("D:\\그림\\3-1.jpg",248,410));
			uresist();
			card.show(mpanel,"p3");
		}else if(e.getSource()==btn3) {
			user=ul.getSelectedValue();
			String[] s=user.split(" ");
			ores.setUnum(s[1]);
			tres.setUnum(s[1]);
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
			oct.setText(mj.getCardnum()+mj.getName()+"-"+mj.getWay());
			ocard.setIcon(cardimage(imgpath,250,410));
		}else if(e.getSource()==btn5) {
			ores.setInterpret(oinp.getText());
			OneDAO odao=new OneDAO();
			odao.insert(ores);
			oinp.setText("");
			oct.setText("");
			ocard.setIcon(cardimage("D:\\그림\\3-1.jpg",248,410));
			userp.revone();
			user=ul.getSelectedValue();
			String[] s=user.split(" ");
			UserDAO u=new UserDAO();
			u.increasecnt(s[1]);
			userp.revul();
		}else if(e.getSource()==btn6) {
			tcnt++;
			MajorDTO mj=null;
			MinorDTO mi=null;
			String imgpath=null;
			int r1=ran.nextInt(2);
			int r2=-1;;
			if(r1==0) {
				r2=ran.nextInt(44);
			}else if(r1==1) {
				r2=ran.nextInt(56);
			}
			while(true) {
				if(tcnt==2) {
					if(r1==0) {
						if(dpnum1==r2) {
							r2=ran.nextInt(44);
						}else {
							break;
						}
					}else if(r1==1) {
						if(dpnum1==r2) {
							r2=ran.nextInt(56);
						}else {
							break;
						}
					}
				}else if(tcnt==3) {
					if(r1==0) {
						if(pack1==0&&dpnum1==r2) {
							r2=ran.nextInt(44);
						}else if(pack2==0&&dpnum2==r2) {
							r2=ran.nextInt(44);
						}else if(pack1==0&&pack2==0&&dpnum1==r2||dpnum2==r2) {
							r2=ran.nextInt(44);
						}else {
							break;
						}
					}else if(r1==1) {
						if(pack1==1&&dpnum1==r2) {
							r2=ran.nextInt(56);
						}else if(pack2==1&&dpnum2==r2) {
							r2=ran.nextInt(56);
						}else if(pack1==1&&pack2==1&&dpnum1==r2||dpnum2==r2) {
							r2=ran.nextInt(56);
						}else {
							break;
						}
					}
				}else {
					break;
				}
			}
			if(tcnt==1) {
				if(r1==0) {
					mj=load.getmajor(r2);
					dcard.setCard1(mj.getMajornum());
					dcard.setCard4(0);
					imgpath=mj.getImagepath();
					tct1.setText(mj.getCardnum()+mj.getName()+"-"+mj.getWay());
					tcard1.setIcon(cardimage(imgpath,248,410));
					pack1=0;
					dpnum1=r2;
				}else if(r1==1) {
					mi=load.getminor(r2);
					dcard.setCard1(0);
					dcard.setCard4(mi.getMinornum());
					imgpath=mi.getImagepath();
					tct1.setText(mi.getSuits()+"-"+mi.getCardnum());
					tcard1.setIcon(cardimage(imgpath,248,410));
					pack1=1;
					dpnum1=r2;
				}
			}else if(tcnt==2) {
				if(r1==0) {
					mj=load.getmajor(r2);
					dcard.setCard2(mj.getMajornum());
					dcard.setCard5(0);
					imgpath=mj.getImagepath();
					tct2.setText(mj.getCardnum()+mj.getName()+"-"+mj.getWay());
					tcard2.setIcon(cardimage(imgpath,248,410));
					pack2=0;
					dpnum2=r2;
				}else if(r1==1) {
					mi=load.getminor(r2);
					dcard.setCard2(0);
					dcard.setCard5(mi.getMinornum());
					imgpath=mi.getImagepath();
					tct2.setText(mi.getSuits()+"-"+mi.getCardnum());
					tcard2.setIcon(cardimage(imgpath,248,410));
					pack2=1;
					dpnum2=r2;
				}
			}else if(tcnt==3) {
				if(r1==0) {
					mj=load.getmajor(r2);
					dcard.setCard3(mj.getMajornum());
					dcard.setCard6(0);
					imgpath=mj.getImagepath();
					tct3.setText(mj.getCardnum()+mj.getName()+"-"+mj.getWay());
					tcard3.setIcon(cardimage(imgpath,248,410));
				}else if(r1==1) {
					mi=load.getminor(r2);
					dcard.setCard3(0);
					dcard.setCard6(mi.getMinornum());
					imgpath=mi.getImagepath();
					tct3.setText(mi.getSuits()+"-"+mi.getCardnum());
					tcard3.setIcon(cardimage(imgpath,248,410));
				}
				pack1=-1;
				pack2=-1;
				dpnum1=-1;
				dpnum2=-1;
				tcnt=0;
			}
		}else if(e.getSource()==btn7) {
			DrawcDAO ddao=new DrawcDAO();
			ddao.insert(dcard);
			load.drawload();
			tres.setPnum(ddao.pnumload(dcard));
			tres.setInterpret(tinp.getText());
			tres.setInterway(inpway.getSelectedValue());
			ThreeDAO tdao=new ThreeDAO();
			tdao.insert(tres);
			tinp.setText("");
			tct1.setText("");
			tct2.setText("");
			tct3.setText("");
			tcard1.setIcon(cardimage("D:\\그림\\3-2.jpg",248,410));
			tcard2.setIcon(cardimage("D:\\그림\\3-1.jpg",248,410));
			tcard3.setIcon(cardimage("D:\\그림\\3-3.jpg",248,410));
			userp.revthree();
			user=ul.getSelectedValue();
			String[] s=user.split(" ");
			UserDAO u=new UserDAO();
			u.increasecnt(s[1]);
			userp.revul();
		}
	}
}
