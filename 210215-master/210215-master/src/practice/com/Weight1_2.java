package practice.com;

import java.util.Scanner;

public class Weight1_2 {

	public static void main(String[] args) {
		double wEarth = 0.0;//지구에서의 몸무게
		double wMoon = 0.0;//달에서의 몸무게
		Scanner sc = new Scanner(System.in);
		System.out.println("지구의 몸무게를 입력하세요");
		wEarth = sc.nextDouble();
		wMoon = (wEarth * 17) / 100;//(double * int)/int = double 
		System.out.println("지구의 몸무게 : " + wEarth + "kg");
		System.out.println("달의 몸무게 : " + wMoon + "kg");
	}

}
