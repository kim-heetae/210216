package design.duck;

public class squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("삑삑");
	}

}
