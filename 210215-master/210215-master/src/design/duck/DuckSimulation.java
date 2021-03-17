package design.duck;

public class DuckSimulation {

	public static void main(String[] args) {
		Duck myDuck = new WoodDuck();
		myDuck.display();
		myDuck.performFly();
		myDuck.performQuack();
		Duck herDuck = new RubberDuck();
		herDuck.display();
		herDuck.performFly();
		myDuck.performQuack();
		Duck himDuck = new MalladDuck();
		himDuck.display();
		himDuck.performFly();
		myDuck.performQuack();
	}

}
