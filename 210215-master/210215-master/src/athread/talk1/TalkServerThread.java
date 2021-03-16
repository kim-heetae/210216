package athread.talk1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
	TalkServer 			ts 			= null;
	Socket 				client		= null;
	ObjectOutputStream 	oos			= null;
	ObjectInputStream 	ois			= null;
	//닉네임
	String 				nickname 	= null;
	/*
	 * 클라이언트 측에서 서버소켓에 접속하고 나면 생성자를 통해서 TalkServer의 주소번지를 받게 되고 이것으로 소켓에 접근이 가능함
	 * 이 소켓으로 ois와 oos를 생성하고 접속해온 사용자의 정보를 청취함
	 * 청취한 내용을 TalkServer의 jta_log에 출력해봄
	 */
	public TalkServerThread(TalkServer talkServer) {
		this.ts = talkServer;
		this.client = ts.client;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());//홀수자리의 소켓 - 쓰기역할
			ois = new ObjectInputStream(client.getInputStream());//짝수자리의 소켓 - 듣기역할
			String msg = (String)ois.readObject();
			ts.jta_log.append(msg + "\n");
			StringTokenizer st = new StringTokenizer(msg, "#");
			st.nextToken();
			nickname = st.nextToken();
			ts.jta_log.append(nickname + "님이 입장하였습니다. \n");
			for(TalkServerThread tst : ts.globalList) {
				//재훈이 입장하기 전에 있는 친구들의 정보를 받기
				this.send(100 + "#" + tst.nickname);
			}
			ts.globalList.add(this);//현재 스레드는 재훈 스레드
			this.broadCasting(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
	//globalList에는 서버에 접속해온 클라이언트에 대한 스레드 객체가 담겨있음
	public void broadCasting(String msg) {
		for(TalkServerThread tst : ts.globalList) {
			//그 스레드에 send메소드 호출하여 메시지 전송함
			tst.send(msg);
		}
	}
	//클라이언트에게 말하기 구현
	public void send(String msg) {
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		boolean isStop = false;
		try {
			run_start : 
				while(!isStop) {
					try {
						String msg = "";
						msg = (String)ois.readObject();
						ts.jta_log.append(msg + "\n");
						StringTokenizer st = null;
						int protocol = 0;
						if(msg != null) {
							st = new StringTokenizer(msg, "#");
							protocol = Integer.parseInt(st.nextToken());
						}
						switch(protocol) {
						case 200:
							String nickname = st.nextToken();
							String msg2 = st.nextToken();
							broadCasting(200 + "#" + nickname + "#" + msg2);
						}
					} catch (Exception e) {
						System.out.println("while inner" + e.toString());
						
//						System.exit(0);
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}




















