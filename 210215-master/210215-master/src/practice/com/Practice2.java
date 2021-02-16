package practice.com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice2 {

	int num;
	int sum = 0 ;
	boolean err = true;
	void inputN() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("계산하고 싶은 정수를 입력하세요.");
				num = sc.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				err = false;
				System.out.println("정수를 입력해주세요.");
				sc.nextLine();
			}
		}while(!err);
	}
	
	void sum(int num) {
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println(num + "까지의 합은 " + sum + "입니다.");
	}

	public static void main(String[] args) {
		Practice2 pr2 = new Practice2();
		pr2.inputN();
		pr2.sum(pr2.num);
	}

}
