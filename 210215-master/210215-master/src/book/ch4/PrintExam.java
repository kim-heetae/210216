package book.ch4;
/*
 * java.util에 있는 패키지들은 제공되는 api를 통해서 뭔가를 만들때 유용한 기능들을 모아둔 패키지임
 * java.lang이 아닌 패키지는 모두 import대상이다.
 * 
 */
import java.util.Random;
import java.util.Scanner;

public class PrintExam {

	public static void main(String[] args) {
		//디폴트 생성자를 지원하지 않는 클래스가 존재한다.
		//여기서 system이란 내가 쓰고있는 장치(device) - 처리주체
		//사용자 혹은 업무 담당자가 키보드에 입력한 값을 읽어 오기 위해서는 입력장치를 나타내는 속성이 필요하다. - attribute
		Scanner sc = new Scanner(System.in);//local device - 서버가 아니다. - 동기화는 불가 - 예전의 데이터를 계속 가지고 있다. - 새로 등록된 정보가 없다.
		Scanner sc2 = null;
		sc2 = new Scanner(System.in);
		System.out.println("당신의 나이를 입력하세요");
		System.out.println("====================");
		//System.out.println(sc.nextInt());
		//디폴트 생성자를 제공해줌
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			int dap = r.nextInt(10);
			System.out.println((i + 1) + "번째 수 : " + dap);
		}
		
		
	}

}