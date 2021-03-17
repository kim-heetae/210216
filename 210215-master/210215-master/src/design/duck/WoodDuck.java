package design.duck;

public class WoodDuck extends Duck {
	public WoodDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new MuteQuack();
	}
	@Override
	public void display() {
		System.out.println("나는 나무 오리 입니다.");
	}

}
