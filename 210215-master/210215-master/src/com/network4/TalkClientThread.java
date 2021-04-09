package com.network4;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


public class TalkClientThread extends Thread {
	TalkClientVer2 tcv = null;
	String path = "C:\\Java\\dev_javaB\\dev_java\\src\\image\\";
	String g_roomTitle = null;
	public TalkClientThread(TalkClientVer2 tcv) {
		this.tcv = tcv;
	}
	public SimpleAttributeSet  makeAttribute(String fcolor) {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
				       , new Color(Integer.parseInt(fcolor)));
		return sas;
	}	
	public void run() {
		String msg = null;
		boolean isStop = false;
		while(!isStop) {//무한루프 방지코드를 꼭 추가하자 - 변수처리하자, 조건식을 활용하자
			try {
				//100|나초보
				msg = (String)tcv.ois.readObject();
				JOptionPane.showMessageDialog(tcv, msg+"\n");
				StringTokenizer st  = null;
				int protocol = 0;
				if(msg!=null) {
					st = new StringTokenizer(msg,Protocol.seperator);
					protocol = Integer.parseInt(st.nextToken());
				}
				//JOptionPane.showMessageDialog(tcv, "프로토콜:"+protocol);
				switch(protocol) {
					case Protocol.WAIT:{
						String nickName = st.nextToken();
						String state = st.nextToken();
						Vector<String> v_nick = new Vector<String>();
						v_nick.add(nickName);
						v_nick.add(state);
						tcv.wr.dtm_wait.addRow(v_nick);
						tcv.wr.jsp_wait.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar)e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});
					}break;
					case Protocol.ROOM_CREATE:{
						JOptionPane.showMessageDialog(tcv, "Client ROOM_CREATE");
						String roomTitle = st.nextToken();
						String currentNum = st.nextToken();
						Vector<String> v_room = new Vector<String>();
						v_room.add(roomTitle);
						v_room.add(currentNum);
						tcv.wr.dtm_room.addRow(v_room);
						tcv.wr.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar)e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});
					}break;
					case Protocol.ROOM_LIST:{
						JOptionPane.showMessageDialog(tcv, "Client ROOM_LIST");
						String roomTitle = st.nextToken();
						String currentNum = st.nextToken();
						Vector<String> v_room = new Vector<String>();
						v_room.add(roomTitle);
						v_room.add(currentNum);
						tcv.wr.dtm_room.addRow(v_room);
						tcv.wr.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar)e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});						
					}break;
					case Protocol.ROOM_IN:{
						JOptionPane.showMessageDialog(tcv, "클라이언트 ROOM IN처리:"+msg);
						String roomTitle = st.nextToken();
		            	//g_roomTitle = roomTitle;
						String current = st.nextToken();
						String nickName = st.nextToken();
						String temp = st.nextToken();//대화명리스트
						JOptionPane.showMessageDialog(tcv, "클라이언트 ROOM IN temp:"+temp);
						String names[] = new String[Integer.parseInt(current)];
						StringTokenizer st_names = null;
						if(temp!=null) {
							st_names = new StringTokenizer(temp,"#");
							//names = new String[st_names.countTokens()];
							for(int i=0;st_names.hasMoreTokens();i++) {
								names[i] = st_names.nextToken();
								//JOptionPane.showMessageDialog(tcv, nickName+"클라이언트 ROOM IN names["+i+"]="+names[i]);
							}
						}
						//JOptionPane.showMessageDialog(tcv, "클라이언트 ROOM IN names.length:"+names.length);
						tcv.wr.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar)e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});
			            //방정보 인원갱신
						//JOptionPane.showMessageDialog(tcv, "tcv.wr.jtb_room.getRowCount():"+tcv.wr.jtb_room.getRowCount());
			            for(int i=0; i<tcv.wr.jtb_room.getRowCount(); i++){
		            	JOptionPane.showMessageDialog(tcv, "방제목:"+(String)tcv.wr.dtm_room.getValueAt(i,0)+",인원:"+current);
			             if(roomTitle.equals((String)tcv.wr.dtm_room.getValueAt(i,0))){
			                  tcv.wr.dtm_room.setValueAt(current, i, 1);
			                  break;
			             }
			            }
			            //JOptionPane.showMessageDialog(tcv, "tcv.wr.jtb_wait.getRowCount():"+tcv.wr.jtb_wait.getRowCount());
			           //대기실 위치 갱신
			            for(int i=0; i<tcv.wr.jtb_wait.getRowCount(); i++) {
			              if(nickName.equals((String)tcv.wr.dtm_wait.getValueAt(i,0))){
			                  tcv.wr.dtm_wait.setValueAt(roomTitle,i,1);
			              }
			            }//for i end	
			            //JOptionPane.showMessageDialog(tcv, nickName+"클라이언트 ROOM IN temp="+temp);
			            //대화방으로 이동하기
			            //방입장하기 누른 사람만 화면 이동처리
			            if(tcv.nickName.equals(nickName)) {
			            	tcv.tp.setSelectedIndex(1);
			            	tcv.mr.jtf_msg.requestFocus();
			            	//String names[] = {tcv.nickName};
			            	for(int x=0;x<tcv.wr.jtb_wait.getRowCount();x++) {
			            		//JOptionPane.showMessageDialog(tcv, "roomTitle:"+roomTitle+", "+tcv.wr.dtm_wait.getValueAt(x, 1));
			            		if(roomTitle.equals(tcv.wr.dtm_wait.getValueAt(x, 1))) {
			            			String imsi[] = {(String)tcv.wr.dtm_wait.getValueAt(x, 0)};
			            			tcv.mr.dtm_nick.addRow(imsi);
			            		}
			            	}
			            }
					}break;
					case Protocol.ROOM_INLIST:{
						JOptionPane.showMessageDialog(tcv, "Client ROOM_INLIST");
						String roomTitle = st.nextToken();
						String currentNum = st.nextToken();
						String nickName = st.nextToken();
						Vector<String> v_room = new Vector<String>();
						v_room.add(nickName);
						tcv.mr.dtm_nick.addRow(v_room);
						tcv.mr.jsp_nick.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar)e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});						
					}break;
					case Protocol.MESSAGE:{//200
						String nickName = st.nextToken();
						String message = st.nextToken();
						//메시지 뒤에 Vector와 같은 Object를 넘길 수 있나?
						String fontColor = st.nextToken();
						String imgChoice = st.nextToken();
					    MutableAttributeSet  attr1 = new SimpleAttributeSet();
					    MutableAttributeSet  attr2 = new SimpleAttributeSet();
					    if(!imgChoice.equals("default")){
						    int i=0;
						    for(i=0;i<tcv.mr.pm.imgfile.length;i++){
						    	if(tcv.mr.pm.imgfile[i].equals(imgChoice)){
						    		//JOptionPane.showMessageDialog(tcv, "이미지이름:"+tcv.mr.pm.imgfile[i]);
						    		StyleConstants.setIcon(attr2,
						    				new ImageIcon(path + tcv.mr.pm.imgfile[i]));
						    		try{
						    			tcv.mr.sd_display.insertString(tcv.mr.sd_display.getLength() , "1\n" , attr2);
						    		}catch(Exception ex){}
						    	}
						    }
					    }//////////////////////end of emoticon
						//JOptionPane.showMessageDialog(tc, "style:"+style.length);
						//if(!message.equals("이모티콘")){
						else if(!message.equals("이모티콘")){	
							SimpleAttributeSet sas = makeAttribute(fontColor);
							//tc.jta_display.setLineWrap(true);
							try {
								//JOptionPane.showMessageDialog(tc, "insertString:"+nickName);
								tcv.mr.sd_display.insertString(tcv.mr.sd_display.getLength(),"["+nickName+"]"+message+"\n", sas);
								//tc.textPane.insertEmoText(nickName+ " : "+msg+"\n", sas);					
							} catch (Exception e) {
								JOptionPane.showMessageDialog(tcv, "Excepton:"+e.toString());
							}
							tcv.mr.jtp_display.setCaretPosition(tcv.mr.sd_display.getLength());					
							//tc.jta_display.append("["+nickName+"] "+msg+"\n");
							//tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
						}//////////////////////end of 이모티콘						
						//tc.jtp_display.append("["+nickName+"]"+message+"\n");
						tcv.mr.jtp_display.setCaretPosition(tcv.mr.sd_display.getLength());
					}break;	
				}//////////////end of switch
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
