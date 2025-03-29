package main;

import gui.Mainmenu;

public class Main {
	
	public static void main(String[] args) {
		Load.getInstance();
		new Mainmenu();
	}
}
