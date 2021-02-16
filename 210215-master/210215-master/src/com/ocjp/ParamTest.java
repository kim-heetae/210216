package com.ocjp;

public class ParamTest {

	public static void main(String[] args) {
		Param p = new Param();
		System.out.println(p.ival);
		p.ival = 100;		
		System.out.println(p.ival);
		ParamTest q = new ParamTest(); 
		q.effectParam(p);
		System.out.println(p.ival);
	}
	void effectParam(Param P) {
		P.ival = 500;
		System.out.println(P.ival);
	}
}
