package network.step1;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

import javax.swing.JFrame;
/*
 * 소켓 - 무전기에 장착된 하드웨어
 * 네트워크에서 정보가 들어가고 나가는 지점에 대한 유일한 식별자
 * 32비트의 숫자로 구성되며 짝수번 소켓은 정보를 받아들이는 용도로
 * 홀수번 소캣은 정보를 보내는 용도로 사용됨.
 * 
 * FIFO속성을 가지고 있다. - 큐, 스택(LIFO)
 * 동시에 두가지를 할수는 없다 (읽으면서 쓰기 , 쓰면서 읽기 불가능)
 * 
 * 네트워크망이 구성되어 있어야 함.
 * 
 * TCP포트번호 : 물리적인 장치를 꽂는 장소는 아니다. 용도에 따라 쓰는 숫자값.
 * 서버에서 돌아가는 특정 프로그램을 나타내는 16비트 숫자
 * 웹서버 - 80
 * 텔넷서버 - 23
 * FTP서버 - 20
 * SMTP서버 - 25
 * 
 * 같은 포트에서 여러 프로그램이 돌아갈 수 있나요?
 * 		BindException이 발생한다.
 * 
 * 		nestat -ano | findstr 3000 검색
 * 		taskkill /pid 42356 /f
 * 		
 *  */
public class TimeServer extends Thread{
	Socket socket = null;
	public TimeServer() {}
	public TimeServer(Socket socket) {
		this.socket = socket;
	}
	/************************************
	 * 스레드 기동시 호출되는 메소드
	 ************************************/
	public static void initDisplay() {
		new JFrame().setVisible(true);
	}
	@Override
	public void run() {
		boolean isFlag = false;
		try {
			//socket에 대한 객체주입은 인스턴스화를 통해서 생성자가 호출되었을때 객체 주입이 이루어짐
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			while(!isFlag) {
				if(out!=null) {
					out.println(getTimer());
				}
				//1초동안 기대려 - 그리고 진행 - 기다려 - 진행...
				try {
					sleep(1000); // (지연하기, 경합, 순서, 순서정하기) - 스레드
				} catch (InterruptedException ie) {
					System.out.println("누구?");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("run call............");
	}
	public String getTimer() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		String timenow = String.format("현재시각은 %02d시 %02d분 %02d초", hour, min, sec);
		return timenow;
//		return "현재시간은 " + (hour < 10 ? "0" + hour : "" + hour ) + "시"
//				+ (min < 10 ? "0" + min : "" + min ) + "분"
//				+ (sec < 10 ? "0" + sec : "" + sec ) + "초 입니다.";
	}
	//main메소드도 Thread 이다. (default thread 이다) - entry point - static {}
	public static void main(String[] args) {
		int port = 7375;//포트번호 지정
		boolean isFlag = false;//서버를 탈출시키 수 있는 수단
		ServerSocket server = null; //클라이언트가 접속할 때까지 null값유지 - new Socket("192.168.0.23" , 7375)실행시 까지
		Socket client = null;
		try {
			server = new ServerSocket(port);
		} catch (Exception e) {
			System.out.println("포트중복");
			e.printStackTrace();
		}
		System.out.println("TimeServer Start");
//		while(true) { 상수값 사용금지 - 무한루프 가능
		while(!isFlag) {
			try {
				//클라이언트가 접속할 때까지 이 라인에서 기다린다
				client = server.accept();
				//initDisplay(); 여기에 있으면 실행되지 않을수도 있다 - 위치와 순서 중요, 화면 - input - operation - output 소통의 시작점
				System.out.println("New Client connected : " + client.toString() + "\n");
				TimeServer ts = new TimeServer(client);
				ts.start();//run 호출 
			} catch (Exception e) {
				System.out.println("qewqeqw" + e.toString());
			}
		}
	}

}
