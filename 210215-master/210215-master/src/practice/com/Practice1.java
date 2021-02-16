package practice.com;

import java.util.Scanner;

public class Practice1 {
	double weight;
	
	double moon(double w) {
		weight = w * 0.19;
		System.out.println("달에서의 몸무게는 " + weight + "kg 입니다.");
		return weight;
	}
	
	void inputw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몸무게를 입력해주세요.");
		weight = sc.nextDouble();
	}
	public static void main(String[] args) {
		Practice1 pr = new Practice1();
		pr.inputw();
		pr.moon(pr.weight);
	}

}
