package variable.step1;

public class Variable {
	//선언부
	
	//메소드 선언
	void methodA(int x) {
		
	}
	double methodB(int x) {
		return 3.14;
	}
	//메인메소드 - exe파일로 만들 수 있다.
	/********************************************************************
	 * 문제해결능력 키움
	 * @return void - 비어있다 - 돌려 받을 수 있는 값이 없다. - 이것 때문에 에러가 발생할 수 있다.
	 * @param args  
	 ********************************************************************/
	public static void main(String[] args) {
		//System : 컴퓨터   /out : 출력장치(모니터, 프린터 등등 HW)/ print():에러 / print(int i), print(double pi), println()등은 가능
		System.out.print(5);//줄바꿈 안됨, 메소드를 호출할수 있는지 == 주소번지.methodA();가능?
		//메소드 선언할 때는 좌중괄호 우중괄호를 사용
		//메소드 호출할 때는 세미콜론으로 끝낸다.
		//API, xxx.jar 등(클래스,객체[결정되지 않았다.] 내부)에 있는 것들을 꺼내 쓰는 개념 
		//print 메소드는 여러개이다.== 같은 이름의 메소드를 여러개 만들수도 있다.
		//SELECT 이름 FROM 회원 집합
		// WHERE 아이디 = 'test'
		//   AND 비번 = '123'
		//System.out.print();//줄바꿈 안됨 / 오류이유 : 파라미터(사용자가 입력한 값)가 없기때문에
		Variable v = new Variable();
		System.out.print(v.methodB(1));
		//System.out.print(v.methodA(1));
		System.out.print(1 + "" + 1);//줄바꿈 안됨
		System.out.print(10 + 10);//줄바꿈 안됨
		System.out.print(10 + "10");//줄바꿈 안됨
		System.out.print(10 + "" + 10);//줄바꿈 안됨
		System.out.print("");//줄바꿈 안됨
		System.out.println();//줄바꿈
		
	}

}
