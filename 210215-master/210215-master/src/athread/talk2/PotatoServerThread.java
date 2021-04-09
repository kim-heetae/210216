package athread.talk2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;

public class PotatoServerThread extends Thread {
	PotatoServer ps = null;
	Socket client = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String chatName = null;//현재 서버에 입장한 클라이언트 스레드 닉네임 저장
	

	public PotatoServerThread(PotatoServer ps) {
		this.ps = ps;
		this.client = ps.socket;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());//홀수소켓(말하기)
			ois = new ObjectInputStream(client.getInputStream());//짝수소켓(듣기)
			//130#은영[청취]
			String msg = (String)ois.readObject();//듣기
			ps.jta_log.append(msg+"\n");//서버출력
			StringTokenizer st = new StringTokenizer(msg,"#");//자르기
			st.nextToken();//130 추출
			chatName = st.nextToken();//은영 추출
			ps.jta_log.append(chatName+"님이 입장하였습니다.\n");
			for(PotatoServerThread pst:ps.globalList) {
			//이전에 입장해 있는 친구들 정보 받아내기
				//String currentName = tst.chatName;
				this.send(Protocol.ROOM_IN+"#"+pst.chatName);
			}
			//현재 서버에 입장한 클라이언트 스레드 추가하기
			ps.globalList.add(this);//앞의 for문은 타지않고 은영이 globallist에 추가
			this.broadCasting(msg);//방송 - 1명에게만 전송
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}//////////////////////////////////////////end of PotatoServerThread/////////////////////////////////////////
	//현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
		public void broadCasting(String msg) {
			for(PotatoServerThread pst:ps.globalList) {//globallist의 size() = 1 , 다른사람 추가 입장시 2
				pst.send(msg);//은영한테만 보낸다. , 추가로 내가 들어가면 은영, 희태 모두 전송
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
		public void run() {
			String msg = null;
			boolean isStop = false;
			try {
				//while(true) {//무한루프에 빠질 수 있다.
				run_start://while문 전체를 빠져나갈수 있음 - break 라벨명;
				while(!isStop) {
					System.out.println("기다려");
					msg = (String)ois.readObject();
					System.out.println("보이니?");
					ps.jta_log.append(msg+"\n");
					ps.jta_log.setCaretPosition
					(ps.jta_log.getDocument().getLength());
					StringTokenizer st = null;
					int protocol = 0;//100|200|201|202|500
					if(msg !=null) {
						st = new StringTokenizer(msg,"#");
						protocol = Integer.parseInt(st.nextToken());//100
					}
					switch(protocol) {
						case Protocol.MESSAGE:{
							String nickName = st.nextToken();
							String message = st.nextToken();
							broadCasting(Protocol.MESSAGE
									+"#"+nickName
									+"#"+message);
						
						}break;
						case 202:{
						
						}break;
						case Protocol.CHANGE:{
							String nickName = st.nextToken();
							String afterName = st.nextToken();
							String infomsg = st.nextToken();
							this.chatName = afterName;//서버가 가지고있는 이름과 동기화
							broadCasting(Protocol.CHANGE 
										+ Protocol.seperator + nickName 
										+ Protocol.seperator + afterName 
										+ Protocol.seperator + infomsg);
						}break;
						case Protocol.ROOM_OUT:{
							String nickName = st.nextToken();
							ps.globalList.remove(this);
							broadCasting(Protocol.ROOM_OUT
									+"#"+nickName);
							break run_start;
//							ps.globalList.get(0).oos.writeObject(400);//////////////////////
//						}break run_start;
						}
					}/////////////end of switch
				}/////////////////end of while			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}/////////////////////////end of run

}