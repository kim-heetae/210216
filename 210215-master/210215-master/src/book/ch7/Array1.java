package book.ch7;
/*
 * 배열은 한번 선언하면 배열의 길이를 조정 불가
 * 끼워넣기 불가
 * 배열의 주소번지.length명사형 - 배열의 길이. "hello".length() - 문자열 길이
 */
public class Array1 {

	public void printArray(int empnos[]) {
		for(int i = 0; i < empnos.length; i++) {
			empnos[i] = (i + 1);
			System.out.println(empnos[i]);
		}
	}
	
	public static void main(String[] args) {
		int empnos[] = new int[14];
		//14개의 방에는 어떤값이 들어있을까요?
		Array1 a1 = new Array1();
		a1.printArray(empnos);
	}

}
