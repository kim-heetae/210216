package com.ocjp;
class Param{
	int ival;
}
public class ParamTest {
	void effectParam(Param p) {
		p = new Param();//14번 라인의 p와 다른 주소번지를 가지는 p를 하나더 만듬
		p.ival = 500;// 7번라인의 p에 존재하는 ival에 500을 저장 - 14번 라인의 p에 존재하는 p와 다른 p이고 14번 라인의 p에는 아직 100이 저장되어 있음
		System.out.println(p.ival);//8번라인의 p.ival을 출력 - 500출력, 메소드가 종료되어 17번으로 이동
	}
	public static void main(String[] args) {
	
		ParamTest pt = new ParamTest();
		Param p = new Param(); //Parma 클래스를 p로 선언
		p.ival = 100;		// 14번 라인의 p.ival에 100을 저장
		pt.effectParam(p); // ParamTest 메소드 실행(14번에서 만든  p의 주소번지를 파라미터로 사용)
		System.out.println(p.ival);//14번에서 만든 p에 15번에서 100을 저장했기 때문에 100이 출력
	}
}
