package book.ch8;

public class Circle extends Shape{
	final static double PI = 3.14;
	int r = 3;
	@Override
	void area() {
		double area = r * r * PI;
		System.out.println("원의 면적은 " + area);
	}
//	@Override
	void area(int r) {
		double area = r * r * PI;
		System.out.println("반지름이 " + r + "일때 " + "원의 면적은 " + area);
	}

	@Override
	void fillDraw() {
		// TODO Auto-generated method stub
		
	}

}
