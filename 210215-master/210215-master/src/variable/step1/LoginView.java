package variable.step1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginView extends Object implements ActionListener{//인터페이스이다. 결합도를 낮추는 코드를 작성할 때 필요 - 클래스 설계시 필요
	//java.lang에 있는 패키지가 아니므로 별도의 import필요
	JFrame jf = new JFrame();
	JButton jbtn_login = new JButton("로그인");
	//JTextArea jt = new JTextArea();
	//화면 그리기 구현
	public void initDisplay() {
		jbtn_login.addActionListener(this);
		jf.add("North", jbtn_login);
		//jf.add("South", jt);
		jf.setSize(500,400);
		jf.setVisible(true);//true이면 화면에 보여짐, false면 비활성화
		//jf.setTitle("Login");
	}
	//내 안에 있는 메소드 이지만 static영역 안에서 non-static을 접근할 수 없으므로 인스턴스화를 통해 해결할 수 있다.
	public static void main(String[] args) {
		LoginView view = new LoginView();
		view.initDisplay();
	}
	//같은 이름의 메소드를 여러개 정의할 수 잇다. 
	// - 뒷받침하는 개념이 메소드 오버로딩(파라미터의 타입이 다르거나 갯수가 달라야 한다), 오버라이딩(메소드 이름이 같고 서로 상속관계일때)이다.
//	@Override//어노테이션이다. 이 코드가 없으면 사용자 정의 메소드로 변한다.
	public void actionPerformed(ActionEvent e) {//콜백메소드 라고 함. 내가 호출하는 메소드가 아니라 이벤트 감지가 일어나면 자동 호출됨.
		//로그인 버튼을 눌렀니?
		if(jbtn_login == e.getSource()){//이벤트 감지는 컴터가 하고 버튼의 주소번지는 내가 정의함.
			System.out.println("이순신님 환영합니다.");
		}
	}

}
