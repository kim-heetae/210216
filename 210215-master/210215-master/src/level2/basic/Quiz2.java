package level2.basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Quiz2 extends JFrame implements ActionListener{
	Quiz2_ChangePanel jp_change = null;
	JPanel jp_main = new JPanel();
	JTextField jtf_mem = new JTextField(10);
	JLabel	jlb_mem = new JLabel("명");
	JButton jbtn_maker = new JButton("만들기");
	
	public void initDisplay() {
		jbtn_maker.addActionListener(this);
		jtf_mem.addActionListener(this);
		this.setLayout(new BorderLayout());
		jp_main.add(jtf_mem);
		jp_main.add(jlb_mem);
		jp_main.add(jbtn_maker);
		this.add("Center", jp_main);
		this.setSize(300, 200);
		this.setVisible(true);
	}
	public Quiz2() {
		initDisplay();
	}
	public static void main(String[] args) {
		new Quiz2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_maker) {
			this.remove(jp_main);
			jp_change = new Quiz2_ChangePanel();
			jp_change.initDisplay();
			this.setSize(1500, 900);
			this.add("Center", jp_change);
			this.repaint();
			this.revalidate();
			
		}
//		if(jtf_mem.hasFocus() == false) {
//			System.out.println(123);
//		}
	}

}
