package practice.com;

import java.util.Random;
import java.util.Scanner;

public class RandomGamePrivate1_2 {

	int rnum;//랜덤번호
	int num;//입력받는 번호
	int range;//초기 정답의 범위
	int chance;
	boolean ch = true;//정답이면 반복문을 나가기위한 참거짓값
	int rdnum() {//랜덤번호를 정하기위한 메소드
		Random r = new Random();
		rnum = r.nextInt(range) + 1;
		return rnum;
	}
	void rangeN() {//초기 정답의 범위를 입력받는 메소드
		Scanner sc = new Scanner(System.in);
		System.out.println("랜덤으로 정답을 정할 최대값 정해주세요");
		range = sc.nextInt();
	}
	void chanceN() {//기회를 입력받는 메소드
		Scanner sc = new Scanner(System.in);
		System.out.println("정답을 입력할 기회를 정해주세요");
		chance = sc.nextInt();
	}
	void inputN() {//사용자가 생각하는 정답을 입력하는 메소드
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < chance; i++) {
			if(i < 3) {
				System.out.println((i + 1) + "번째 입력입니다");
				System.out.println("1부터 10까지의 수 중에 예상하는 수를 입력해주세요");
				System.out.println("====================");
				num = sc.nextInt();
				search(i);
				if(ch == false) {//정답일경우 반복문 종료
					break;
				}
			}
		}
	}
	void search(int i) {//사용자의 입력값이 정답인지 오답인지 확인하는 메소드
		if(num > rnum) {//입력값이 정답보다 큰경우
			if(i == (chance - 1)) {//마지막 기회를 입력했을경우
				System.out.println("실패입니다");
				System.out.println("정답 : " + rnum);
			}
			else {//기회가 남았을경우
				System.out.println( num + "보다 작은 수입니다.");
			}
		}
		else if(num < rnum) {//입력값이 정답보다 작은경우
			if(i == (chance - 1)) {//마지막 기회를 입력했을경우
				System.out.println("실패입니다");
				System.out.println("정답 : " + rnum);
			}
			else {//기회가 남았을경우
				System.out.println( num + "보다 큰 수입니다.");
			}
		}
		else {//정답일경우
			System.out.println("정답입니다");
			ch = false;//inputN 메소드를 중지하기위해 false로 초기화
		}
	}
	public static void main(String[] args) {
		RandomGamePrivate1_2 pr5 = new RandomGamePrivate1_2();
		pr5.rangeN();//정답이 정해질 범위를 정해주는 메소드
		pr5.chanceN();//기회를 정할 메소드
		pr5.rdnum();//랜덤수를 생성
		pr5.inputN();//정답 입력
	}

}
