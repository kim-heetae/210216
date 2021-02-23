package book.ch5;
class A1{
	int ival = 0;
	void piPrint() {
		B1 b1 = new B1();
		double  result = b1.pi;
		System.out.println("result pi : " + result);
	}
}
class B1{
	double pi = 0.0;
	void ivalPrint() {
		A1 a1 = new A1();
		double  result = a1.ival;
		System.out.println("result ival : " + result);
	}
}
public class AnBTest {

	public static void main(String[] args) {
		A1 a1 = new A1();
		a1.piPrint();
		B1 b1 = new B1();
		b1.ivalPrint();
	}

}
