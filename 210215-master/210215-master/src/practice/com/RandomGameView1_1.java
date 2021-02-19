package practice.com;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RandomGameView1_1 extends JFrame {
	//선언부
	//속지(중앙)를 생성하는 클래스 인스턴스화
	JPanel jp_center = new JPanel();
	//버튼 4개를 넣을 속지(동쪽)를 생성하는 클래스 인스턴스화
	JPanel jp_east = new JPanel();
	JButton jbtn_new = new JButton("새게임");
	JButton jbtn_dap = new JButton("정답");
	JButton jbtn_clear = new JButton("지우기");
	JButton jbtn_exit = new JButton("나가기");
	JTextArea jta_display = new JTextArea(5,30);
	JTextField jtf_input = new JTextField();

	public RandomGameView1_1() {
		System.out.println("디폴트 생성자 호출성공");
		initDisplay();
		event();
	}
	
	public void initDisplay() {
		jp_east.setLayout(new GridLayout(4,1));//row 4개 컬럼이 1개로 화면을 n개로 나눈다
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit);
		jp_center.setLayout(new BorderLayout());
		jp_center.add("Center", jta_display);
		jp_center.add("South", jtf_input);
		this.add("Center",jp_center);
		this.add("East",jp_east);
		this.setTitle("난수 게임. Ver1.0");
		this.setSize(400, 300);
		this.setVisible(true);
	}
	
	public void event() {
//		jbtn_new.addActionListener(
//				new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						JButton jbtn_new = (JButton)e.getSource();
//						jta_display.setText(jta_display.getText() + "qwe");
//					}
//				}
//		);
			jbtn_new.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton jbtn_new = (JButton)e.getSource();
							GameSetting2 gs = new GameSetting2();
							
							//jta_display.setText();
						}
					}
			);
	}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		RandomGameView1_1 rgview = new RandomGameView1_1();
	}

}
