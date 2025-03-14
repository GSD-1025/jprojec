package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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

import card.MajorDTO;
import card.MinorDTO;
import main.Load;

public class Cardp extends JPanel{
	private Load load=Load.getInstance();
	private JButton[] mib=new JButton[56];
	private JButton[] mjb=new JButton[22];
	private Font f=new Font(Font.SERIF,Font.BOLD|Font.ITALIC,20);
	
	public JPanel panel() {
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1,2));
		panel.setOpaque(false);
		panel.add(major());	
		panel.add(minor());
		return panel;
	}
	
	private JPanel major() {
		JPanel panel=new JPanel();
		panel.setOpaque(false);
		JPanel[] pmj= new JPanel[22];
		panel.setLayout(new GridLayout(6,4));
		for(int i=0; i<22; i++) {
			 pmj[i]=new JPanel();
			 pmj[i].setOpaque(false);
			 mjb[i]=addmjbtn(i);
			 mjb[i].addActionListener(new MjListener());
			 pmj[i].add(mjb[i]); 
			 panel.add(pmj[i]);
		}
		return panel;
	}
	private JButton addmjbtn(int i) {
		String mj=load.getimagepath(1,i);
		Image image=new ImageIcon(mj).getImage();
		Image scalp=image.getScaledInstance(70, 109, Image.SCALE_SMOOTH);
		ImageIcon butimg= new ImageIcon(scalp);
		JButton btn=new JButton(butimg);
		btn.setSize(20, 20);
		btn.setBackground(Color.WHITE);
		btn.setOpaque(false);
		btn.setBorderPainted(false);
		return btn;
	}
	
	private JPanel minor() {
		JPanel panel=new JPanel();
		panel.setOpaque(false);
		JPanel[] pmi= new JPanel[56];
		panel.setLayout(new GridLayout(7,8));	
		for(int i=0; i<56; i++) {
			 pmi[i]=new JPanel();
			 pmi[i].setOpaque(false);
			 mib[i]=addmibtn(i);
			 mib[i].addActionListener(new MiListener());
			 pmi[i].add(mib[i]);
			 panel.add(pmi[i]);
		}
		return panel;
	}
	private JButton addmibtn(int i) {
		String mi=load.getimagepath(2,i);
		Image image=new ImageIcon(mi).getImage();
		Image scalp=image.getScaledInstance(60, 91, Image.SCALE_SMOOTH);
		ImageIcon butimg= new ImageIcon(scalp);
		JButton btn=new JButton(butimg);
		btn.setSize(20, 20);
		btn.setBackground(Color.WHITE);
		btn.setOpaque(false);
		btn.setBorderPainted(false);
		return btn;
	}

	class MjListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<22; i++) {
				if(e.getSource()==mjb[i]) {
					MajorDTO mj=load.getmajor(i);
					JDialog d=new JDialog();
					d.setLayout(new BorderLayout());
					d.setTitle(mj.getName());
					d.setBounds(400, 200, 372, 560);
					JLabel mean=new JLabel(mj.getMean());
					mean.setFont(f);
					Image img=new ImageIcon(mj.getImagepath()).getImage().getScaledInstance(372, 500, Image.SCALE_FAST);
					ImageIcon simg=new ImageIcon(img);
					JLabel image=new JLabel(simg);
					d.add("South", mean);
					d.add(image);
					d.setVisible(true);
				}
			}
			
		}
	}
	
	class MiListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<56; i++) {
				if(e.getSource()==mib[i]) {
					MinorDTO mi=load.getminor(i);
					JDialog d=new JDialog();
					d.setLayout(new BorderLayout());
					d.setTitle(mi.getSuits()+" "+mi.getCardnum());
					d.setBounds(400, 200, 372, 560);
					JLabel mean=new JLabel(mi.getMean());
					mean.setFont(f);
					Image img=new ImageIcon(mi.getImagepath()).getImage().getScaledInstance(372, 500, Image.SCALE_FAST);
					ImageIcon simg=new ImageIcon(img);
					JLabel image=new JLabel(simg);
					d.add("South", mean);
					d.add(image);
					d.setVisible(true);
				}
			}
			
		}
		
	}
	
	
	
}
