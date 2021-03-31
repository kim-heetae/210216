package book.ch8;

public class RectAngle extends Shape{
	int width = 10;
	int height = 4;
	@Override
	void area() {
		double area = 0.0;
		area = width * height;
		System.out.println("사각형 넓이 : " + area);
	}
	@Override
	void fillDraw() {
		// TODO Auto-generated method stub
		
	}
	
}
