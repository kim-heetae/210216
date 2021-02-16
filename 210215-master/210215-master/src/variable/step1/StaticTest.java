package variable.step1;

public class StaticTest {
	/*
	 * non-static타입은 static연역에서 접근 불가, 호출불가, 사용불가
	 */
	static void avg(String a) {//사용자 정의 메소드
		int x = Integer.parseInt(a);
		System.out.println("avg호출 성공 " + (x + 10));
	}
	public static void main(String[] args) {
		//if(args[0] == null | args.length == 0){
		if(args.length == 0){
			//아래 문장은 조건에 따라 한 번도 실행 기회를 못가질 수도 있다.
			System.out.println("입력하세요");
			return;
		}
		System.out.println(args[0] + 10);//20이 출력되도록 수정하시오
		int imsi = Integer.parseInt(args[0]);
		System.out.println(imsi + 10);
		System.out.println("========>" + imsi + 10);
		// 메소드 이름 앞에 static이 있다면 주소번지 없이도 호출할 수 있는 메소드가 있다.
		//main메소드는 자바가 제공하는 메소드입니다.
		//사용자 정의 메소드도 가능하다
		//문자열을 집어넣으면(파라미터로) int타입으로 변환하여서 반환해주는 메소드가 필요
		//parseInt()
		//네이버, 구글링 요구사항 만족시키는 코드를 작성하라
		StaticTest.avg(args[0]);
	}

}
