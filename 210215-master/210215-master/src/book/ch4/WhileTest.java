package book.ch4;

public class WhileTest {

	public static void main(String[] args) {
		//파라미터 자리에 true같은 상수를 사용하지 않기
		while(true) {//항상 무한루프 방지 코드를 작성할 것
			break;
		}
		boolean isStop = false;
		while(!isStop) {//권장사항 - true로 쓰는것보다 안전
			
		}
		while(true) {
			break;
		}
		int i = 5;
	}

}
