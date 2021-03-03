package com.vo;

public class EmpVOSimulation {

	public static void main(String[] args) {
		DeptVO dVO = new DeptVO();
		dVO.setDeptno(30);
		dVO.setDname("리서치");
		dVO.setLoc("부산");
		EmpVO eVO = new EmpVO(7566, "이순신", "sales"
				, 7800, "2000-10-26"
				, 1000, 200, 30, dVO);
		System.out.println(eVO.getdVO().getDname());
		System.out.println(dVO.getDname());
		dVO = new DeptVO();
		dVO.setDeptno(40);
		dVO.setDname("개발부");
		dVO.setLoc("제주");
		System.out.println(eVO.getdVO().getDname());
		System.out.println(dVO.getDname());
	}

}
