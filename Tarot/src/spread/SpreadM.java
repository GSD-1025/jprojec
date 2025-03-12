package spread;

import java.util.Random;

public class SpreadM {
	private OneDAO odao=OneDAO.getInstance();
	
	public void onesp() {
		Random r= new Random();
		OneDTO o= new OneDTO();	
		int mjnum=r.nextInt(56)+1;
		String inter="예시내용";
		String unum="11111";
		o.setMnum(mjnum);
		o.setInterpret(inter);
		o.setUnum(unum);
		odao.insert(o);
	}
}
