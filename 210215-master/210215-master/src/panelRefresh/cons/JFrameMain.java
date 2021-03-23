package panelRefresh.cons;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JFrameMain extends JFrame implements ActionListener{
	JPanel jp = new JPanel();
	JTextArea jta = new JTextArea();
	JButton jbtn = new JButton("화면변경");
	
	public JFrameMain() {
		initDisplay();
	}
	
	public void initDisplay() {
		//x버튼 눌렀을 때 리소스 해체 하기
		jbtn.addActionListener(this);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		jp.setLayout(new BorderLayout());
		jp.add("Center", jta);
		this.add("Center", jp);
		this.add("South", jbtn);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JFrameMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn) {
			//JFrame 아래쪽에 컨테이너 존재
			//붙일때는 생략이 가능했지만 제거할 때는 필요함
			//뷰 계층을 리플래쉬 해야 할 때는 반드시 필요함
			Container cont = this.getContentPane();
			if(jp != null) {
				cont.remove(jp);//속지 제거
				cont.remove(jbtn);//버튼 제거
			}
			JPanel1 jp1 = null;
			jp1 = new JPanel1();
			this.add("Center", jp1);
			cont.revalidate();
		}
	}

}
