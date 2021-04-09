package com.network4;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;


public class TalkClientVer2 extends JFrame {
	LoginForm loginForm = null;
	JTabbedPane tp = new JTabbedPane();
	MessageRoom  mr = new MessageRoom(this);
	WaitRoom     wr = new WaitRoom(this);
	Socket mySocket = null;
	ObjectInputStream ois  = null;
	ObjectOutputStream oos = null;		
	String ip = "127.0.0.1";
	int port = 3002;
	String nickName = null;
	public TalkClientVer2() {
/*	  try {
	    jbInit();
	    connect_process();
	  }
	  catch(Exception e) {
	    e.printStackTrace();
	  }*/
	}//////////////////end of TalkClientVer2

	public TalkClientVer2(LoginForm loginForm) {
		this.loginForm = loginForm;
		nickName = loginForm.nickName;
		
		  try {
			    jbInit();
			    connect_process();
			  }
			  catch(Exception e) {
			    e.printStackTrace();
			  }		
	}

	public static void main(String[] args) {
		TalkClientVer2 tc2 = new TalkClientVer2();
	}

	public void connect_process() {
		//nickName = JOptionPane.showInputDialog("너의 대화명은?");
		this.setTitle(nickName+"님의 대화창");
		try {
			//통신은 지연될 수 있다.-wait - try...catch해야함.
			mySocket = new Socket(ip,port);
			oos = new ObjectOutputStream
					(mySocket.getOutputStream());			
			ois = new ObjectInputStream
						(mySocket.getInputStream());
			//톡방 정보 담기
			Room room = new Room();
			room.setTitle("스마트웹모바일 응용SW엔지니어");
			room.current = 10;
			room.state = "대기";
			//100|나초보
//			oos.writeObject(Protocol.ROOM_IN+Protocol.seperator+nickName+Protocol.seperator+room.getTitle());
			oos.writeObject(Protocol.WAIT
					       +Protocol.seperator+nickName
					       +Protocol.seperator+room.state);
			TalkClientThread tct = new TalkClientThread(this);
			tct.start();//TalkClientThread의 run호출됨.-콜백함수
		} catch (Exception e) {
			System.out.println(e.toString());//에러 힌트문 출력.
		}		
	}	
	private void jbInit() throws Exception {
	  this.getContentPane().setLayout(null);
	  tp.addTab("대기실",wr);
	  this.getContentPane().setBackground(new Color(158, 217, 164));
	  tp.addTab("대화방", mr);
	  tp.setFont(new java.awt.Font("SansSerif", 0, 12));
	  tp.setToolTipText("");
	  tp.setBounds(new Rectangle(5, 4, 627, 530));
	  this.getContentPane().add(tp, null);
	  setSize(655,585);
	  setVisible(true);
	}
}