package variable.step1;
/*
 * C언어에서는 초기화를 생략하면 쓰레기값을 갖는다
 * 자바언어에서는 각 타입이 갖는 초기값이 정해져 있다.
 * int, long = 0
 * float, double = 0.0f, 0.0(d)
 */
public class ASimulation {

	public static void main(String[] args) {
		A a = new A();
		System.out.println("국어 : " + a.kor);//0
		System.out.println("수학 : " + a.math);//0
		System.out.println("영어 : " + a.eng);//0
		System.out.println("=========================");//0
		System.out.println("국어 : " + a.kor1);//0
		System.out.println("수학 : " + a.math1);//0
		System.out.println("영어 : " + a.eng1);//0
		System.out.println("=========================");//0
		System.out.println("국어 : " + a.kor2);//70
		System.out.println("수학 : " + a.math2);//80
		System.out.println("영어 : " + a.eng2);//90
		A a2 = new A();
		a2.kor2 = 75;
		a2.math2 = 85;
		a2.eng2 = 95;
		System.out.println("=========================");//0
		System.out.println("국어 : " + a2.kor2);//0
		System.out.println("수학 : " + a2.math2);//0
		System.out.println("영어 : " + a2.eng2);//0
		//같은 타입이지만 서로 다른 내용과 메소드의 처리결과를 가질 수 있다.
		//인스턴스화를 할 때마다 복제본이 여러개 생긴다.
		
//		System.out.println("=========메소드 실행========");//0
//		a.methodA();
//		System.out.println("국어 : " + a.kor);//70
//		System.out.println("수학 : " + a.math);//80
//		System.out.println("영어 : " + a.eng);//90
	}

}
