package practice.com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThreeMulti1_1 {//3의 배수 구하기

	int lownum;//첫번째 입력값
	int highnum;//두번째 입력값
	int ch;//두개의 정수중 작은 수를 lownum에 넣기위해 lownum와 highnum의 값을 바꿔주기 위한 변수
	boolean err = true;
	void Multi3() {
		if(lownum > highnum) {//만약 첫번째 입력한 수가 더 크다면 highnum랑 값을 바꾸는 코드
			ch = lownum;
			lownum = highnum;
			highnum = ch;
		}
		for(int i = lownum; i <= highnum; i++ ) {
			if(i % 3 == 0) {
				System.out.println(i);
			}
		}
	}
	void inputN() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("첫번째 값을 입력해주세요");
				lownum = sc.nextInt();
				System.out.println("두번째 값을 입력해주세요");
				highnum = sc.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				err = false;
				sc.nextLine();
				System.out.println("정수만 입력해 주세요");
			}
		}while(!err);
	}
	public static void main(String[] args) {
		ThreeMulti1_1 pr = new ThreeMulti1_1();
		pr.inputN();
		pr.Multi3();
	}

}
