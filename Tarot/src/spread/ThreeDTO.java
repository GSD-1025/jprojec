package spread;

import lombok.Data;

@Data
public class ThreeDTO extends Spread{
	private int card1;
	private int card2;
	private int card3;
	private String interway;
	
	public void prt() {
		System.out.print(super.getResnum()+" ");
		System.out.print(super.getUnum()+" ");
		System.out.print(this.card1+" ");
		System.out.print(this.card2+" ");
		System.out.print(this.card3+" ");
		System.out.print(this.interway+" ");
		System.out.print(super.getInterpret()+" ");
		System.out.print(super.getDuedate()+" ");
		System.out.println();
	}
}
