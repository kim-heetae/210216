package variable.step1;

public class A {
	//전역변수의 경우 초기화를 생략할 수 있다.
	public double kor = 0;
	double math = 0;
	double eng = 0;
	double kor1;
	double math1;
	double eng1;

	double kor2 = 70;
	double math2 = 80;
	double eng2 = 90;
	
	void methodA() {
		/*
		double kor = 70;
		double eng = 80;
		double math = 90;	
		*/
		kor = 70; 
		math = 80; 		
		eng = 90;		
	}

}
