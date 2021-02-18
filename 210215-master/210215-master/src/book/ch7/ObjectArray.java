package book.ch7;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ObjectArray {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setLayout(new GridLayout(1, 10));
		JButton jbtns[] = new JButton[10];
		String jbtn_label[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		JButton jbtn = null;
		for(int i = 0; i < jbtns.length; i++) {
			jbtn = new JButton(jbtn_label[i]);
			jf.add(jbtn);
		}
		jf.setTitle("객체 배열 실습");
		jf.setSize(700, 500);
		jf.setVisible(true);
	}

}
