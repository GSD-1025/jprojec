package spread;

import lombok.Data;

@Data
public class ThreeDTO extends Spread{
	
	private int pnum;
	private String interway;
	
	public void prt() {
		System.out.print(super.getResnum()+" ");
		System.out.print(super.getUnum()+" ");
		System.out.print(this.interway+" ");
		System.out.print(super.getInterpret()+" ");
		System.out.print(super.getDuedate()+" ");
		System.out.println();
	}
}
