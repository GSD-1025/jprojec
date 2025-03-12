package spread;

import lombok.Data;

@Data

public class OneDTO extends Spread{
	private int mnum;
	
	
	public void prt() {
		System.out.print(super.getResnum());
		System.out.print(super.getUnum());
		System.out.print(this.mnum);
		System.out.print(super.getInterpret());
		System.out.print(super.getDuedate());
		System.out.println();
	}
	
}
