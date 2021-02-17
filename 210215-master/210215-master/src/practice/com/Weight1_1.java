package practice.com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Weight1_1 {
	boolean err = true;
	double weight;
	
	double moon(double w) {
		weight = w * 0.17;
		System.out.println("달에서의 몸무게는 " + weight + "kg 입니다.");
		return weight;
	}
	
	void inputw() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("몸무게를 입력해주세요.");
				weight = sc.nextDouble();
				break;
			}
			catch(InputMismatchException e) {
				err = false;
				sc.nextLine();
				System.out.println("숫자를 입력해주세요");
			}
		}while(!err);
	}
	public static void main(String[] args) {
		Weight1_1 pr = new Weight1_1();
		pr.inputw();
		pr.moon(pr.weight);
	}

}
