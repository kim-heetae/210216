package athread.talk1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
 * 
 */
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class TalkClient extends JFrame implements ActionListener{
	////////////////////////////속지 두 장 추가하기///////////////////////
	JPanel jp_first = new JPanel();
	JPanel jp_second = new JPanel();
	JPanel jp_second_south = new JPanel();
	////////////////////////////통신과 관련된 전역변수 추가/////////////////
	Socket 				socket 		= null;
	//직렬화를 누릴수 있다.
	ObjectOutputStream 	oos			= null;
	ObjectInputStream 	ois			= null;
	//닉네임
	String 				nickname 	= null;
	//화면 구성요소
	JTextArea 	jta_display = new JTextArea();
	JScrollPane jsp_display	= new JScrollPane(jta_display);
	JPanel 		jp_south 	= new JPanel();
	JTextField 	jtf_msg 	= new JTextField(20);
	JButton 	jbtn_send 	= new JButton("전송");
	//소켓 관련 초기화
	public void init() {
		try {
			//소켓 생성하기 - ip, port - 서버측 ServerSocket에 연결됨
			socket = new Socket("192.168.0.30", 5555);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject(100 + " # " + nickname);
//			TalkClientThread tct = new TalkClientThread(this);//임시주석
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public void initDisplay() {
		nickname = JOptionPane.showInputDialog("닉네임을 입력하세요");
		jtf_msg.addActionListener(this);
		jta_display.setEditable(false);
		jp_south.setLayout(new BorderLayout());
		jp_south.add("Center", jtf_msg);
		jp_south.add("East", jbtn_send);
		this.add("Center", jsp_display);
		this.add("South", jp_south);
		this.setTitle(nickname + "님의 창");
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String args[]) {	
		TalkClient tc = new TalkClient();
		tc.initDisplay();
		tc.init();//소켓 처리
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		if(jtf_msg == obj) {
			try {
				oos.writeObject(200 + "#" + nickname + "#" + msg);
				jtf_msg.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
