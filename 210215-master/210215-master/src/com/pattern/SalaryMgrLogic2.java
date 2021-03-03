package com.pattern;

import java.util.Vector;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class SalaryMgrLogic2 {
	SalaryMgrView2 smView = null;
	public SalaryMgrLogic2(SalaryMgrView2 salaryMgrView) {
		this.smView = salaryMgrView;
	}

	public void getEmpDetail(int empno) {
		System.out.println("조회버튼 이벤트 감지됨2");
		EmpVO eVO 	= new EmpVO();//94~98번 중요 - 복습
		eVO.setEname("김유신2");
		DeptVO dVO 	= new DeptVO();
		dVO.setDname("형상관리팀2");
		eVO.setdVO(dVO);//issue
		Vector oneRow = new Vector();
		oneRow.addElement(eVO.getEname());
		oneRow.addElement(eVO.getdVO().getDname());
		smView.dtm_sal.addRow(oneRow);
		}
}

