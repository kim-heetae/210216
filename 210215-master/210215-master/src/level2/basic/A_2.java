package level2.basic;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_2 extends JFrame {
	JButton jbtn = null;
//	JButton jbtn = new JButton("전송");
	boolean isView = false;
//	B_2 b2 = new B_2(this);
	B_2 b2 = null;//타입만 경정되었으므로 시점에 따라 NullPointerException방지 해야함.
//	C_2 c2 = new C_2();//A가 컴파일 될때 같이 메모리에 상주한다.
	
	public A_2() {
//		jbtn = new JButton("전송");
		initDisplay();
	}
	public A_2(boolean isView) {
//		jbtn = new JButton("전송");
		this.isView = isView;
		jbtn = new JButton("전송");
		initDisplay();
		jbtn.setText("전송2");
	}
	public void initDisplay() {
		b2 = new B_2(this);
		jbtn.addActionListener(b2);
//		jbtn.addActionListener(b2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add("Center", jbtn);
		this.setSize(500, 400);//상수로 처리
		this.setVisible(isView);
	}
	public static void main(String[] args) {
		new A_2(true);
	}
}
