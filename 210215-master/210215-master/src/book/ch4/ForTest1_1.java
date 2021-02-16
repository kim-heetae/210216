package book.ch4;
//자바언어를 사용해서 코딩을 전개하려면 보안문제로 반드시 package를 정의하도록 권장하고 있다. book.ch4
//default패키지는 불가 - 보안문제 때문
//그 다음 클래스 선언문이 온다. - 형식, 표준
//모든 코딩은 class선언에 좌중괄호와 우중괄호 안에 와야한다. --- 왜? 자바는 기본단위가 class이다.
//콜백메소드 -> 시스템이 호출하는 메소드 -> 개발자는 절대 호출할 수 없다 - 메인메소드 안에 코딩하는 것은 나쁜방법.
//메인메소드를 선언하려면 반드시 클래스선언이 먼저이다. - 처리주체가 JVM이다. - 일꾼은 가상머신
//모든 코딩의 기준은 자바가상머신이 해석할 수 있는 방식으로 코딩이 전개되어야 한다.
//클래스 선언하기는
//접근제한자 class라는 예약어 그리고 클래스명 순서로 선언된다.
//접근제한자 : public, private, protected, friendly(같은 폴더(패키지)에 있는 클래스끼리는 공유가능하다(class A{}))
//클래스 내부는 선언부와 메소드 선언부로 나누어서 코딩을 전개해본다.
//프로그램은 여러 클래스로 나누어 코딩한다. 재사용성, 응집도, 결합도를 위해...
//상속은 재사용성을 해결하는 방법이 아니다. 상속은 결합도가 높기때문에...
import java.util.Scanner;
import book.ch4.ForTest1_1;

public class ForTest1_1 {
	//선언부 - 전역변수. 초기화 생략할 수 있다. 생성자가 있는데 역할이 전역변수의 초기화를 담당한다.
	//지역변수는 선언이 불가. - 지역변수는 메소드 안에서 선언해야 하기때문에...
	//if문이나 for문같은 실행문은 사용이 불가.
	//전역변수는 선언과 초기화를 분리할 수 없다. - 컴파일이 불가 - 실행불가 - 메소드 안에서는 가능
	//선언만 하는것은 가능
	//메소드 안에 메소드 선언은 하지 않는다. - 호출할수 없기 때문에
	//예외를 많이 두지 않는다
	//일관성이 있어야 한다. - 협업이 가능
	//반복되는 코드는 줄여야 한다.
	//이중으로 관리되지 않도록 해야한다.
	int hap = 0;
	///////////////////end of 선언부
	
	//메소드 선언부 - 변수선언부와 구분
	void hapfor(int a) {//접근제한자가 friendly상태 = 같은 폴더(패키지)안에 있는 클래스만 접근가능
		for(int i = 1; i <= a; i++) {
			if(i % 2 == 0) {
				hap += i;
			}
			else {//없어도 가능
				continue;
			}
		}
		System.out.println(hap);
		hap = 0;
	}
	
	void hapwhile(int a) {
		int i = 1;
		while(i <= a) {
			
			if(i % 2 == 0) {
				hap += i;
				i++;
			}
			else {
				i++;
			}
		}
		System.out.println(hap);
		hap = 0;
	}
	
	public static void main(String[] args) {
		ForTest1_1 ft = new ForTest1_1();
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		ft.hapfor(a);
		ft.hapwhile(a);
		int i = 0;
		int hap = 0;
		int even = 0;//짝수의 합
		int odd = 0;//홀수의 합
		int hap2 = 0;

		//1부터 10까지 짝수의 합을 구하시오
		for(i = 1; i <= 10; i++) {
			if(i % 2 ==0) {
				hap += i;
			}
		}
		System.out.println(hap);
		
		//1부터 10까지 홀수의 합과 짝수의 합을 구하시오
		for(i = 1; i <=10; i++) {
			if(i % 2 == 0) {
				even += i;
			}
			else {
				odd += i;
			}
		}
		System.out.println("짝수의 합은  " + even + "입니다.");
		System.out.println("홀수의 합은  " + odd + "입니다.");
		
		//1부터 10까지 합을 구하시오
		for(i = 1; i <= 10; i++) {
			hap2 += i;
			System.out.println( i + "까지의 합은 " + hap2 + "");
		}
	}
	

}
