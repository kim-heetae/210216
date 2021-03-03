package book.ch5;
/**********************************************************************************
 * 싱글톤 패턴의 정의
 * 해당 클래스의 인스턴스가 하나만(정적이다) 만들어지고 어디서든지(public) 그 인스턴스에 접근할 수 있도록 하기 위한
 * 패턴이다
 * 클래스 변수 - static이 붙어있는 변수
 * 인스턴스 변수  - 인스턴스화에서 만들어지는 변수 - 값이 여러개
 * 방법1 - 고전적인 싱글톤 패턴 구현법
 * 방법2 - 성능이나 병목현상을 고려하여 구현하기
 * 방법3 - 
 * @author User
 *
 ***********************************************************************************/
public class Pride {
	//클래스변수 - static이 붙은 변수
	static int wheelNum = 0;
	int 		speed = 0;
	public Pride() {
		
	}
	//speed가 들어간 생성자
	public Pride(int speed) {
		this.speed = speed;
	}
	//speed, wheelNum이 들어간 생성자
	public Pride(int speed, int wheelNum) {
		this.speed = speed;
		this.wheelNum = wheelNum;
	}
	void speedUp() {
		speed = speed + 1;
	}
	/*-- 이 경우 문법에러 발생. static타입의 메소드에서 non-static타입의 변수를 사용하기 때문
	static void stop() {
		speed = 0;
	}
	*/
	static void change() {
		wheelNum = 2;
	}
	void changewheel() {
		wheelNum = 3;
	}
}
