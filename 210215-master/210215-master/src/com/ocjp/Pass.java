package com.ocjp;

public class Pass {

	public static void main(String[] args) {
		int x = 5;
		Pass p = new Pass();
		p.dostuff(x);
		System.out.println("main x = " + x);
	}
	
	void dostuff(int x) {
		System.out.println(" dostuff x = " + x++);
		System.out.println(" dostuff x = " + x);
	}

}
