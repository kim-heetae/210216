package athread.talk2;

import java.util.StringTokenizer;
import java.util.Vector;

/*********************************************************************************************
 * 이벤트 핸들러의 역할은 말하기 이고
 * 클라이언트 측의 스레드의 역할은 듣기이다.
 * @author User
 *
 */
public class PotatoClientThread extends Thread{
	PotatoClient pc = null;
	public PotatoClientThread(PotatoClient pc) {
		this.pc = pc;
	}
	@Override
	public void run() {
		boolean isStop = false;
		while(!isStop) {
			try {
				String msg = "";//100#apple
				msg = (String)pc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;//100|200|201|202|500
				if(msg !=null) {
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken());//100
				}
				switch(protocol) {
					case 100:{//100#apple
						String nickName = st.nextToken();
						pc.jta_display.append(nickName+"님이 입장하였습니다.\n");
						Vector<String> v = new Vector<>();
						v.add(nickName);
						pc.dtm.addRow(v);
					}break;
					case 200:{
						
					}break;
					case 201:{
						String nickName = st.nextToken();
						String message = st.nextToken();
						pc.jta_display.append("["+nickName+"]"+message+"\n");
						pc.jta_display.setCaretPosition
						(pc.jta_display.getDocument().getLength());	
					}break;
					case 202:{
						
					}break;
					case 500:{
						String nickName = st.nextToken();
						pc.jta_display.append(nickName+"님이 퇴장 하였습니다.\n");
						pc.jta_display.setCaretPosition
						(pc.jta_display.getDocument().getLength());
						for(int i=0;i<pc.dtm.getRowCount();i++) {
							String n =(String)pc.dtm.getValueAt(i, 0);
							if(n.equals(nickName)) {
								pc.dtm.removeRow(i);
							}
						}
					}break;
				}////////////end of switch
			} catch (Exception e) {
				// TODO: handle exception
			}
		}////////////////////end of while
	}
	/*
	@Override
	public synchronized void run() {
		
	}
	@Override
	public void run() {
		synchronized (this) {
			
		}
	}
	*/
}