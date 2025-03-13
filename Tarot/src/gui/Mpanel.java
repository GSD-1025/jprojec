package gui;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class Mpanel extends JPanel{
	
	public static JPanel panel() {
		JPanel panel = new JPanel();
		panel.setLayout(new CardLayout());
		panel.setSize(1208,500);
		panel.setOpaque(false);
		Cardp card=new Cardp();
		panel.add(card.panel());
		return	panel;		
	}
}
