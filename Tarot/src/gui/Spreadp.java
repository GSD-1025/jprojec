package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Spreadp extends JPanel implements ActionListener{
	
	private CardLayout card;
	private JPanel mpanel;
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JButton btn1;
	private JButton btn2;
	
	
	
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
		btn1=new JButton("1CARD");
		btn1.addActionListener(this);
		btn2=new JButton("3CARD");
		btn2.addActionListener(this);
		panel.add(btn1);
		panel.add(btn2);
		return panel;
	}
	public JPanel oneP() {
		JPanel panel=new JPanel();
		
		panel.setBackground(Color.BLUE);
		return panel;
	}
	
	public JPanel threeP() {
		JPanel panel=new JPanel();
		
		panel.setBackground(Color.pink);
		return panel;
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			card.show(mpanel,"p2");
		}else if(e.getSource()==btn2) {
			card.show(mpanel,"p3");
		}
		
	}
}
