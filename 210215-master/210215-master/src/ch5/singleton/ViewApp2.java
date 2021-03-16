package ch5.singleton;


import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewApp2{
	JFrame jf = new JFrame();
	JFrame jf2 = null;
	JButton jbtn = null;
	//인스턴스화를 분리해서 할 수도 있고 한번에 할 수도 있다.
	
	public void initDisplay() {
		EventHandler2 eh = new EventHandler2(this);
		jf2 = new JFrame();
		jbtn = new JButton("전송");
		jbtn.addActionListener(eh);
		jf2.add("North", jbtn);
		jf2.setSize(300, 200);
		jf2.setVisible(true);
	}
	public static void main(String[] args) {
		ViewApp2 va = new ViewApp2();
		va.initDisplay();
	}

}
