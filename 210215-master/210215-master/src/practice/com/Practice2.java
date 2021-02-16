package practice.com;

import java.util.Scanner;

public class Practice2 {

	int num;
	int sum = 0 ;
	String as;
	void inputN() {
		Scanner sc = new Scanner(System.in);
		do {
			num = sc.nextInt();
			if (num != (Integer)num) {
				System.out.println("정수를 입력해주세요.");
			}
			else
			{
				break;
			}
		}while(true);
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
