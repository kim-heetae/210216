package com.pattern;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import book.ch5.SalaryMgr;


/*
 * 클래스 쪼개기를 하면서 생성자에 대한 활용능력을 키워본다.
 * static을 사용하는 것은 생성자에 대한 공부가 안된다.
 * 뷰 계층 - 업무처리계층 - 이벤트 처리 핸들러
 * 
 * 누가 누구를 인스턴스화 해야하는가?
 * :A안에B를 인스턴스화? 아님 반대로?
 * 생성자에 파라미터 자리에는 무엇을 써야 할까? - 생성자 오버로딩에 대해서는 알고있나?
 * SalaryMgrView - this
 * SalaryMgrHandler
 * SalaryMgrLogic
 * 한개만, 두개만, 세개 다 원하는지
 * 세 개의 클래스를 그림으로 표시한 뒤 화살표를 통해서 객체 주입관계를 완성하시오
 */
public class SalaryMgrView2 {
	//선언부
		SalaryMgrHandler2 	smEvent 		= null;
		SalaryMgrLogic2 	smLogic 		= null;
		JFrame 				jf_sal 			= null;
		//DefaultTableModel(DataSet역할 : data[][], header[]) + JTable => 테이블
		String 				cols[] 			= {"사원명", "부서명"};
		String 				data[][] 		= new String[0][2];
		JTable 				jtb_sal 		= null;//화면, 양식, 폼을 그린다
		DefaultTableModel 	dtm_sal 		= null;
		JScrollPane 		jsp_sal			= null;
		JTableHeader		jth_sal 		= null;
		JButton				jbtns[] 		= null;
		JButton				jbtn	 		= null;
		String 				jbtns_label[] 	= {"조회", "입력", "수정", "삭제", "종료"};
		JPanel				jp_north		= null;
	//생성자
	public SalaryMgrView2() {
		smEvent = new SalaryMgrHandler2(this);
		smLogic = new SalaryMgrLogic2(this);
	    jf_sal  = new JFrame();
	    dtm_sal = new DefaultTableModel(data,cols);
	    jtb_sal = new JTable(dtm_sal);
	    jsp_sal = new JScrollPane(jtb_sal);
	    jth_sal = jtb_sal.getTableHeader();
	    jp_north = new JPanel();
	    jp_north.setLayout(new GridLayout(1,4,3,3));
	    jbtns = new JButton[jbtns_label.length];
	    for(int i=0;i<jbtns_label.length;i++) {
	       jbtn = new JButton(jbtns_label[i]);
	       jbtns[i] = jbtn;
	       jp_north.add(jbtn);
	       jbtns[i].addActionListener(smEvent);
	    }
	    initDisplay();
	   }   
	   //화면처리부
	   public void initDisplay() {
	      System.out.println("initDisplay호출 성공");
	      jth_sal.setBackground(Color.GREEN);//API활용 능력 키워준다.
	      //컬럼의 순서 바뀌지 않도록 설정하기
	      //jth_sal.setReorderingAllowed(false);
	      jf_sal.add("North",jp_north);
	      jf_sal.add("Center",jsp_sal);
	      jf_sal.setTitle("급여 명세서");
	      jf_sal.setSize(400,300);
	      jf_sal.setVisible(true);
	   }
	   //main
	   public static void main(String[] args) {
	      new SalaryMgrView2();
	   }   
}
