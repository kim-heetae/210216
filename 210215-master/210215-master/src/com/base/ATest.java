package com.base;

import variable.step1.A;
//public > protected > friendly > private
//변역변수를 선언할때 접근제한자를 적지않고 자료형부터 적으면 friendly상태가 되어 
//다른 패키지에서 접근할 수 없다. 
public class ATest {

	public static void main(String[] args) {
		A a = new A();
		System.out.println("국어 : " + a.kor);//0
	}

}
