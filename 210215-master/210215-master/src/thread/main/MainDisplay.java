package thread.main;

import javax.swing.JFrame;

public class MainDisplay extends Thread {
	JFrame jf = null;
	public void initDisplay() {
//		try {
//			sleep(5000);
			System.out.println("initDisplay 호출 성공");
			jf = new JFrame();
			jf.setTitle("화면 출력");
			jf.setSize(500, 300);
			jf.setVisible(true);
//		}
////		catch (Exception e) {
//		}
	}
	
	public void run() {
		System.out.println("run 호출 성공");
		try {
			sleep(5000);
			for(double d = 0; d < 100; d++) {//지연시키기 위한 반복문
				System.out.println("d =============> " + d);
				if(jf!=null) {
					jf.setTitle("run메소드 경유");
					jf.revalidate();
				}
			}
		}
		catch (InterruptedException e) {
			System.out.println(e.toString());
		}
	}
	
	public static void main(String[] args) {
		MainDisplay md = new MainDisplay();
		md.initDisplay();
		md.start();
	}

}
