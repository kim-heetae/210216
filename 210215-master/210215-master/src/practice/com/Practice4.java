package practice.com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice4 {//등비수열 배열사용

	int[] seq = new int[7];//수열을 담을 배열
	int num;//입력받는 등비수열의 기준값
	boolean err = true;
	void inputN() {
		Scanner sc = new Scanner(System.in);
		do {
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
			if(i == 0) {
				seq[i] = 1;//수열의 초기값은 1
			}else {
			seq[i] = num * seq[i-1];
			}
			System.out.println(num + "의 등비수열의" + (i + 1) + "번째의 값은 " + seq[i]);
		}
	}
	public static void main(String[] args) {
		Practice4 pr4 = new Practice4();
		pr4.inputN();
		pr4.sequence();
	}

}
