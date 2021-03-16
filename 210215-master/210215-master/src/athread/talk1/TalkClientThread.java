package athread.talk1;

import java.util.StringTokenizer;

public class TalkClientThread extends Thread {
	TalkClientVer2 tc = null;
	public TalkClientThread(TalkClientVer2 talkClient) {
		this.tc = talkClient;
	}
	@Override
	public void run() {//여기는 듣는곳
		boolean isStop = false;
		while(!isStop) {
			try {
				String msg = "";
				msg = (String)tc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if(msg != null) {
					st = new StringTokenizer(msg, "#");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
					case Protocol.ROOM_IN:{
						String nickname = st.nextToken();
						tc.jta_display.append(nickname + "님이 입장하였습니다. \n");
					}
					case Protocol.MESSAGE:{
						String nickname = st.nextToken();
						String msg2 = st.nextToken();
						tc.jta_display.append("[" + nickname + "]" + msg2 + "\n");	
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
