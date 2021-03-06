package practice.com;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame1_1 {//야구게임

	int[] rnum = new int[3];
	int[] num = new int[3];
	int strike = 0;
	int ball = 0;
	int out = 0;
	int chance = 0;
	Scanner sc = new Scanner(System.in);
	void randomN() {//랜덤인 수를 배열에 담는 메소드
		Random r = new Random();
		int i = 0;
		do {
			if(i == 0) {
				rnum[i] = r.nextInt(10);				
			}
			else {
				rnum[i] = r.nextInt(10);				
				for(int j = 0; j < i;){
					if(rnum[i] == rnum[j]) {
						rnum[i] = r.nextInt(10);				
						j = 0;
					}
					else {
						j += 1;
					}
				}
			}
			i++;
		}while(i < rnum.length);
		
	}
	
	void inputA() {
		if(strike == 3) {
			return;
		}
		else {
			System.out.println("정답을 입력해 주세요");
			int unum = sc.nextInt();
			num[0] = unum / 100;
			unum = unum % 100;
			num[1] = unum / 10;
			unum = unum % 10;
			num[2] = unum;
			checkN();
		}
	}
	
	void checkN() {
		strike = 0;
		ball = 0;
		for(int i = 0; i < rnum.length; i++) {
			if(rnum[i] == num[i]) {
				strike += 1;
			}
			if(strike == 3) {
				System.out.println("정답입니다.");
				return;
			}
		}
		for(int i = 0; i < rnum.length; i++) {
			for(int j = 0; j < num.length; j++) {
				if((i != j) && (rnum[i] == num[j])) {
					ball += 1;
				}
			}
		}
		if(strike == 0 && ball == 0) {
			out += 1;
		}
		System.out.println(out + "아웃");
		System.out.println("strike : " + strike + "      /      " + "ball : " + ball );
		if(out < 3) {
			inputA();
		}
		else {
			System.out.println("실패입니다.");
			if(rnum[0] == 0) {
				System.out.println("정답 : 0" + rnum[1] + rnum[2]);				
			}
			else {
			System.out.println("정답 : " + rnum[0] + rnum[1] + rnum[2]);
			}
		}
	}
	public static void main(String[] args) {
		BaseballGame1_1 bg = new BaseballGame1_1();
		bg.randomN();
		bg.inputA();
	}

}
