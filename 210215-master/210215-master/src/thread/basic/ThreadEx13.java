package thread.basic;
class A extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 300 ; i++) {
			System.out.print("-");
		}
		System.out.println("[[[ A 스레드 run ]]]");
	}
}

//class B extends Thread{
class B implements Runnable{
	@Override
	public void run() {
		for(int i = 0; i < 300 ; i++) {
			System.out.print("|");
		}
		System.out.println("[[[ B 스레드 run ]]]");
	}
}
class ThreadEx13 {
	static long startTime = 0;
	/*
	 * 29[main thread 시작] - 30[2:스레드 로딩 - ready - go -> 32[대기중 - Runnable상태]] - 31 - 32[A run call] - 33[B run call] 
	 * 4 - 5 - 6(------||||||||---||....)
	 * 14 - 15 - 16(|||||||||||||--------||||-------------||||.....)
	 42*/
	public static void main(String[] args) {
		A th1 = new A();
		B th = new B();
		Thread th2 = new Thread(th);
		th1.start();//콜백메소드인 run을 호출
		th2.start();//콜백메소드인 run을 호출
		//시간을 계산함
		startTime = System.currentTimeMillis();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {}
		
		System.out.println("소요시간 : " + (System.currentTimeMillis() - ThreadEx13.startTime));
			
	}

}
