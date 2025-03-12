package card;

import lombok.Getter;

@Getter
public class MinorDTO extends Card{
	private String suits=null;
	private int minornum;

	@Override
	public void setNum(int num) {
		this.minornum=num;
	}
	@Override
	public void setSuits(String suits) {
		this.suits=suits;
	}
	
	public void prt() {
		System.out.print(super.getCardnum());
		System.out.print(this.suits);
		System.out.print(super.getMean());
		System.out.print(this.minornum);
		System.out.println(super.getImagepath());
	}
}
