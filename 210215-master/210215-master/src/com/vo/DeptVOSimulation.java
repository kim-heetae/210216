package com.vo;

import java.util.Scanner;

public class DeptVOSimulation {
	
	void methodB() {//반환값이 전혀 역할을 못함
		
	}
	DeptVO methodA() {//반환값이 3가지가 가능
		return new DeptVO();
	}
	DeptVO[] methodC() {//반환값이 3가지 종류에 대해서 N개 로우까지도 가능
		return new DeptVO[3];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DeptVO dvo = new DeptVO();
		int myDeptNo = dvo.getDeptno();//0출력
		String myDname = dvo.getDname();
		String myDloc = dvo.getLoc();
//		String myDString = dvo.getDname();//null출력
//		String myLoc = dvo.getLoc();//null출력
		int dnum = sc.nextInt();
		String dname = sc.next();
		String dloc = sc.next();
		dvo.setDeptno(dnum);
		dvo.setDname(dname);
		dvo.setLoc(dloc);
		myDeptNo = dvo.getDeptno();
		myDname = dvo.getDname();
		myDloc = dvo.getLoc();
		System.out.println("부서번호 : " + myDeptNo + myDname + myDloc);//deptno, myDeptNo사용가능
	}

}
