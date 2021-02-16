package variable.step1;

import java.util.Scanner;

public class Account2 {
	
	String[] name = new String[10];
	double[] kor = new double[10];
	double[] eng = new double[10];
	double[] math = new double[10];
	
	double avg(double kor, double eng, double math) {
		return (kor + eng + math)/3;
	}
	
	public static void main(String[] args) {
		Account2 ac2 = new Account2();
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력해주세요");
		for(int i = 0; i < 10; i++) {
			System.out.println("학생이름 : ");
			ac2.name[i] = sc.next();
			System.out.println("국어점수 : ");
			ac2.kor[i] = sc.nextDouble();
			System.out.println("영어점수 : ");
			ac2.eng[i] = sc.nextDouble();
			System.out.println("수학점수 : ");
			ac2.math[i] = sc.nextDouble();
		}
		for(int j = 0; j < 10; j++) {
			System.out.println("이름 : " + ac2.name[j]);
			System.out.println("점수 : " + ac2.avg(ac2.kor[j], ac2.eng[j], ac2.math[j]));
		}
		
	}

}
