package practice.com;

import java.util.Random;
import java.util.Scanner;

class Gamemain2{//게임이 진행되는 클래스
	Scanner sc = new Scanner(System.in);
	
	public void inputN(int rnum, int num, int chance, int range) {//사용자가 생각하는 정답을 입력하는 메소드
		for(int i = 0; i < chance; i++) {
			System.out.println((i + 1) + "번째 입력입니다");
			System.out.println("1부터" + range + "까지의 수 중에 예상하는 수를 입력해주세요");
			System.out.println("====================");
			num = sc.nextInt();
			if(search(rnum, num, chance, i) == chance){
				break;
			}
		}
	}
	
	public int search(int rnum, int num, int chance, int i) {//사용자의 입력값이 정답인지 오답인지 확인하는 메소드
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
			i = chance;
		}
		return i;
	}
	
}

class GameSetting2{//초기 값들을 정해주는 클래스 (랜덤수의 범위, 답을 입력할 수 있는 횟수)
	Gamemain2 gm = new Gamemain2();
	//RandomGamePrivate1_3 rg3 = new RandomGamePrivate1_3();
	Scanner sc = new Scanner(System.in);
	public int rangeN(int range2) {//초기 정답의 범위를 입력받는 메소드
		System.out.println("랜덤으로 정답을 정할 최대값 정해주세요");
		range2 = sc.nextInt();
		return range2;
	}
	public int chanceN(int chance) {//기회를 입력받는 메소드
		System.out.println("정답을 입력할 기회를 정해주세요");
		chance = sc.nextInt();
		return chance;
	}
	public int rdnum(int rnum, int range) {//랜덤번호를 정하기위한 메소드
		Random r = new Random();
		rnum = r.nextInt(range) + 1;
		return rnum;
	}
}
public class RandomGamePrivate1_4 {//메인 클래스
	
	private int rnum = 0;//랜덤번호
	private int num = 0;//입력받는 번호
	private int range = 0;//초기 정답의 범위
	private int chance = 0;//정답을 입력할 기회
	
	public static void main(String[] args) {
		RandomGamePrivate1_4 rg = new RandomGamePrivate1_4();
		GameSetting2 gs = new GameSetting2();
		Gamemain2 gm = new Gamemain2();
		int i =1 ;
		int j= 0;
		i = gs.rangeN(j);//정답이 정해질 범위를 정해주는 메소드
		rg.chance = gs.chanceN(rg.chance);//기회를 정할 메소드
		rg.rnum = gs.rdnum(rg.rnum, rg.range);//랜덤수를 생성
		gm.inputN(rg.rnum, rg.num, rg.chance, rg.range);//정답 입력
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}
}

