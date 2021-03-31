package athread.talk2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

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
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			
			String msg = (String)ois.readObject();
			ps.jta_log.append(msg+"\n");
			StringTokenizer st = new StringTokenizer(msg,"#");
			st.nextToken();//100
			chatName = st.nextToken();
			ps.jta_log.append(chatName+"님이 입장하였습니다.\n");
			for(PotatoServerThread pst:ps.globalList) {
			//이전에 입장해 있는 친구들 정보 받아내기
				//String currentName = tst.chatName;
				this.send(100+"#"+pst.chatName);
			}
			//현재 서버에 입장한 클라이언트 스레드 추가하기
			ps.globalList.add(this);
			this.broadCasting(msg);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}//////////////////////////////////////////end of PotatoServerThread/////////////////////////////////////////
	//현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
		public void broadCasting(String msg) {
			for(PotatoServerThread pst:ps.globalList) {
				pst.send(msg);
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
						case 200:{
						}break;
						case 201:{
							String nickName = st.nextToken();
							String message = st.nextToken();
							broadCasting(201
									+"#"+nickName
									+"#"+message);
						
						}break;
						case 202:{
						
						}break;
						case 500:{
							String nickName = st.nextToken();
							ps.globalList.remove(this);
							broadCasting(500
									+"#"+nickName);
//							ps.globalList.get(0).oos.writeObject(400);//////////////////////
						}break run_start;
					}/////////////end of switch
				}/////////////////end of while			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}/////////////////////////end of run

}