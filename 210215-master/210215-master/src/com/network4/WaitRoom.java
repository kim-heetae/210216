package com.network4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

//import address.mvc.result.AddressCtrl;
//import address.mvc.result.AddressVO;

public class WaitRoom extends JPanel implements ActionListener {
	TalkClientVer2 tc2 = null;
	LoginForm loginForm = null;
	JPanel jp_first = new JPanel();
	JPanel jp_second = new JPanel();
	JPanel jp_second_south = new JPanel();
	String cols[] = {"대화명","위치"};
	String data[][] = new String[0][2];
	//DataSet의 역할을 수행하는 DefaultTableModel을 먼저 선언하고 초기화 하기
	DefaultTableModel dtm_wait = new DefaultTableModel(data,cols); 
	JTable 			  jtb_wait = new JTable(dtm_wait);
	JScrollPane 	  jsp_wait = new JScrollPane(jtb_wait
			                                    ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                                    ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
	String cols2[] = {"단톡이름","현재원"};
	String data2[][] = new String[0][2];
	DefaultTableModel dtm_room = new DefaultTableModel(data2,cols2); 
	JTable 			  jtb_room = new JTable(dtm_room);
	JScrollPane 	  jsp_room = new JScrollPane(jtb_room
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
	JButton jbtn_create = new JButton("단톡생성");
	JButton jbtn_in = new JButton("입장");
	JButton jbtn_out = new JButton("나가기");
	JButton jbtn_exit = new JButton("종료");
	JTableHeader jth_wait = jtb_wait.getTableHeader();
	JTableHeader jth_room = jtb_room.getTableHeader();
	String nickName = null;
	String roomTitle = null;
	int currentNum = 1;
	Room room = null;
	public WaitRoom() {
		// TODO Auto-generated constructor stub
	}

	public WaitRoom(TalkClientVer2 tc2) {
		this.tc2 = tc2;
		initDisplay();
	}
	public WaitRoom(LoginForm loginForm) {
		this.loginForm = loginForm;
		initDisplay();
	}

	public void initDisplay() {
/*		tcv.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				exitChat();
			}
		});*/
		jbtn_create.addActionListener(this);
		jbtn_in.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jth_wait.setBackground(Color.RED);
		jth_wait.setForeground(Color.WHITE);
		jth_room.setBackground(Color.ORANGE);
		jth_room.setForeground(Color.WHITE);
		jtb_wait.setSelectionBackground(Color.BLACK);
		jtb_wait.setSelectionForeground(Color.WHITE);
		jtb_wait.getColumnModel().getColumn(0).setPreferredWidth(130);
		jtb_wait.getColumnModel().getColumn(1).setPreferredWidth(200);
		jtb_room.setSelectionBackground(Color.BLACK);
		jtb_room.setSelectionForeground(Color.WHITE);
		jtb_room.getColumnModel().getColumn(0).setPreferredWidth(230);
		jtb_room.getColumnModel().getColumn(1).setPreferredWidth(100);
		jtb_wait.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtb_room.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtb_wait.setGridColor(Color.RED);
		jtb_room.setGridColor(Color.ORANGE);
		this.setLayout(new GridLayout(1,2));
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",jsp_wait);
		jp_second.setLayout(new BorderLayout());
		jp_second.add("Center",jsp_room);
		jp_second_south.setLayout(new GridLayout(2,2));
		jp_second_south.add(jbtn_create);
		jp_second_south.add(jbtn_in);
		jp_second_south.add(jbtn_out);
		jp_second_south.add(jbtn_exit);
		this.add(jp_first);
		jp_second.add("South",jp_second_south);
		this.add(jp_second);
	}
	public static void main(String args[]) {
		WaitRoom wr = new WaitRoom();
		wr.initDisplay();
	}
	//종료의 경우 여러 이벤트 에서 재사용할 수 있으므로 재사용 가능하도록 메소드로 구현해 볼것.
	public void exitChat() {
		try {
			tc2.oos.writeObject(Protocol.ROOM_OUT+"|"+this.nickName);
		} catch (Exception e) {
			//stack메모리 영역에 쌓여있는 에러 메시지들을 순차적으로 출력해주고 라인번호와 에러 메시지 출력
			e.printStackTrace();//꼭 기억하자.- 힌트를 출력하는 메소드인데 이력까지도 출력, 라인번호도 같이 출력
		}
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == jbtn_create) {
			roomTitle = JOptionPane.showInputDialog("단톡 이름을 지어주세요.");
			if(roomTitle!=null) {
				try {
					tc2.oos.writeObject(Protocol.ROOM_CREATE
							+Protocol.seperator+roomTitle
							+Protocol.seperator+0);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}///////////////end of 방만들기
		else if(obj == jbtn_in) {
			int index[]= jtb_room.getSelectedRows();
			if (index.length == 0) {
				JOptionPane.showMessageDialog(this, "단톡방을 선택하세요..."
						, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				try {
					for(int i = 0; i < jtb_room.getRowCount(); i++) {
						if(jtb_room.isRowSelected(i)) {
							String roomTitle = (String)dtm_room.getValueAt(i, 0);
							tc2.oos.writeObject(Protocol.ROOM_IN
									+Protocol.seperator+roomTitle
									+Protocol.seperator+tc2.nickName);
						}
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "삭제중 에러가 발생했습니다.\n" + e,
						"Error", JOptionPane.ERROR_MESSAGE);
				}
			}	
			jtb_room.clearSelection();
		}///////////////end of 방입장
		else if(obj == jbtn_exit) {
			System.exit(0);
		}///////////////end of 방입장
		
	}
}
