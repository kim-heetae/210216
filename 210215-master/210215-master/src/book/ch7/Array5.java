package book.ch7;

public class Array5 {
	void methodB(boolean isOk[]) {
		System.out.println(isOk.length);
		//System.out.println(isOk[3]);
	}
	/*
	 * 10 - 11 (선언만 - 초기화가 안됨 - 방 크기가 결정되지 않았다. - isOk.length : NullPointerException)
	 */
	public static void main(String[] args) {
		boolean isOk[] = null; //선언만 하였다, 크기가 결정되지 않았다.
		Array5 a5 = new Array5();
		a5.methodB(isOk);
	}

}
/*
 * 변수는 한번에 하나의 값만 담을 수 있다. - 장애
 * 배열은 한번에 여러개의 값을 담을 수 있다. 
 * 그러나 다른 타입은 담을 수 없다[문제제기] - 객체배열,  ArrayList[문제 해결능력] 
 * 끼워넣기가 불가하다 - 크기를 조절할 수 없다 - ArrayList를 사용하면 문제 해결가능
 * 
 * 자료구조 (List계열, Map계열, Set계열) - 크기를 조절할 수 있다. - 끼워넣기 가능 - 회원탈퇴, 사원등록 등등
 * FIFO
 * LIFO
 * LILO........
 * 
 * 세션과 쿠키
 * 
 * 오라클서버 - 영원하다.
 * 
 */