package thread.bakery;

public class BakerSimulation {

	public static void main(String[] args) {
		BakerStack bs = new BakerStack();
		Baker b1 = new Baker(bs);
		b1.start();
		Baker b2 = new Baker(bs);
		b2.start();
		Baker b3 = new Baker(bs);
		b3.start();
		
		Customer c1 = new Customer(bs);
		c1.start();
		Customer c2 = new Customer(bs);
		c2.start();
		Customer c3 = new Customer(bs);
		c3.start();
	}

}
