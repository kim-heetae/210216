package book.ch8;

public abstract class Shape {
	String color = "red";
	void draw() {
		System.out.printf("[color=%s]%n",color);
	}
	abstract void area();
//	abstract void fillDraw2() {
//		
//	}
	abstract void fillDraw();
}