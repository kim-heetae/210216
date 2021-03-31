package level2.basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class B_2 implements ActionListener{
	A_2 a2 = null;
	C_2 c2 = new C_2();
	public B_2(A_2 a2) {
		this.a2 = a2;
		System.out.println("B(A a) 생성자 호출 성공");
	}
	public B_2(C_2 c2) {
		this.c2 = c2;
		System.out.println("C(B b) 생성자 호출 성공");
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {//콜백메소드. 자동호출
		System.out.println("actionPerformed 호출 성공");
		Object obj = ae.getSource();
		obj = ae.getSource().getClass();
		if(a2.jbtn.getClass() == obj) {
			System.out.println("버튼 이벤트 발생");
			String msg = c2.methodA();
			System.out.println("메소드 처리 결과 : " + msg);
		}
	}
}
