package athread.talk2;

import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;

/*********************************************************************************************
 * 이벤트 핸들러의 역할은 말하기 이고
 * 클라이언트 측의 스레드의 역할은 듣기이다.
 * @author User
 *
 */
public class PotatoClientThread extends Thread{
	PotatoClientVer2 pc = null;
	public PotatoClientThread(PotatoClientVer2 pc) {
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
					case Protocol.ROOM_IN:{//100#apple
						String nickName = st.nextToken();
//						pc.jta_display.append(nickName+"님이 입장하였습니다.\n");
						MutableAttributeSet attr = new SimpleAttributeSet();
						try {
							pc.sd_display.insertString(pc.sd_display.getLength(), nickName + "님이 입장하였습니다.\n", attr);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
						Vector<String> v = new Vector<>();
						v.add(nickName);
						pc.dtm.addRow(v);
					}break;
					case Protocol.MESSAGE:{
						String nickName = st.nextToken();
						String message = st.nextToken();
						MutableAttributeSet attr = new SimpleAttributeSet();
						try {
							pc.sd_display.insertString(pc.sd_display.getLength(), "["+nickName+"]"+message+"\n", attr);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
						pc.jtp_display.setCaretPosition
						(pc.sd_display.getLength());	
					}break;
					case Protocol.CHANGE:{
						String nickName = st.nextToken();
						String afterName = st.nextToken();
						String infomsg = st.nextToken();
						for(int i = 0; i < pc.dtm.getRowCount(); i++) {
							String currentName = (String)pc.dtm.getValueAt(i, 0);
							if(currentName.equals(nickName)) {
								pc.dtm.setValueAt(afterName, i, 0);
								break;
							}
						}
						MutableAttributeSet attr = new SimpleAttributeSet();
						try {
							pc.sd_display.insertString(pc.sd_display.getLength()
									, infomsg
									, attr);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
						pc.jtp_display.setCaretPosition
									(pc.sd_display.getLength());
						if(nickName.equals(pc.nickName)) {
							pc.setTitle(afterName);
							pc.nickName = afterName;
						}
					}break;
					case Protocol.ROOM_OUT:{
						String nickName = st.nextToken();
						MutableAttributeSet attr = new SimpleAttributeSet();
						for(int i=0; i < pc.dtm.getRowCount(); i++) {
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