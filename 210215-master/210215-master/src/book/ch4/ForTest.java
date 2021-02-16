package book.ch4;

import book.ch4.ForTest;

public class ForTest {

//	int hap = 0;
//	
//	void hapfor() {
//		for(int i = 1; i <= 10; i++) {
//			if(i % 2 == 0) {
//				hap += i;
//			}
//			else {//없어도 가능
//				continue;
//			}
//		}
//		System.out.println(hap);
//		hap = 0;
//	}
//	
//	void hapwhile() {
//		int i = 1;
//		while(i <= 10) {
//			i++;
//			if(i % 2 == 0) {
//				hap += i;
//			}
//			else {//없어도 가능
//				continue;
//			}
//		}
//		System.out.println(hap);
//		hap = 0;
//	}
	
	public static void main(String[] args) {
//		ForTest ft = new ForTest();
//		ft.hapfor();
//		ft.hapwhile();
		int hap = 0;
		int even = 0;
		int odd = 0;
		int hap2 = 0;

		//1부터 10까지 짝수의 합을 구하시오
		for(int i = 1; i <= 10; i++) {
			if(i % 2 ==0) {
				hap += i;
			}
		}
		System.out.println(hap);
		
		//1부터 10까지 홀수의 합과 짝수의 합을 구하시오
		for(int i = 1; i <=10; i++) {
			if(i % 2 == 0) {
				even += i;
			}
			else {
				odd += i;
			}
		}
		System.out.println("짝수의 합은  " + even + "입니다.");
		System.out.println("홀수의 합은  " + odd + "입니다.");
		
		//1부터 10까지 합을 구하시오
		for(int i = 1; i <= 10; i++) {
			hap2 += i;
			System.out.println( i + "까지의 합은 " + hap2 + "");
		}
	}
	

}
