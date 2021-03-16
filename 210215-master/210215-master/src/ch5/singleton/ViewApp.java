package ch5.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.View;

public class ViewApp{
	JFrame jf = null;
	JFrame jf2 = new JFrame();
	//인스턴스화를 분리해서 할 수도 있고 한번에 할 수도 있다.
	JButton 	jbtn_send 	= null;
	JButton 	jbtn_exit 	= null;
	JPanel 		jp_north	= null;
	JPanel 		jp_south 	= null;
	JPanel 		jp_east 	= null;
	JPanel 		jp_west 	= null;
	JPanel 		jp_center 	= null;
	JTextField 	jtf_center 	= null;
	
	public ViewApp() {
		initDisplay();
	}
	public void initDisplay() {
		jf = new JFrame();
		jbtn_send = new JButton("전송");
		jbtn_exit = new JButton("닫기");	
		jp_north	= new JPanel();
		jp_south 	= new JPanel();
		jp_east 	= new JPanel();
		jp_west 	= new JPanel();
		jp_center 	= new JPanel();
//		jtf_center 	
//		jf.setSize(500, 300);
//		jf.setVisible(true);
//		jbtn_send.addActionListener(this);
//		jbtn_exit.addActionListener(this);
		jp_north.add(jbtn_send);
		jp_south.add(jbtn_exit);
		jp_center.add(jtf_center);
//		jtf_center.setBounds(0, 0, jp_center.getWidth(), jp_center.getHeight());
		jf.add("North", jp_north);
		jf.add("South", jp_south);
		jf.add("Center", jp_center);
	}
	public static void main(String[] args) {
		ViewApp va = new ViewApp();
		va.initDisplay();
	}

}
