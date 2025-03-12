package main;

public class Main {
	
	public static void main(String[] args) {
		Load load=Load.getInstance();
		load.check();
		Admin adm=Admin.getInstance(load);
		adm.menu();
	}

}
