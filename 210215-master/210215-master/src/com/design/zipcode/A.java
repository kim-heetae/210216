package com.design.zipcode;

import java.util.ArrayList;

public class A {
/*
 * 컬렉션 프레임워크에서 제공하는 클래스 중에 하나이다.
 * 여기에 담을수 있는 것들은 기본적으로 Object 급이다.
 * 원시형 타입은 담을 수 없다.
 * 
 * 배열과 다른점은?
 * 늘었다 줄었다 가능
 * 객체타입이면 무엇이든 담을 수 있다.
 * 끼워넣기 가능
 * 
 * 
 */
	public static void main(String[] args) {
		ArrayList f1 = new ArrayList();
		f1.add("파인애플");
		f1.add("바나나");
		f1.add("복숭아");
		//타입을 정확히 맞추지 않는 것은 요즘 트렌드에 맞지 않다
		//var i = 10;
		//var j = "안녕"; 타입스크립트
		String my = (String)f1.get(0);
		Object obj = f1.get(2);
		System.out.println(my + obj);
		System.out.println("---------------------------");
		
		ArrayList<String> f2 = new ArrayList<String>();
		f2.add("파인애플");
		f2.add("바나나");
		f2.add("복숭아");
		f2.add(1, "사과");
		for(String str : f2) {
			System.out.println(str);
		}
		String my2 = f2.get(0);
		Object obj2 = f2.get(2);
		System.out.println(my2 + obj2);
		ArrayList<ZipcodeVO> f3 = new ArrayList<>();
		ZipcodeVO zVO = new ZipcodeVO();
		zVO.setZipcode(21356);
		zVO.setAddress("서울시 마포구 공덕동246번지");
		f3.add(zVO);
		zVO = new ZipcodeVO();
		zVO.setZipcode(21357);
		zVO.setAddress("서울시 영등포구 영등포동");
		f3.add(zVO);
		zVO = new ZipcodeVO();
		zVO.setZipcode(21358);
		zVO.setAddress("서울시 구로구 고척동");
		f3.add(zVO);
		for(ZipcodeVO rzVO: f3) {
			System.out.println(rzVO);
		}
		System.out.println("주소번지를 두번 접근한다는게 무슨말이지?");
		for(ZipcodeVO rzVO:f3) {
			String addr = rzVO.getAddress();
			System.out.println(addr);
		}
		
	}

}
