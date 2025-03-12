package main;

import spread.SpreadM;

public class Admin {
	private Load load=null;
	private static Admin adm=null;
	
	
	
	private Admin(Load load) {
		this.load=load;
	}
	
	public static Admin getInstance(Load load) {
		if(adm==null) {
			adm=new Admin(load);
		}
		return adm;
	}
	
	public void menu() {
		SpreadM sm=new SpreadM();
		sm.onesp();
	}

}
