package card;

import lombok.Data;

@Data
public class MinorDTO extends Card{
	private String suits=null;
	private int minornum;


	public void prt() {
		System.out.print(super.getCardnum());
		System.out.print(this.suits);
		System.out.print(super.getMean());
		System.out.print(this.minornum);
		System.out.println(super.getImagepath());
	}
}
