package thread.bakery;

public class Customer extends Thread {
	BakerStack bs = null;
	public Customer(BakerStack bs) {
		this.bs = bs;
	}
	public void run() {
		String bread = null;
		bread = bs.pop();
		try {
			System.out.println("잘먹을게요~");
			sleep((int)(Math.random() * 1000));
		} catch (Exception e) {
			System.out.println("Customer run" + e.toString());
		}
	}

}
