package book.ch7;
/*
 * 배열과 메소드 오버로딩 확인
 * 메소드 오버로딩 규칙
 * 1. 반드시 파라미터의 갯수가 달라야 한다.
 * 2. 반드시 파라미터에 타입이 달라야한다.
 * 
 * 주의사항
 * 1. 리턴 타입이 있고 없고는 영향이 없다
 * 2. 접근제한자의 유무 또는 서로 다른것은 영향이 없다
 * (public > protected[패키지가 다르더라도 상속관계에 있다면 접근가능] > friendly[같은 패키지 안에서만 접근가능] > private)
 */
public class Array4 {
	double ds[], d2;
	double[] d3, d4;
	void methodA() {
		ds = new double[3];
		d2 = 3.14;
		d3 = new double[2];
		//d4 = 3.14;
		d4 = new double[5];
	}
	public static void main(String[] args) {
		Array4 a4 = new Array4();
		a4.methodA();
	}

}
