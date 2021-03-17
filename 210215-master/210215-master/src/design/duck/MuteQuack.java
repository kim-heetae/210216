package design.duck;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("울지못해요");
	}

}
