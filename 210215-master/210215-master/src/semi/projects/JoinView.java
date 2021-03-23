package semi.projects;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinView extends JFrame{

	//선언부
	JTextField 		jtf_id 			= new JTextField();
	JPasswordField 	jtf_pw 			= new JPasswordField();
	JPasswordField 	jtf_pw_confirm 	= new JPasswordField();
	JTextField 		jtf_name		= new JTextField();
	JButton			jbtn_check		= new JButton("중복확인");
	JButton			jbtn_join		= new JButton("회원가입");
	JButton			jbtn_back		= new JButton("뒤로가기");
	JLabel			jlb_id			= new JLabel("ID");
	JLabel			jlb_pw			= new JLabel("PW");
	JLabel			jlb_pw_confirm	= new JLabel("PW Confirm");
	JLabel			jlb_name		= new JLabel("이름");
	JLabel			jlb_birth		= new JLabel("생년월일");
	JCheckBox		jcb				= new JCheckBox("멤버십 가입");
	JLabel			jlb_text		= new JLabel("멤버십에 가입하시면 적립과 할인 혜택을 받을 수 있습니다.");
	
	//생성자
	public JoinView() {
		initDisplay();
	}
	
	//화면처리부
	public void initDisplay() {
		jlb_id			.setBounds(100, 80, 50, 50);
//		jlb_pw			.setBounds(x, y, width, height);
//		jlb_pw_confirm	.setBounds(x, y, width, height);
//		jlb_name		.setBounds(x, y, width, height);
//		jlb_birth		.setBounds(x, y, width, height);
//		jtf_id 			.setBounds(x, y, width, height);
//		jtf_pw 			.setBounds(x, y, width, height);
//		jtf_pw_confirm 	.setBounds(x, y, width, height);
//		jtf_name		.setBounds(x, y, width, height);
//		jbtn_check		.setBounds(x, y, width, height);
//		jbtn_join		.setBounds(x, y, width, height);
//		jbtn_back		.setBounds(x, y, width, height);
//		jcb				.setBounds(x, y, width, height);
//		jlb_text		.setBounds(x, y, width, height);
		this.add(jlb_id);
		this.setSize(600, 400);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new JoinView();
	}

}
