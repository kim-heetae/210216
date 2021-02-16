package variable.step1;

public class MainMethod {
/**********************************************
 * 
 * @param args - 파라미터의 타입은 배열입니다.
 * String args[] = new String[3];
 * main 메소드는 특별한 경우
 * 학습목표 
 * main메소드에 대해 설명할 수 있다.
 */
	public static void main(String[] args) {
		System.out.println(123);
		//만일 숫자라면 20출력
		//만일 문자라면 20출력
		//int + int = int
		//int + String = 붙여쓰기
		System.out.println(args[0] + 10);
		//타입은? String타입
		//타입을 체크할 수 있는 연산자가 있다. instanceof - 자바는 컴파일할때 타입을 따지기 때문에 필요
		if(args[0] instanceof String) {
			System.out.println("나는 문자열이다.");
		}
		else {
			System.out.println("나는 문자열이 아니다.");
		}
		if(true) {//else를 실행할 경우는 절대 없다
			System.out.println("나는 참입니다.");
		}else {//데드코드(영원히 실행되지 않을 코드)
			System.out.println("너는 거짓입니다.");
		}
		for(int i = 0; i < 100; i++) {
			if(true) {//else를 실행할 경우는 절대 없다
				System.out.println("나는 참입니다.");
			}
		}

	}
}
