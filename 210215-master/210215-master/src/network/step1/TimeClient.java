package network.step1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JLabel;

//import book.ch5.AddressBook2;
//import oracle.net.jdbc.TNSAddress.Address;

public class TimeClient extends Thread{
	String timeStr = null;
	JLabel jlb_time = null;
//	static AddressBook2 aBook = null;
	TimeClient(){
		
	}
	public TimeClient(JLabel jlb_time){
		this.jlb_time = jlb_time;
	}
	@Override
	public void run() {//콜백메소드 - 사용자가 아니라 시스템 레벨에서 자동으로 호출되는 메소드임 - start 함수 실행시 실행됨
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader br = null;
		boolean isFlag = false;
		try {
			socket = new Socket("192.168.0.23", 7375);//local port 7375
			//내 소켓에 대한 포트번호는 따로 할당된다
			out = new PrintWriter(socket.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			InputStream is = new InputStreamReader(socket.getInputStream());
			while(!isFlag) {
				while((timeStr = br.readLine()) != null) {
					System.out.println(timeStr);
					jlb_time.setText(timeStr);
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("?");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("실패");
		}
	}
//	public static void main(String[] args) {
//		TimeClient tc = new TimeClient();
//		tc.start();//run메소드 호출 해줌
//	}

}
