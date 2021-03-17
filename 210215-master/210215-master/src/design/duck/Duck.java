package design.duck;
/* 추상클래스는 생성자와 일반메소드 추상메소드를 가질 수 있다.
 * 전역변수 선언도 가능
 * 메소드의 경우 일반메소드와 구분하기 위해서 메소드 이름 앞에 abstract를 붙임
 */
public abstract class Duck {
	FlyBehavior flyBehavior = null;
	QuackBehavior quackBehavior = null;
	public Duck() {
		System.out.println("디폴트 생성자 호출 성공");
	}
	public abstract void display();
	public void performFly() {
		flyBehavior.fly();
	}
	public void performQuack() {
		quackBehavior.quack();
	}
	public void swimming() {
		System.out.println("모든 오리는 물에 뜹니다.");
	}
}
