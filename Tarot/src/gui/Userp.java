package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import user.UserDAO;
import user.UserDTO;

public class Userp extends JPanel implements ActionListener{
	
	private JPanel newuser;
	private JPanel userlist;
	private JPanel deco;
	private JPanel itplist;
	private GridBagConstraints gcon=new GridBagConstraints();
	private GridBagLayout g;
	private Font f=new Font(Font.SERIF,Font.BOLD|Font.ITALIC,20);
	private JButton btn1;
	private JTextField nbox= new JTextField(20);
	private JTextField agbox= new JTextField(20);
	private JTextField phbox= new JTextField(20);
	
	public JPanel panel() {
		g=new GridBagLayout();
		JPanel panel=new JPanel(g);
		gcon.weightx=1;
		gcon.weighty=1;
		gcon.fill=GridBagConstraints.BOTH;
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,7)));
		newuser=settingnlp();
		constraint(newuser,0,0,1,1,0.15,0.23);
		panel.add(newuser);
		userlist=settingulp();
		constraint(userlist,1,0,1,1,0.85,0.23);
		panel.add(userlist);
		deco=settingdeco();
		constraint(deco,0,1,1,1,0,0.77);
		panel.add(deco);
		itplist=settingilp();
		constraint(itplist,1,1,1,1,1,0.77);
		panel.add(itplist);
		return panel;
	}
	
	private JPanel settingnlp() {
		JPanel temp=new JPanel();
		temp.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1)));
		temp.setLayout(new BorderLayout());
		temp.setOpaque(false);
		JLabel lb1=new JLabel("이용자 등록");
		lb1.setHorizontalAlignment(JLabel.LEFT);
		lb1.setFont(f);
		lb1.setForeground(Color.BLACK);
		temp.add("North",lb1);
		temp.add("Center",uinsert());
		btn1= new JButton("입력");
		btn1.addActionListener(this);
		temp.add("South",btn1);
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
		JLabel ph=new JLabel("핸드폰(- 제외)");
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
		return temp;
	}
	private JPanel settingdeco() {
		JPanel temp=new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Image backimage=Mainmenu.getRanimg();
				g.drawImage(backimage, 0, 0, 335, 420, null);
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
		return temp;
	}

	private void constraint(Component c, int x, int y, int w, int h, double wx, double wy) {
		gcon.gridx=x;
		gcon.gridy=y;
		gcon.gridheight=w;
		gcon.gridheight=h;
		gcon.weightx=wx;
		gcon.weighty=wy;
		g.setConstraints(c, gcon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			Random r=new Random();
			UserDTO u=new UserDTO();
			UserDAO udao=new UserDAO();
			String name=nbox.getText();
			int age=Integer.parseInt(agbox.getText());
			String phone=phbox.getText();
			String rnum="";
			for(int i=0; i<9;i++) {
				rnum+=String.valueOf(r.nextInt(10));
			}
			System.out.println(u.getAge()+" "+u.getName()+" "+u.getPhone()+" "+u.getUnum());
			u.setAge(age);
			u.setName(name);
			u.setPhone(phone);
			u.setUnum(rnum);
			System.out.println(u.getAge()+" "+u.getName()+" "+u.getPhone()+" "+u.getUnum());
			udao.insert(u);
			nbox.setText("");
			agbox.setText("");
			phbox.setText("");
		}
		
	}

}
