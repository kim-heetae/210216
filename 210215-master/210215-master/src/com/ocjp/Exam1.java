package com.ocjp;

public class Exam1 {

	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		
		if((++i > j--) & (++i > j)){
			
		}else {
			System.out.println(i + "" + j);
		}
		
		i = 1;
		j = 2;
		
		if((++i > j--) && (++i > j)) {
			
		}
		else {
			System.out.println(i + "" + j);
		}
	}

}
