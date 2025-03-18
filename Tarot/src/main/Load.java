package main;

import java.util.ArrayList;

import card.DrawcDAO;
import card.DrawcDTO;
import card.MajorDAO;
import card.MajorDTO;
import card.MinorDAO;
import card.MinorDTO;
import spread.OneDAO;
import spread.OneDTO;
import spread.ThreeDAO;
import spread.ThreeDTO;
import user.UserDAO;
import user.UserDTO;

public class Load {
	
	private static Load load=null;
	private ArrayList<MajorDTO> major= new ArrayList<>();
	private ArrayList<MinorDTO> minor=new ArrayList<>();
	private ArrayList<UserDTO> ulist=userLoad();
	private ArrayList<OneDTO> olist=new ArrayList<OneDTO>();
	private ArrayList<ThreeDTO> tlist=new ArrayList<ThreeDTO>();
	private ArrayList<DrawcDTO> dlist=new ArrayList<DrawcDTO>();
	
	
	public static Load getInstance() {
		if(load==null) {
			load=new Load();
		}
		return load; 
		
	}
	
	private Load() {
		cardLoad();
		userLoad();
		spreadLoad();
		drawload();
		check();
	}
	
	private void drawload() {
		DrawcDAO d=new DrawcDAO();
		dlist=d.drawload();
	}

	private void spreadLoad() {
		OneDAO o= new OneDAO();
		olist=o.loadOne();
		ThreeDAO t= new ThreeDAO();
		tlist=t.loadThree();
	}

	public ArrayList<UserDTO> userLoad() {
		UserDAO u= new UserDAO();
		ulist=u.loadUser();
		return ulist;
	}
	
	private void cardLoad() {
		MajorDAO ma=new MajorDAO();
		major=ma.loadMajor();
		MinorDAO mi=new MinorDAO(); 
		minor=mi.loadMinor();
	}
	
	public String getimagepath(int i, int k) {
		if(i==1) {
			return major.get(2*k).getImagepath();
		}else if(i==2) {
			return minor.get(k).getImagepath();
		}
		return null;
	}
	
	public MajorDTO getmajor(int i) {
		MajorDTO mj=major.get(2*i);
		return mj;
	}
	public MinorDTO getminor(int i) {
		MinorDTO mi=minor.get(i);
		return mi;
	}
	
	
	public String getcard(int j) {
		return major.get(j).getName();
		
	}
	
	public String threecard(int i) {
		String cardsum="";
		if(dlist.get(i).getCard1()!=0) {
			cardsum+=major.get(dlist.get(i).getCard1()-1).getName()+major.get(dlist.get(i).getCard1()-1).getWay()+" ";
		}else if(dlist.get(i).getCard4()!=0) {
			cardsum+=minor.get(dlist.get(i).getCard4()-1).getSuits()+minor.get(dlist.get(i).getCard4()-1).getCardnum()+" ";
		}
		if(dlist.get(i).getCard2()!=0) {
			cardsum+=major.get(dlist.get(i).getCard2()-1).getName()+major.get(dlist.get(i).getCard2()-1).getWay()+" ";
		}else if(dlist.get(i).getCard5()!=0) {
			cardsum+=minor.get(dlist.get(i).getCard5()-1).getSuits()+minor.get(dlist.get(i).getCard5()-1).getCardnum()+" ";
		}
		if(dlist.get(i).getCard3()!=0) {
			cardsum+=major.get(dlist.get(i).getCard3()-1).getName()+major.get(dlist.get(i).getCard3()-1).getWay()+" ";
		}else if(dlist.get(i).getCard6()!=0) {
			cardsum+=minor.get(dlist.get(i).getCard6()-1).getSuits()+minor.get(dlist.get(i).getCard6()-1).getCardnum()+" ";
		}
		return cardsum;
	}
	
	
	
	
	
	public void check() { //과정 확인용
		//for(MajorDTO m: major) {
			//m.prt();
		//}
		//for(MinorDTO m: minor) {
			//m.prt();
		//}
		//for(UserDTO u: ulist) {
			//u.prt();
		//}
		//for(OneDTO o: olist) {
			//o.prt();
		//}
		//for(ThreeDTO t: tlist) {
			//t.prt();
		//}
		//for(DrawcDTO d:dlist) {
			//d.prt();
		//}
	}

}
