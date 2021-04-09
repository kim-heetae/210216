package thread.main;

class MyRunningTwo implements Runnable{

	@Override
	public void run() {
		System.out.println("run");
		first();
	}
	public void first() {
		System.out.println("first");
		second();
	}
	public void second() {		
		System.out.println("second");
	}
}


public class MainThread1_2 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " start");
		Runnable r1 = new MyRunningTwo();
		Thread th = new Thread(r1);
		th.start();
		try {
			th.sleep(5000);
			th.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " end");
	}

}
