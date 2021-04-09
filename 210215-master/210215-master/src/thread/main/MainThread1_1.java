package thread.main;

class MyRunningOne implements Runnable{

	@Override
	public void run() {
//		System.out.println("run");
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<=100;i++) {
			for(int j=0;j<=100;j++) {
				System.out.print("|");
			}
		}
		System.out.println("*"+Thread.currentThread().getName());
		System.out.println();
//		for(int i=0;i<=10000;i++) {
//			for(int j=0;j<=10000;j++) {
//				if(i==0 && j==0) {
//					System.out.println(0);
//				}
//				if(i==10000 && j == 10000) {
//					System.out.println(j);
//				}
//
//			}
//		}
		first();
	}
	public void first() {
//		System.out.println("first");
		second();
	}
	public void second() {		
//		System.out.println("second");
	}
}


public class MainThread1_1 {

	public static void main(String[] args) {
		System.out.println("main start");
		Runnable r1 = new MyRunningOne();
		Runnable r2 = new MyRunningTwo();
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		th1.start();
		try {
			System.out.println();
			System.out.println("*"+Thread.currentThread().getName());
			Thread.sleep(500);			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		for(int i=0;i<=100;i++) {
			for(int j=0;j<=100;j++) {
				System.out.print("-");
			}
		}
		th2.start();
		for(int i=0;i<=5000;i++) {
			for(int j=0;j<=5000;j++) {
			}
		}
		System.out.println("main end");
	}

}
