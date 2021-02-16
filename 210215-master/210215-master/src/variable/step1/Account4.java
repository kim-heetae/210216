package variable.step1;

import java.util.Scanner;

public class Account4 {

	//다른 프로그램에서도 최소한의 수정으로 실행시킬수 있어야 좋은 코드
	
	double score[][];//학생들의 점수
	int studentNum = 0;//학생수       
	int subjectNum = 0;//과목수
	
	//학생수를 입력받는 메소드
	void inputstu(double scoreNum[][]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생수를 입력해주세요.");
		while(true) {
			studentNum = sc.nextInt();
			if(studentNum <= 0) {
				System.out.println("학생수를 확인해주세요");
			}else
			{
				break;
			}
		}
		score = new double[studentNum][subjectNum];
	}
	
	//과목수를 입력받는 메소드
	void inputsub(double scoreNum[][]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("과목수를 입력해주세요.");
		while(true) {
			subjectNum = sc.nextInt();
			if(subjectNum <= 0) {
				System.out.println("과목수를 확인해주세요");
			}else
			{
				break;
			}
		}
		score = new double[studentNum][subjectNum];
	}
	
	//각각의 점수를 입력받는 메소드
	void inputscore(double sbjScore[][]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력해주세요");
		for(int i = 0; i < studentNum; i++) {
			for(int j = 0; j < subjectNum; j++) {
				System.out.println((i + 1) + "번째 학생의 " + (j + 1) + "번째 과목 점수 : ");
				score[i][j] = sc.nextDouble();
			}
		}
	}
	
	//평균을 구하는 메소드
	void avgscore(double scoreAvg[][]) {
		double sum = 0;
		for(int i = 0; i < studentNum; i++) {
			for(int j = 0; j < subjectNum; j++) {
				sum += score[i][j];
			}
			System.out.println((i + 1) + "번째 학생의 평균 : " + sum/subjectNum);
			sum = 0;
		}
	}
	
	public static void main(String[] args) {
		Account4 ac4 = new Account4();
		ac4.inputstu(ac4.score);//학생수를 입력받음
		ac4.inputsub(ac4.score);//과목수를 입력받음
		ac4.inputscore(ac4.score);//각각의 점수를 입력받음
		ac4.avgscore(ac4.score);//각 학생에 대한 평균을 구함
		}

}
