package thread.main;

public class SynchronizedEx {

	public static void main(String[] args) {
//		Runnable r1 = new ATM();
//		Thread ht = new Thread(r1);
//		Thread ey = new Thread(r1);
		ATM atm = new ATM();
		Thread ey = new Thread(atm, "ey");
		Thread ht = new Thread(atm, "ht");
		ey.start();
		ht.start();
	}

}
