package practice.com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice4_1 {//등비수열 변수사용

	int init = 1;//수열의 초기값은 1
	int num;//입력받는 등비수열의 기준값
	boolean err = true;
	void inputN() {
		Scanner sc = new Scanner(System.in);
		do {//유효성검사
			try {//예외처리
				System.out.println("등비수열을 구할 수를 입력해주세요");
				num = sc.nextInt();
				break;
			}
			catch(InputMismatchException e) {//문자입력시
				err = false;
				sc.nextLine();				
				System.out.println("정수를 입력해주세요");
			}
		}while(!err);
	}
	void sequence() {
		for(int i = 0; i < 7; i++) {
			if(i != 0) {
				init *= num;
			}
			System.out.println(num + "의 등비수열의 " + (i + 1) + "번째 값은 " + init);
		}
	}
	public static void main(String[] args) {
		Practice4_1 pr4_1 = new Practice4_1();
		pr4_1.inputN();
		pr4_1.sequence();
	}

}
