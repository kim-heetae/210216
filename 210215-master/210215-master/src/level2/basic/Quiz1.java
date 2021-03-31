package level2.basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//JLabel 은 ActionListener를 지원받지 못함.
class Quiz1_panel extends JPanel{
	JButton jbtn = new JButton("변경된 버튼");
	public void initDisplay() {
		this.add("Center", jbtn);
	}
}
public class Quiz1 extends JFrame implements ActionListener{
	JPanel jp = new JPanel();
	JButton jbtn = new JButton();
	JTextArea jta = new JTextArea();
	Quiz1_panel qp = null;
	public Quiz1() {
		initDisplay();
	}
	public void initDisplay() {
		jp.add("South", jbtn);
		jp.add("Center", jta);
		jbtn.addActionListener(this);
		this.add(jp);
		this.setSize(600, 400);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Quiz1();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == jbtn) {
			this.remove(jp);
			this.validate();
			this.add(qp);
		}
	}

}
