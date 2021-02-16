package variable.step1;

public class Account1_1 {
	double kor = 0;
	double eng = 0;
	double math = 0;
	/********************************************************
	 * @param kor2 - 학생의 국어점수
	 * @param math2 - 학생의 수학점수
	 * @param eng2 - 학생의 영어점수
	 * @return tot - 한 학생의 세 과목의 총점을 구하여 담는 변수
	 **********************************************************/
	double hap(double kor2, double eng2, double math2) {
		double tot = 0;
		//insert here
		tot = kor2 + eng2 + math2;
		return tot;
	}
	/*********************************************************
	 * 평균을 구하는 메소드 구현
	 * @param tot - hap메소드를 호출하여 tot를 받아온다.
	 ******************************************************/
	private double avg(double tot) {
		//insert here
		double avg = tot / 3;
		return avg;
	}
	//나는 메소드를 선언할 수 있다. 
	//= 대입 연산자 int i = 2; 
	//메소드 안에 있는 ,는 열거형 연산자라고 한다.
	//. dot연산자 - 주소번지.전역변수()
	//접근제한자(access modifier) - static 수정자 - 리턴타입 - 메소드이름(파라미터1, 파라미터2, ...){리턴값} 
	public static void main(String[] args) {
		Account1_1 ac = new Account1_1();
		ac.kor = 70;
		ac.math = 80;
		ac.eng = 90;
		double tot = ac.hap(ac.kor, ac.eng, ac.math);
		//double test_avg = ac.avg(tot);
		double test_avg2 = ac.avg(tot, 3);
		System.out.println("평균은 " + ac.avg(tot) + " 입니다");
	}
	/************************************************
	 * 값에 의한 호출
	 * @param tot - 총합을 계산한 값
	 * @param subjectNumber - 과목수
	 * @return
	 */
	private double avg(double tot, int subjectNumber) {
		System.out.println("tot ==> " + tot + ", subjectNumber ==> " + subjectNumber);
		double imsi = tot/subjectNumber;
		return imsi;
	}


}

