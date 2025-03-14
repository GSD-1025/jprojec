package user;

import java.util.Random;

import lombok.Data;

@Data
public class UserDTO {
	private String name;
	private String unum;
	private int age;
	private String phone; 
	
	
	public void prt() {
		System.out.print(this.name+" ");
		System.out.print(this.unum+" ");
		System.out.print(this.age+" ");
		System.out.print(this.phone+" ");
		System.out.println();
	}
}
