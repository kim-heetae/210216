package practice.com;

import java.util.Random;
import java.util.Scanner;

public class RandomGamePrivate1_1 {

	static int rnum;
	static int num;
	int rdnum() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		rnum = r.nextInt(5) + 1;
		return rnum;
	}
	static void inputN() {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i <= 3; i++) {
			if(i < 3) {
				if(num != rnum) {
					System.out.println((i + 1) + "번째 입력입니다");
					System.out.println("예상하는 수를 입력해주세요");
					System.out.println("====================");
					num = sc.nextInt();
				}
				if(num > rnum) {
					System.out.println(num + "보다 작습니다");
					continue;
				}
				else if(num < rnum){
					System.out.println(num + "보다 큽니다");		
					continue;
				}

				else {
					System.out.println("축하합니다");
					break;
				}
			}
			else {
				System.out.println("실패입니다.");
			}
		}
		
		}
	public static void main(String[] args) {
		RandomGamePrivate1_1 pr5 = new RandomGamePrivate1_1();
		pr5.rdnum();
		pr5.inputN();
	}

}
