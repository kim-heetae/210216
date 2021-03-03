package book.ch5;

public class PrideSimulation {

	public static void main(String[] args) {
		//Pride클래스의 pride생성자가 private상태이기때문에 에러가 뜬다
		// - public상태라면 가능하다.
		Pride myCar	 = new Pride();
		Pride herCar = new Pride(10);
		Pride himCar = new Pride(100,4);
		
		Pride.wheelNum = 10;
		System.out.println(Pride.wheelNum);
		myCar.wheelNum = 50;
		System.out.println(herCar.wheelNum);
		herCar.wheelNum = 100;
		System.out.println(Pride.wheelNum);
		myCar.speed = 10;
		herCar.speed = 50;
		himCar.speed = 100;
		
		System.out.println(myCar.speed);
		System.out.println(herCar.speed);
		System.out.println(himCar.speed);
		
	}

}
