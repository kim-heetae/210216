package ch5.singleton;

public class Sonata {
	private static Sonata myCar= null;
	int speed = 0;
	public void stop() {
		System.out.println("stop호출");
		speed -= 1;
	}
	private Sonata() {
		
	}
	public static synchronized Object getInstance(){
		if(myCar == null){
			myCar = new Sonata();
		}
		return myCar;
	}

}
