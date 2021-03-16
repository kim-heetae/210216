package thread.basic;

public class ThreadEx15 {
	public static void main(String[] args) {
//		A15 th1 = new A15();
//		B15 th2 = new B15();
		
//		th1.start();
//		th2.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("<<main 종료>>");
		}
	}

}
