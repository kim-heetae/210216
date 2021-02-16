package variable.step1;

public class Account {
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
	
	public static void main(String[] args) {
		Account ac = new Account();
		ac.kor = 85;
		ac.math = 80;
		ac.eng = 90;
		double tot = ac.hap(ac.kor, ac.eng, ac.math);
		double test_avg = ac.avg(tot);
		System.out.println("평균은 " + ac.avg(tot) + " 입니다");
	}


}

