package card;

import lombok.Data;

@Data
public class DrawcDTO {
	private int pnum;
	private int card1;
	private int card2;
	private int card3;
	private int card4;
	private int card5;
	private int card6;
	
	public void prt() {
		System.out.print(this.pnum);
		System.out.print(" "+this.card1);
		System.out.print(" "+this.card2);
		System.out.print(" "+this.card3);
		System.out.print(" "+this.card4);
		System.out.print(" "+this.card5);
		System.out.print(" "+this.card6);
		System.out.println();
	}
}
