package book.ch4;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RandomGameView1_1 extends JFrame {
	
	public static void main(String[] args) {
		RandomGameView1_1 rgview = new RandomGameView1_1();
		JPanel jp_center = new JPanel();
		JPanel jp_east = new JPanel();
		JButton jbtn_new = new JButton("새게임");
		JButton jbtn_dap = new JButton("정답");
		JButton jbtn_clear = new JButton("지우기");
		JButton jbtn_exit = new JButton("나가기");
		jp_east.setLayout(new GridLayout(4,1));
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit);
		JTextArea jta_display = new JTextArea(5,30);
		JTextField jtf_input = new JTextField();
		jp_center.setLayout(new BorderLayout());
		jp_center.add("Center", jta_display);
		jp_center.add("South", jtf_input);
		rgview.add("Center",jp_center);
		rgview.add("East",jp_east);
		rgview.setTitle("난수 게임. Ver1.0");
		rgview.setSize(400, 300);
		rgview.setVisible(true);

	}

}
