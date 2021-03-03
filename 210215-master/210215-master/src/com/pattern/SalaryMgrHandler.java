package com.pattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalaryMgrHandler implements ActionListener {
	SalaryMgrView smView = null;
	public SalaryMgrHandler(SalaryMgrView smView) {
		this.smView = smView;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();//버튼의 주소번지를 출력함
		String command = ae.getActionCommand();//버튼의 라벨값을 출력함
		if(smView.jbtns[4] == obj) {
			System.out.println("종료버튼 이벤트 감지됨.");
			System.exit(0);
		}
		else if ("조회".equals(command)) {
			System.out.println("조회버튼 감지됨");
			smView.smLogic.getEmpDetail(7566);
		}
	}

}
