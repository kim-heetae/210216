package practice.com;

import java.util.Random;
import java.util.Scanner;

//class GameNum{//정답을 정해주고 사용자의 답을 입력받는 클래스
//	RandomGamePrivate1_3 rg = new RandomGamePrivate1_3();
//	Gamemain gm = new Gamemain();
////	GameSelect gs = new GameSelect();
//	
//}

class Gamemain{//게임이 진행되는 클래스
	RandomGamePrivate1_3 rg = new RandomGamePrivate1_3();
	//GameNum gn = new GameNum();
//	GameSelect gs = new GameSelect();
	
	boolean search(int rnum, int num, int range, int chance, boolean ch, int i) {//사용자의 입력값이 정답인지 오답인지 확인하는 메소드
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
			ch = true;//inputN 메소드를 중지하기위해 false로 초기화
		}
		return ch = true;
	}
	
}

class GameSelect{//초기 값들을 정해주는 클래스 (랜덤수의 범위, 답을 입력할 수 있는 횟수)
	RandomGamePrivate1_3 rg = new RandomGamePrivate1_3();
//	GameNum gn = new GameNum();
	Gamemain gm = new Gamemain();
	int rdnum(int rnum, int num, int range, int chance, boolean ch) {//랜덤번호를 정하기위한 메소드
		Random r = new Random();
		rnum = r.nextInt(range) + 1;
		inputN(rnum, num, range, chance, ch);//정답 입력
		return rnum;
	}
	int rangeN(int rnum, int num, int range, int chance, boolean ch) {//초기 정답의 범위를 입력받는 메소드
		Scanner sc = new Scanner(System.in);
		System.out.println("랜덤으로 정답을 정할 최대값 정해주세요");
		range = sc.nextInt();
		chanceN(rnum, num, range, chance, ch);//기회를 정할 메소드
		return range;
	}
	int chanceN(int rnum, int num, int range, int chance, boolean ch) {//기회를 입력받는 메소드
		Scanner sc = new Scanner(System.in);
		System.out.println("정답을 입력할 기회를 정해주세요");
		chance = sc.nextInt();
		rdnum(rnum, num, range, chance, ch);//랜덤수를 생성
		return chance;
	}
	void inputN(int rnum, int num, int range, int chance, boolean ch) {//사용자가 생각하는 정답을 입력하는 메소드
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < chance; i++) {
			if(i < chance) {
				System.out.println((i + 1) + "번째 입력입니다");
				System.out.println("1부터 10까지의 수 중에 예상하는 수를 입력해주세요");
				System.out.println("====================");
				num = sc.nextInt();
				gm.search(rnum, num, range, chance, ch, i);
				if(ch == true) {//정답일경우 반복문 종료
					break;
				}
			}
		}
	}
}
public class RandomGamePrivate1_3 {
	//메인 클래스
	int rnum;//랜덤번호
	int num;//입력받는 번호
	int range;//초기 정답의 범위
	int chance;
	boolean ch;//정답이면 반복문을 나가기위한 참거짓값
	
	public static void main(String[] args) {
		RandomGamePrivate1_3 rg3 = new RandomGamePrivate1_3();
		//GameNum gn = new GameNum();
		Gamemain gm = new Gamemain();
		GameSelect gs = new GameSelect();
		gs.rangeN(rg3.rnum, rg3.num, rg3.range, rg3.chance, rg3.ch);//정답이 정해질 범위를 정해주는 메소드
		
		
		
	}
}

