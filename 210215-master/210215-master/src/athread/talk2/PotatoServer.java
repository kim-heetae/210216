package athread.talk2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PotatoServer extends JFrame implements Runnable{
	//사용자가 접속을 해 올때 마다(입장) 새로 객체를 생성해야 함. 
	// - 왜나면 서로 다른 사람이니까 그 사람만의 소켓, ois, oos가 될수 있도록 설계 
	PotatoServerThread 			pst 		= null;
	//Vector로 선언하지 않는 이유는 다형성을 말하기 위해.
	//내 안에 여러 사람의 Thread를 관리
	List<PotatoServerThread> 	globalList 	= null;
	List<Room>  				roomList	= null;
	ServerSocket 				server 		= null;
	Socket 						socket 		= null;
	JTextArea 					jta_log 	= new JTextArea(10,30);
	JScrollPane 				jsp_log 	= new JScrollPane(jta_log
												,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
		                                        ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel 		jp_north = new JPanel();
	JButton 	jbtn_log = new JButton("로그저장");
	String      logPath  = "src\\athread\\talk2\\";
	
	
	@Override
	public void run() {
		globalList = new Vector<>();
		boolean isStop = false;
		try {
			server = new ServerSocket(7375);
			jta_log.append("Server Ready.........\n");
			while(!isStop) {
				socket = server.accept();
				jta_log.append("client info:"+socket+"\n");//유저의 정보				
				PotatoServerThread pst = new PotatoServerThread(this);//PST생성, 생성자 실행
				pst.start();//PST의 run실행
				System.out.println(globalList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initDisplay() {
		jbtn_log.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(obj==jbtn_log) {
					String fileName = "log_"+setTimer()+".txt";
					System.out.println(fileName);//log_2020-03-13.txt
					try {
					//자바는 모든 기능 사물 들을 클래스로 설계하도록 유도한다.
					//파일명을 클래스로 만들어주는 API가 있다. -File
						File f = new File(logPath+fileName);
					//파일명만 생성될 뿐 내용까지 만들어주지는 않는다.
					//내용부분을 담는 별도의 클래스가 필요하다.
						PrintWriter pw = 
								new PrintWriter(
										new BufferedWriter(//필터클래스-카메라 필터
												new FileWriter(f.getAbsolutePath())));
					//io패키지에는 단독으로 파일을 컨트롤할 수 있는 클래스가 있고
					//그 클래스에 연결해서 사용하는 필터 클래스가 존재함.(기능을 향상해줌)	
						pw.write(jta_log.getText());
						pw.close();//사용한 입출력 클래스는 반드시 닫아줌.
					} catch (Exception e2) {
						//예외가 발생했을 때 출력함.
						//예외가 발생하지 않으면 실행이 안됨.
						System.out.println(e2.toString());
					}
				}				
			}
		});
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jta_log.setBackground(Color.orange);
		jp_north.add(jbtn_log);
		this.add("North",jp_north);
		this.add("Center",jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		PotatoServer ps = new PotatoServer();
		ps.initDisplay();
		Thread th = new Thread(ps);
		th.start();

	}
	public String setTimer() {
		Calendar cal = Calendar.getInstance();
		int yyyy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH)+1;
		int day =  cal.get(Calendar.DAY_OF_MONTH);
		return yyyy+"-"+
			   (mm < 10 ? "0"+mm:""+mm)+"-"+
			   (day < 10 ? "0"+day:""+day);
	}////////////////end of setTimer
}