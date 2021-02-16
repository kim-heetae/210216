package variable.step1;

import java.util.Scanner;

public class Account3 {
	
	double score[];
	
	double avg(double score[]) {
		double sum = 0;
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		return sum/score.length;
	}
	
	
	public static void main(String[] args) {
		Account3 ac3 = new Account3();
		Scanner sc = new Scanner(System.in);
		System.out.println("총과목수를 입력해주세요.");
		int subjectNum = sc.nextInt();
		ac3.score = new double[subjectNum];
		System.out.println("점수를 입력해주세요");
		for(int i = 0; i < ac3.score.length; i++) {
			System.out.println((i + 1) + "번째 과목 점수 : ");
			ac3.score[i] = sc.nextDouble();
		}
			System.out.println("평균 : " + ac3.avg(ac3.score));
		}

}
