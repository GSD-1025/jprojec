package card;

import lombok.Getter;

@Getter
public class MajorDTO extends Card{
	
	private String name=null;
	private String way=null;
	private int majornum;
	
	
	@Override
	public void setName(String name) {
		this.name=name;
	}
	@Override
	public void setWay(String way) {
		this.way=way;
	}
	@Override
	public void setNum(int num) {
		this.majornum=num;
	}
	public void prt() {
		System.out.print(super.getCardnum());
		System.out.print(this.name);
		System.out.print(this.way);
		System.out.print(super.getMean());
		System.out.print(this.majornum);
		System.out.print(this.majornum);
		System.out.println(super.getImagepath());
	}
	
}
