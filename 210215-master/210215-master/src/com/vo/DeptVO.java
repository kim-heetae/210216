package com.vo;
//오라클과 자바를 연결

//VO패턴 - 데이터의 영속성을 유지해주는 오라클 서버 제품과 연결하기
//Data관리 목적 - 모든 집합의 이름 뒤에 접미어로 VO 붙임.
//메인 메소드는 필요가 없다. 단독으로 실행하지 않는다.
/*
 * Number(2) - 정수형. 담을수 있는 최대 크기는 99까지 이다 .(오라클에서) - 임계값 
 * 			- (자바에서) : int(4byte), long(8byte)
 * 
 *  varchar2(4000byte) - String
 *  VO패턴을 사용하면 한꺼번에 3가지 종류[부서번호, 부서이름, 지역]의 값을 관리가 가능.
 *  서버 자체는 항상 동시에 여러사람이 접속할 수 있다.
 *  이 여러 사람을 따로 관리할 수 있어야 한다. - Thread공부 - 직접 서버를 운영할 수 있는 코딩을 보여줌
 *  인스턴스화를 하는 이유
 *  DeptVO dvo = new DeptVO();
 *  
 *  dvo = new DeptVO();
 *  
 *  dvo = new DeptVO();
 *  이게 가능한 코드인가?
 *  이떻게 다른건가?
 *  어떤 방법이 더 좋은걸까?
 *  언제 저렇게 사용해야 할까?
 *  
 */
public class DeptVO {
	private int 	deptno 	= 0;//원시형 타입 - 부르면 값이 나온다. 4byte이니까 0, 4, 8, 12번지... 이런식을 증가.
	private String 	dname 	= null;//레퍼런스 타입 - 클래스 급 - 값이 아닌 주소번지가 나온다.
	private String 	loc		= null;
	private EmpVO	eVO		= null;
	//getter메소드 - Read
	public int getDeptno() {
		return deptno;
	}
	//setter 메소드 - Write, Save 느낌으로 접근하기
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {//지변
		this.dname = dname;//this. 이 붙으면 전변으로 변한다
		//this는 나 자신을 가리키는 수정자이다. 여기서는 지변과 식별을 위해 사용하였다, 생략 가능 ,생략하면 헷갈리기 때문에 적는것이 좋다
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
//	public DeptVO(int dno, String dnm, String dloc) {
//		this.deptno = dno;
//		this.dname = dnm;
//		this.loc = dloc;
//	}

}
