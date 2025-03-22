package card;

import lombok.Data;

@Data

public class MajorDTO extends Card{
	
	private String name=null;
	private String way=null;
	private int majornum;
	
	
	
	public void prt() {
		System.out.print(super.getCardnum());
		System.out.print(this.name);
		System.out.print(this.way);
		System.out.print(super.getMean());
		System.out.print(this.majornum);
		System.out.println(super.getImagepath());
	}
	
}
