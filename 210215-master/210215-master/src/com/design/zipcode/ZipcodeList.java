package com.design.zipcode;

import java.util.List;
import java.util.Vector;

/*
 * 자료구조의 종류 
 * 1) List계열
 * 		ArrayList - 싱글스레드 안전, 동기화 처리 생략, 속도 빠름
 * 		Vector - 멀티스레드에 안전, 동기화처리 필요, 속도 느림
 *		 :경합, 다중 접속자 처리, 순서, 동기화 처리
 * 2) Map계열(해시태그)
 * 
 * 3) Set계열(사용빈도 낮음) - 집합
 */
public class ZipcodeList {

	public static void main(String[] args) {
		//꺽쇠 : 제네릭이라고 함. 생성부에는 타입없이 다이아몬드 연산자만 붙여도 된다.
		Vector<ZipcodeVO> v = new Vector<>();//다형성을 누릴수 없다
		List<ZipcodeVO> v2 = new Vector<>();//다형성을 누릴수 있다
		ZipcodeVO zcVO = null;
		ZipcodeVO zcVOs[] = null;
		int i = 0;
		while(i < 3) {
//			zcVO.setAddress("서울시"); - nullpointexception
			zcVO = new ZipcodeVO();
			zcVO.setAddress("서울시");
			//VO안에 전역변수인 ADDRESS에 서울시 금천구 가산동을 초기화하였다.
			//41번에서 객체배열의 ADDRESS변수를 출력했을때 모두NULL일것이다? 서울시금천구 가산동일 것이다.
			System.out.println("zcVO주소번지바뀐다." + zcVO.getAddress());
			v.add(zcVO);
			zcVO.setAddress("인천시");
			i++;
		}
		for(int x = 0; x < v.size(); x++) {
			ZipcodeVO zVO = v.get(x);//26번에서 만들어진 VO와는 다른것이다.
			System.out.println(zVO);//다른 주소번지가 출력된다
		}
		zcVOs = new ZipcodeVO[v.size()];//객체배열이 3개 만들어진다.
		System.out.println("배열의 크기는 " + zcVOs.length);//3이 출력됨
		v.copyInto(zcVOs);//벡터에 담긴것을 배열에 담아준다.
		for(int y = 0; y <zcVOs.length; y++) {
			System.out.println(zcVOs[y] + "," + zcVOs[y].getAddress());//객체 배열의 주소번지가 3개 출력된다
		}
	}

}
