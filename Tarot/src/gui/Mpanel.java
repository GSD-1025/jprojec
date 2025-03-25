package gui;

import java.awt.CardLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Mpanel extends JPanel{
	
	public static JPanel panel() {
		JPanel panel = new JPanel();
		panel.setLayout(new CardLayout());
		panel.setSize(1208,500);
		panel.setOpaque(false);
		JPanel noting = new JPanel();
		noting.setOpaque(false);
		panel.add(noting,"Panel1");
		Cardp card=new Cardp();
		panel.add(card.panel(),"Panel2");
		Userp user=Userp.getInstance();
		panel.add(user.panel(),"Panel3");
		Spreadp spread=Spreadp.getInstance();
		panel.add(spread.panel(),"Panel4");
		return panel;
	}
	
	
}

	