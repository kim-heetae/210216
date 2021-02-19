package book.ch7;

import com.vo.DeptVO;
//전제조건은 반드시 메소드의 이름이 같을 때만 고려함.
public class MethodOverloading {
	void go() {
		
	}
	//public void go(){} 접근제한자는 영향이 없다
	public void go(int[] a) {} //메소드 오버로딩임. - 파라미터의 갯수가 다르기 때문
	//public void go(int[] b) {} //파라미터의 변수명만 다른것은 메소드오버로딩이 아니다
	public void go(DeptVO dvo) {//메소드 오버로딩을 만족함
		
	}
//	int go() {//리턴타입의 유무는 영향이 없다.
//		return 0;
//	}

	public static void main(String[] args) {
		
	}

}
