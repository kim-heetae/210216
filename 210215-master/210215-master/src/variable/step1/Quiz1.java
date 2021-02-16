package variable.step1;

public class Quiz1 {
	int x = 10;
	//메소드에는 2가지 종류가 있다.
	//JVM에서 제공되는 메소드와 사용자 정의 메소드
	//메소드 선언 순서는 '리턴타입 메소드이름(){ 실행문; }'
	//메소드 선언할 때 리턴타입과 반환타입을 결정할 수 있다. - 코딩을 많이 하여 직접 경험해야 한다.
//	void methodA() {
//		
//	}
//	double methodA(int i) {
//		return i;
//	}
	public static void main(String[] args) {
		Quiz1 q = new Quiz1();
		System.out.println("methodA(int x)호출 성공" + q.x);
		q.methodA();
		q.methodA(5);
	}
	//methodA의 호출이 선언 앞에 오더라도 에러가 아님.
	//왜나하면 자바는 절차지향의 프로그램 언어가 아니기 때문
	//왜냐하면 객체지향 언어이므로 호출순서와는 상관이 없다.
	//자바에서는 같은 이름의 메소드를 중복하여 선언할 수 있다.
	//이것을 가능하게 하는 규칙은 '메소드 오버로딩'이다.
	//'메소드 오버로딩'이란 반드시 파라미터에 타입이 다르거나 파라미터의 갯수가 달라야 한다.
	//주의사항 : '리턴 타입이 있고 없고'는 영향을 주지 않는다.
	private void methodA() {//private으로 하면 해당 클래스에서만 사용할 수 있다. 외부클래스에서는 접근이 불가. 호출 불가. 재사용 불가
		System.out.println("methodA호출 성공");
	}
	//파라미터 x에는 누가 값을 정해주는 걸까요?
	//언제 결정되는 걸까요? q.methodA()에서
	//이클립스에서 컴파일을 실행하는 순간은? 파일을 저장할때
	//소스는 src에 저장되고 컴파일된 소스는 bin에 저장된다
	//배포는 .java는 배포하지 않고 .class만 배포한다. - .java에는 주석이 있기때문에
	private void methodA(int x) {//private으로 하면 해당 클래스에서만 사용할 수 있다. 외부클래스에서는 접근이 불가. 호출 불가. 재사용 불가
		System.out.println("methodA(int x)호출 성공" + x);
	}
	private int methodA(short y) {//private으로 하면 해당 클래스에서만 사용할 수 있다. 외부클래스에서는 접근이 불가. 호출 불가. 재사용 불가
		System.out.println("methodA(int x)호출 성공" + y);
		return 0;
	}

}
