package ch5.singleton;


import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewApp1_1{
	JFrame jf = new JFrame();
	JFrame jf2 = null;
	JButton jbtn = new JButton("전송");
	//인스턴스화를 분리해서 할 수도 있고 한번에 할 수도 있다.
	
	public void initDisplay() {
		jf2 = new JFrame();
		EventHandler eh = new EventHandler(this);
		jbtn.addActionListener(eh);
		jf2.add("North", jbtn);
		jf2.setSize(300, 200);
		jf2.setVisible(true);
	}
	public static void main(String[] args) {
		ViewApp1_1 va = new ViewApp1_1();
		va.initDisplay();
	}

}
