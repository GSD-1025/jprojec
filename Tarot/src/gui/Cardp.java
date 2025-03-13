package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.Load;

public class Cardp extends JPanel{
	Load load=Load.getInstance();
	
	
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
			 pmj[i].add(addmjbtn(i));
			 panel.add(pmj[i]);
		}
		return panel;
	}
	private JButton addmjbtn(int i) {
		String[] mj=load.getimagepath(1);
		Image image=new ImageIcon(mj[i]).getImage();
		Image scalp=image.getScaledInstance(70, 100, Image.SCALE_FAST);
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
			 pmi[i].add(addmibtn(i));
			 panel.add(pmi[i]);
		}
		return panel;
	}
	private JButton addmibtn(int i) {
		String[] mj=load.getimagepath(2);
		Image image=new ImageIcon(mj[i]).getImage();
		Image scalp=image.getScaledInstance(60, 90, Image.SCALE_FAST);
		ImageIcon butimg= new ImageIcon(scalp);
		JButton btn=new JButton(butimg);
		btn.setSize(20, 20);
		btn.setBackground(Color.WHITE);
		btn.setOpaque(false);
		btn.setBorderPainted(false);
		return btn;
	}
	
	
}
