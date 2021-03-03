package book.ch5;

public class DogSimulation {

	public static void main(String[] args) {
		Collie 		myDog 	= new Collie();
		Shepherd 	herDog 	= new Shepherd();
		if(myDog instanceof Collie) {
			System.out.println("Collie");
		}
		if (herDog instanceof Shepherd) {
			System.out.println("Shepherd");
		}
	}

}
