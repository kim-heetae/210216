package variable.step1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class LoginView2 extends JFrame implements ActionListener{//인터페이스이다. 결합도를 낮추는 코드를 작성할 때 필요 - 클래스 설계시 필요
	//java.lang에 있는 패키지가 아니므로 별도의 import필요
	JFrame jf = new JFrame();
	JButton jbtn_login = new JButton("로그인");
	//화면 그리기 구현
	public void initDisplay() {
		jbtn_login.addActionListener(this);
		this.setTitle("네이버 로그인");
		this.add("North", jbtn_login);
		this.setSize(500,400);
		this.setVisible(true);//true이면 화면에 보여짐, false면 비활성화
		//jf.setTitle("Login");
	}
	//내 안에 있는 메소드 이지만 static영역 안에서 non-static을 접근할 수 없으므로 인스턴스화를 통해 해결할 수 있다.
	public static void main(String[] args) {
		LoginView2 view = new LoginView2();
		view.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//로그인 버튼을 눌렀니?
		if(jbtn_login == e.getSource()){//이벤트 감지는 컴터가 하소 버튼의 주소번지는 내가 정의함.
			System.out.println("이순신님 환영합니다.");
		}
	}

}
