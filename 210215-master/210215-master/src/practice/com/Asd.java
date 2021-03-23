package practice.com;

import java.util.Scanner;

public class Asd {
	int c = 10;
	class InnerClass{
		public InnerClass(){
			a();
		}
		int a = 0;
		public void a() {
			System.out.println(a);
		}
		class Innerinner{
			int b = 1;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputn = sc.nextInt();
		for(int i = inputn; i > 0; i--) {
			for(int j = 0; j < inputn; j++) {
				System.out.print("*");
			}
			inputn = inputn - 1;
			System.out.println("");
		}
		Asd asd = new Asd();
		asd.c = 15;
//		new Asd.new InnerClass() {
//			public void a() {
//				System.out.println("재정의");
//			}
//		};
		Asd.InnerClass inn = asd.new InnerClass(); 
		Asd.InnerClass.Innerinner inninn = inn.new Innerinner();
		System.out.println(inn.a);
		System.out.println(inninn.b);
	}

}

