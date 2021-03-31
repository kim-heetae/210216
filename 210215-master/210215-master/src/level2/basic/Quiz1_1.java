package level2.basic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class Quiz1_Display extends JFrame{
	JTextArea jta = null;
	JLabel jlb = null;
	JPanel jp = null;
	Quiz1_1 q1 = null;
	public Quiz1_Display(Quiz1_1 q1) {
		this.q1 = q1;
		initDisplay();
	}
	public void initDisplay() {
		jta = new JTextArea();
		jlb = new JLabel("화면갱신");
		jp = new JPanel();
		q1 = new Quiz1_1(this);
		jp.setLayout(new BorderLayout());
		jp.add("Center", jta);
		jp.add("South", jlb);
		jlb.addMouseListener(q1);
		this.add(jp);
		this.setSize(600, 400);
		this.setVisible(true);
	}
}

public class Quiz1_1 implements MouseListener{
	Quiz1_Display q1d = null;
	
	public Quiz1_1 (){
		q1d = new Quiz1_Display(this);
	}
	public Quiz1_1 (Quiz1_Display q1d){
		this.q1d = q1d;
	}
	public static void main(String[] args) {
		new Quiz1_1();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == q1d.jlb) {
			q1d.jta.append("ㅇㅇ");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
