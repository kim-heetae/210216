package com.network4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;


public class MessageRoom extends JPanel implements ActionListener{
	TalkClientVer2 tc2 = null;
	StyledDocument sd_display = 
			new DefaultStyledDocument(
					new StyleContext());
	//Image i;
	//String imgPath = "C:\\dev_kosmo20181101\\dev_java\\com\\book\\image\\";
	//ImageIcon icon = new ImageIcon(imgPath+"booklogo.jpg");
	//JLabel jlb_bg = new JLabel(icon);
	JTextPane   jtp_display     = new JTextPane(sd_display);
	JScrollPane jsp_display 
				= new JScrollPane(jtp_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
						        , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_first 		= new JPanel();//기존 배치한 컴포넌트 담기
	JPanel jp_first_south   = new JPanel();//BorderLayout
	JTextField jtf_msg 		= new JTextField();//Center
	JButton jbtn_send 		= new JButton("전송");//East
	JPanel jp_second 		= new JPanel();//새로 추가하는 컴포넌트 담기-JTable - Center:JTable, South:버튼 6개
	JPanel jp_second_south 	= new JPanel();//새로 추가하는 컴포넌트 담기-JButton 6개 - GridLayout(3,2)
	JButton jbtn_whisper	= new JButton("1:1");//East
	JButton jbtn_change		= new JButton("대화명변경");//East
	JButton jbtn_fontColor	= new JButton("글자색");//East
	JButton jbtn_emoticon	= new JButton("이모티콘");//East
	JButton jbtn_blank 		= new JButton("");//East
	JButton jbtn_exit 		= new JButton("종료");//East
	String cols[] = {"대화명"};
	String data[][] = new String[0][1];
	//DataSet의 역할을 수행하는 DefaultTableModel을 먼저 선언하고 초기화 하기
	DefaultTableModel dtm_nick = new DefaultTableModel(data,cols); 
	JTable 			  jtb_nick = new JTable(dtm_nick);
	JScrollPane 	  jsp_nick = new JScrollPane(jtb_nick
			                                    ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                                    ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
	PictureMessage  pm = new PictureMessage(this);
	String fontColor = "0";	
	public MessageRoom() {
	}

	public MessageRoom(TalkClientVer2 tc2) {
		this.tc2 = tc2;
		initDisplay();
	}
	public MessageRoom(LoginForm loginForm) {
		// TODO Auto-generated constructor stub
	}

	public void initDisplay() {
		jbtn_exit.addActionListener(this);
		jtf_msg.addActionListener(this);
		jbtn_send.addActionListener(this);
		//JFrame의 레이아웃을 GridLayout변경
		this.setLayout(new GridLayout(1,2));
		//첫번째 섹션에 기존 컴포넌트 배치
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first.add("Center",jsp_display);
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jbtn_send);
		jp_first.add("South",jp_first_south);
		//두번째 섹션에 추가  컴포넌트 배치
		jp_second.setLayout(new BorderLayout());
		jp_second_south.setLayout(new GridLayout(3,2));
		jp_second.add("Center", jsp_nick);
		jp_second_south.add(jbtn_whisper);//1:1
		jp_second_south.add(jbtn_change);//대화명변경
		jp_second_south.add(jbtn_fontColor);//글자색
		jp_second_south.add(jbtn_emoticon);//이모티콘
		jp_second_south.add(jbtn_blank);//블랭크
		jp_second_south.add(jbtn_exit);//종료
		jp_second.add("South",jp_second_south);
		this.add(jp_first);//첫번째 섹션
		this.add(jp_second);//두번째 섹션
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public void message_process(String msg, String imgChoice) {
		//단톡방이름을 가져와야 함.
		String roomTitle = null;
		for(int i=0;i<tc2.wr.jtb_wait.getRowCount();i++) {
			if(tc2.nickName.equals(tc2.wr.dtm_wait.getValueAt(i, 0))) {
				roomTitle = (String)tc2.wr.dtm_wait.getValueAt(i, 1);
				break;
			}
		}		
		
		if("이모티콘".equals(msg)){
			//msg = "이모티콘";
			try {
				tc2.oos.writeObject(Protocol.MESSAGE
						+Protocol.seperator+roomTitle
						+Protocol.seperator+tc2.nickName
						+Protocol.seperator+msg
						+Protocol.seperator+fontColor
						+Protocol.seperator+imgChoice);
			} catch (Exception e2) {
				System.out.println(e2.toString());//힌트문 출력하기
			}
		}
		else {//메시지가 있을 때
		 
			try {
				tc2.oos.writeObject(Protocol.MESSAGE
						+Protocol.seperator+roomTitle
						+Protocol.seperator+tc2.nickName
						+Protocol.seperator+msg
						+Protocol.seperator+fontColor
						+Protocol.seperator+"default");
			} catch (Exception e2) {
				System.out.println(e2.toString());//힌트문 출력하기
			}
		}
		jtf_msg.setText("");	
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		String msg = jtf_msg.getText();
		if(obj==jtf_msg) {
			message_process(msg,null);
		}
	}

}
