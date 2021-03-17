package design.duck;

public class MalladDuck extends Duck {
	public MalladDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
	@Override
	public void display() {
		System.out.println("나는 청둥 오리 입니다.");
	}

}
