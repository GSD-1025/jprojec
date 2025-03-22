package main;

import java.util.ArrayList;

import card.DrawcDAO;
import card.DrawcDTO;
import card.MajorDAO;
import card.MajorDTO;
import card.MinorDAO;
import card.MinorDTO;
import user.UserDAO;
import user.UserDTO;

public class Load {
	
	private static Load load=null;
	private ArrayList<MajorDTO> major= new ArrayList<>();
	private ArrayList<MinorDTO> minor=new ArrayList<>();
	private ArrayList<UserDTO> ulist=userLoad();
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
		drawload();
	}
	
	private void drawload() {
		DrawcDAO d=new DrawcDAO();
		dlist=d.drawload();
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
	
	
	
	public MajorDTO getmajor(int i) {
		MajorDTO mj=major.get(i);
		return mj;
	}
	public MinorDTO getminor(int i) {
		MinorDTO mi=minor.get(i);
		return mi;
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
	public String[] getuserlsit(){
		ArrayList<String> list=new ArrayList<>();
		for(UserDTO u: userLoad()) {
			list.add(u.getName()+" "+u.getUnum());
		}
		String[] ulist=new String[list.size()];
		for(int i=0; i<ulist.length; i++) {
			ulist[i]=list.get(i);
		}
		return ulist;
	}
}
