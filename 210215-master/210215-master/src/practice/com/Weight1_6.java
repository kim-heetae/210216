package practice.com;
/*
 * 에러에는 두가지가 있다. 
 * 하나는 컴파일 타임 에러 - 문법에러
 * 두번째는 런타임 에러 - 실행오류(논리의 오류)
 */
import java.util.Scanner;

public class Weight1_6 {
	
	public static void main(String[] args) {
		double wEarth = 0.0;//지구에서의 몸무게
		System.out.println("지구의 몸무게를 입력하세요");
		Scanner sc = new Scanner(System.in);
		try {
			wEarth = sc.nextDouble();
		}catch(Exception e) {
			System.out.println("Exception : " + e.toString());
		}
		if(sc.hasNextDouble()) {//입력한 값이 더블인가?
			double wMoon = 0.0;//달에서의 몸무게
			Weight1_6 pr1_5 = new Weight1_6();
			Common cm = new Common();
			wMoon = cm.moonWeight(wEarth);
			System.out.println("지구의 몸무게 : " + wEarth + "kg");
			System.out.println("달의 몸무게 : " + wMoon + "kg");
		}
		else {
			System.out.println("실수만 입력 하세요");
			return;//main메소드 탈출 - 26번 아래는 진행할 필요가 없다.
		}
		System.out.println("여기");
	}

}
