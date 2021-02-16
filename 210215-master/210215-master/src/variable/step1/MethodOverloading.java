package variable.step1;

import com.vo.DeptVO;

public class MethodOverloading {
	/*****************************************
	 * 
	 * @param pdvo - 조건절에서 사용될 상수값을 담음. - where에 들어갈 조건 값으로 사용.
	 * @return rdvo - 오라클에서 조회된 결과를 담음. - 화면에 출력용으로 사용
	 *****************************************/
	DeptVO go(DeptVO pdvo) {
		System.out.println(pdvo.getDeptno() + pdvo.getDname() + pdvo.getLoc());
		DeptVO rdvo = null;
		rdvo = new DeptVO();
		//오라클 경유한 다음 조회 결과를 받아온 내용을 담는 클래스
		return rdvo;
	}
	
	//메소드 이름은 같은데 서로 다른 메소드로 인지한다.
	void go() {
		System.out.println("파라미터가 없는 go() 호출성공");
	}
	void go(int i) {//값에 의한 호출. i에는 메소드가 호출할 때 파라미터로 넘어오는 10이 복사됨.
		System.out.println("파라미터가 int인 go(10) 호출성공" + i);//원시형 타입을 부르기 때문에 값이 출력됨. main메소드의 mol.go(10)에서 결정됨.	
	}
	void go(String name) {
		System.out.println("파라미터가 String인 go(Smith) 호출성공");				
	}
	public static void main(String[] args) {
		MethodOverloading mol = new MethodOverloading();
		mol.go();
		mol.go(10);//여기서 결정 - 값에 의한 호출
		mol.go("Smith");//참조형타입(레퍼런스타입)이니까 참조에 의한 호출 - String 만 예외, 호출할 때 주소번지가 아니라 값이 출력 된다는 점에서...
		DeptVO pdvo = new DeptVO();
		pdvo.setDeptno(50);
		pdvo.setDname("개발1팀");
		pdvo.setLoc("제주도");
		mol.go(pdvo);//주소번지를 넘겼다. 참조에 의한 호출 <> 값에 의한 호출
	}

}
