package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import main.Load;
import spread.OneDAO;
import spread.OneDTO;
import spread.ThreeDAO;
import spread.ThreeDTO;
import user.UserDAO;
import user.UserDTO;

public class Userp extends JPanel implements ActionListener{
	
	
	private Load load=Load.getInstance();
	private UserDAO udao=new UserDAO();
	private OneDAO o=new OneDAO();
	private ThreeDAO t=new ThreeDAO();
	private CardLayout card;
	private JLabel ujl;
	private JPanel temp2;
	private JPanel ttemp3;
	private JPanel newuser;
	private JPanel userlist;
	private JPanel deco;
	private JPanel itplist;
	private Font f=new Font(Font.SERIF,Font.BOLD|Font.ITALIC,20);
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JTextField nbox= new JTextField(20);
	private JTextField agbox= new JTextField(20);
	private JTextField phbox= new JTextField(20);
	private JTable jt1;
	private JTable jt2;
	private JTable jt3;
	private JTable jt4;
	private JScrollPane ujs;
	private Color brown=new Color(88,64,52);
	


	
	public JPanel panel() {
		JPanel panel=new JPanel(null);
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,7)));
		newuser=settingnup();
		newuser.setBounds(7, 3, 300, 290);
		panel.add(newuser);
		userlist=settingulp();
		userlist.setBounds(307, 3, 445, 200);
		panel.add(userlist);
		deco=settingdeco();
		deco.setBounds(7, 293, 298, 394);
		panel.add(deco);
		itplist=settingilp();
		itplist.setBounds(307,204,900,383);
		panel.add(itplist);
		card=(CardLayout) temp2.getLayout();
		btn3=new JButton("One");
		btn3.setFont(f);
		btn3.setBackground(brown);
		btn3.setBounds(750, 7, 140, 199);
		btn3.addActionListener(this);
		btn4=new JButton("Three");
		btn4.setFont(f);
		btn4.setBackground(brown);
		btn4.setBounds(890, 7, 140, 199);
		btn4.addActionListener(this);
		btn5=new JButton("Search");
		btn5.setFont(f);
		btn5.setBackground(brown);
		btn5.setBounds(1030,7, 152, 199);
		btn5.addActionListener(this);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		return panel;
	}
	
	private JPanel settingnup() {
		JPanel temp=new JPanel();
		temp.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1)));
		temp.setLayout(new BorderLayout());
		temp.setOpaque(false);
		JLabel lb1=new JLabel("이용자 등록/삭제");
		lb1.setHorizontalAlignment(JLabel.LEFT);
		lb1.setFont(f);
		lb1.setForeground(Color.BLACK);
		temp.add("North",lb1);
		temp.add("Center",uinsert());
		JPanel temp2=new JPanel(new GridLayout(1,2));
		temp.add("South",temp2);
		btn1= new JButton("입력");
		btn1.addActionListener(this);
		temp2.add("South",btn1);
		btn2= new JButton("삭제");
		btn2.addActionListener(this);
		temp2.add("South", btn2);
		return temp;
	}	
	private JPanel uinsert() {
		JPanel temp=new JPanel(new GridLayout(6,1));
		temp.setOpaque(false);
		JLabel name=new JLabel("이름");
		name.setForeground(Color.BLACK);
		name.setHorizontalAlignment(JLabel.LEFT);
		JLabel age=new JLabel("나이");
		age.setForeground(Color.BLACK);
		age.setHorizontalAlignment(JLabel.LEFT);
		JLabel ph=new JLabel("등록: 핸드폰(- 제외)/ 검색, 삭제: 회원번호");
		ph.setForeground(Color.BLACK);
		ph.setHorizontalAlignment(JLabel.LEFT);
		temp.add(name);
		temp.add(nbox);
		temp.add(age);
		temp.add(agbox);
		temp.add(ph);
		temp.add(phbox);
		return temp;
	}
	
	private JPanel settingulp() {
		JPanel temp=new JPanel();
		temp.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1)));
		temp.setLayout(new BorderLayout());
		temp.setOpaque(false);
		JLabel lb1=new JLabel("이용자 정보");
		lb1.setHorizontalAlignment(JLabel.LEFT);
		lb1.setFont(f);
		lb1.setForeground(Color.BLACK);
		temp.add("North",lb1);
		temp.add("West",ulinsert());
		return temp;
	}
	private JScrollPane ulinsert() {
		ArrayList<UserDTO> u=load.userLoad();
		String[] header= {"이름","회원번호","나이","전화번호","이용횟수"};
		String[][] contents= new String[u.size()][5];
		for(int i=0; i<u.size(); i++) {
			contents[i][0]=u.get(i).getName();
			contents[i][1]=u.get(i).getUnum();
			contents[i][2]=String.valueOf(u.get(i).getAge());
			contents[i][3]=u.get(i).getPhone();
			contents[i][4]=String.valueOf(u.get(i).getCnt());
		}
		DefaultTableModel defaultmodel = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
		};
		jt1= new JTable(defaultmodel);
		jt1.setFont(new Font(Font.SERIF,Font.ITALIC,12));
		JScrollPane stemp=new JScrollPane(jt1);
		stemp.setPreferredSize(new Dimension(440,200));
		return stemp;
	}
	
	
	private JPanel settingdeco() {
		JPanel temp=new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Image backimage=Mainmenu.getRanimg();
				g.drawImage(backimage, 0, 0, 300, 400, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		return temp;
	}
	
	private JPanel settingilp() {
		JPanel temp=new JPanel();
		temp.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1)));
		temp.setOpaque(false);
		temp.setLayout(new BorderLayout());
		JLabel lb1=new JLabel("해석 결과");
		lb1.setHorizontalAlignment(JLabel.LEFT);
		lb1.setFont(f);
		lb1.setForeground(Color.BLACK);
		temp.add("North",lb1);
		temp2=new JPanel(new CardLayout());
		JPanel ttemp1=new JPanel(new BorderLayout());
		JPanel ttemp2=new JPanel(new BorderLayout());
		ttemp3=new JPanel(new BorderLayout());
		temp2.setOpaque(false);
		temp.add("West",temp2);
		Font f2=new Font(Font.SERIF,Font.BOLD|Font.ITALIC,15);
		JLabel t1=new JLabel("원 스프레드");
		t1.setFont(f2);
		t1.setForeground(Color.BLACK);
		JLabel t2=new JLabel("쓰리 스프레드");
		t2.setFont(f2);
		t2.setForeground(Color.BLACK);
		ujl= new JLabel("대상 없음");
		ujl.setFont(f2);
		ujl.setForeground(Color.BLACK);
		JScrollPane js1=oneinsert();
		JScrollPane js2=threeinsert();
		ujs=specific("0000");
		ttemp1.add("North",t1);
		ttemp1.add("West",js1);
		ttemp1.setOpaque(false);
		temp2.add(ttemp1,"P1");
		ttemp2.add("North",t2);
		ttemp2.add("West",js2);
		ttemp2.setOpaque(false);
		temp2.add(ttemp2,"P2");
		ttemp3.add("North",ujl);
		ttemp3.add("West",ujs);
		ttemp3.setOpaque(false);
		temp2.add(ttemp3,"P3");
		return temp;
	}
	private JScrollPane oneinsert() {
		ArrayList<OneDTO> olist=o.loadOne();
		String[] header= {"카드","해석 결과","회원번호"};
		String[][] contents= new String[olist.size()][3];
		for(int i=0; i<olist.size(); i++) {
			contents[i][0]=load.getcard(olist.get(i).getMnum());
			contents[i][1]=olist.get(i).getInterpret();
			contents[i][2]=olist.get(i).getUnum();
		}
		DefaultTableModel defaultmodel = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
		};
		jt2= new JTable(defaultmodel);
		jt2.setFont(new Font(Font.SERIF,Font.ITALIC,12));
		jt2.getColumn("카드").setPreferredWidth(100);
		jt2.getColumn("해석 결과").setPreferredWidth(480);
		jt2.getColumn("회원번호").setPreferredWidth(10);
		JScrollPane stemp=new JScrollPane(jt2);
		stemp.setPreferredSize(new Dimension(875,100));
		return stemp;
	}	
	private JScrollPane threeinsert() {
		ArrayList<ThreeDTO> tlist=t.loadThree();
		String[] header= {"카드","해석 결과","회원번호"};
		String[][] contents= new String[tlist.size()][3];
		for(int i=0; i<tlist.size(); i++) {
			contents[i][0]=load.threecard(i);
			contents[i][1]=tlist.get(i).getInterway()+": "+tlist.get(i).getInterpret();
			contents[i][2]=tlist.get(i).getUnum();
		}
		DefaultTableModel defaultmodel = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
		};
		jt3= new JTable(defaultmodel);
		jt3.setFont(new Font(Font.SERIF,Font.ITALIC,12));
		jt3.getColumn("카드").setPreferredWidth(160);
		jt3.getColumn("해석 결과").setPreferredWidth(435);
		jt3.getColumn("회원번호").setPreferredWidth(10);
		JScrollPane stemp=new JScrollPane(jt3);
		stemp.setPreferredSize(new Dimension(875,100));
		return stemp;
	}
	private JScrollPane specific(String unum) {
		ArrayList<OneDTO> olist=o.loadOne();
		ArrayList<ThreeDTO> tlist=t.loadThree();
		String[] header= {"카드","해석 결과","회원번호"};
		String[][] contents= new String[olist.size()+tlist.size()][3];
		for(int i=0; i<olist.size(); i++) {
			if(olist.get(i).getUnum().equals(unum)) {
				contents[i][0]=load.getcard(olist.get(i).getMnum());
				contents[i][1]=olist.get(i).getInterpret();
				contents[i][2]=olist.get(i).getUnum();
			}
		}
		for(int i=0; i<tlist.size(); i++) {
			if(tlist.get(i).getUnum().equals(unum)) {
				contents[i+olist.size()][0]=load.threecard(i);
				contents[i+olist.size()][1]=tlist.get(i).getInterway()+": "+tlist.get(i).getInterpret();
				contents[i+olist.size()][2]=tlist.get(i).getUnum();
			}
		}
		DefaultTableModel model = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
		};
		for(int i=0; i<model.getRowCount(); i++) {
			if(model.getValueAt(i, 2)==null) {
				model.removeRow(i);
				i--;
			}
		}
		jt4=new JTable(model);
		jt4.setFont(new Font(Font.SERIF,Font.ITALIC,12));
		jt4.getColumn("카드").setPreferredWidth(160);
		jt4.getColumn("해석 결과").setPreferredWidth(435);
		jt4.getColumn("회원번호").setPreferredWidth(10);
		JScrollPane stemp=new JScrollPane(jt4);
		stemp.setPreferredSize(new Dimension(875,100));
		return stemp;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			Random r=new Random();
			UserDTO u=new UserDTO();
			if(nbox.getText().equals("")||agbox.getText().equals("")||phbox.getText().equals("")) {
				nbox.setText("");
				agbox.setText("");
				phbox.setText("");
				return;
			}
			String name=nbox.getText();
			int age=Integer.parseInt(agbox.getText());
			String phone=phbox.getText();
			String rnum="";
			for(int i=0; i<9;i++) {
				rnum+=String.valueOf(r.nextInt(10));
			}
			u.setAge(age);
			u.setName(name);
			u.setPhone(phone);
			u.setUnum(rnum);
			udao.insert(u);
			addulist(u);
			nbox.setText("");
			agbox.setText("");
			phbox.setText("");		
		}else if(e.getSource()==btn2) {
			String name=nbox.getText();
			String unum=phbox.getText();
			o.delete(unum);
			t.delete(unum);
			udao.delete(name,unum);
			for(int i=0; i<jt1.getRowCount(); i++) {
				if(jt1.getValueAt(i, 1).equals(unum)) {
					deletelist(i,1);
					i--;
				}
			}
			for(int i=0; i<jt2.getRowCount(); i++) {
				if(jt2.getValueAt(i, 2).equals(unum)) {
					deletelist(i,2);
					i--;
				}
			}
			for(int i=0; i<jt3.getRowCount(); i++) {
				if(jt3.getValueAt(i, 2).equals(unum)) {
					deletelist(i,3);
					i--;
				}
			}
			nbox.setText("");
			agbox.setText("");
			phbox.setText("");
		}else if(e.getSource()==btn3) {
			card.show(temp2, "P1");
		}else if(e.getSource()==btn4) {
			card.show(temp2,"P2");
		}else if(e.getSource()==btn5) {
			String unum=phbox.getText();
			if(unum.equals("")) {
				ttemp3.remove(ujs);
				unum="대상 없음";
			}else {
				ttemp3.remove(ujs);
				ujs=specific(unum);
				ttemp3.add("West",ujs);
			}
			ujl.setText(unum);
			card.show(temp2, "P3");
			phbox.setText(null);
		}
		
	}

	public void addulist(UserDTO u) {
		DefaultTableModel model=(DefaultTableModel)jt1.getModel();
		String[] record=new String[5];
		record[0]=u.getName();
		record[1]=u.getUnum();
		record[2]=String.valueOf(u.getAge());
		record[3]=u.getPhone();
		record[4]=String.valueOf(0);
		model.addRow(record);
	}
	
	public void deletelist(int index, int i) {
		if(i==1) {
			DefaultTableModel model=(DefaultTableModel)jt1.getModel();
			if(index<0) {
				return;
			}
			model.removeRow(index);
		}else if(i==2) {
			DefaultTableModel model=(DefaultTableModel)jt2.getModel();
			if(index<0) {
				return;
			}
			model.removeRow(index);
		}else if(i==3) {
			DefaultTableModel model=(DefaultTableModel)jt3.getModel();
			if(index<0) {
				return;
			}
			model.removeRow(index);
		}
		
	}
	
}
