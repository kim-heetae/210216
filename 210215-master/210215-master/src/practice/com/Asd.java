package practice.com;

import java.util.Scanner;

public class Asd {

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
		
	}

}

