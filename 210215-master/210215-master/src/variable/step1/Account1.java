package variable.step1;

import java.util.Scanner;

public class Account1 {

	double kor;
	double eng;
	double math;
	double[] ad;
	double hap2(double kor, double eng, double math) {
		return kor + eng + math;
	}
	double avg2(double tot) {
		return tot/3;
	}
	public static void main(String[] args) {
		Account1 acc = new Account1();
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수를 입력하세요.");
		acc.kor = sc.nextDouble();
		System.out.println("영어점수를 입력하세요.");
		acc.eng = sc.nextDouble();
		System.out.println("수학점수를 입력하세요.");
		acc.math = sc.nextDouble();
		double tot = acc.hap2(acc.kor, acc.eng, acc.math);
		System.out.println("총점은 " + tot + "입니다.");
		System.out.println("평균은 " + acc.avg2(tot) + "입니다.");
	}

}
