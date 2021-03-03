package book.ch4;

public class FizzBuzz {

	public static void main(String[] args) {
		String fizz = "Fizz";
		String buzz = "Buzz";
		for(int i = 1; i <= 100; i++) {
			switch (i % 5) {
			case 0:
				System.out.println(fizz);
				continue;
			}
			
			switch(i % 7) {
			case 0:
				System.out.println(buzz);
				continue;
			}
			
			switch (i % 35) {
			case 0:
				System.out.println(fizz + buzz);
				continue;
			default:
				System.out.println(i);
				break;
			}
		}
	}

}
