package thread.main;

import java.awt.event.*; 
import javax.swing.*; 

public class MultiThreadProgressEx extends JPanel 
	implements ActionListener{ 
	private JProgressBar progressBar1,progressBar2; 
	private JButton startButton; 
	public MultiThreadProgressEx() { 
		startButton = new JButton("Start"); 
		startButton.addActionListener(this); 
		progressBar1 = new JProgressBar(0, 1000);
		progressBar2 = new JProgressBar(0, 1000);
		
		progressBar1.setValue(0); 
		progressBar1.setStringPainted(true); 
		progressBar2.setValue(0); 
		progressBar2.setStringPainted(true); 
		
		JPanel panel = new JPanel(); 
		panel.add(startButton); 
		panel.add(progressBar1); 
		panel.add(progressBar2); 
		add(panel); 
		setBorder(BorderFactory.createEmptyBorder(
				20, 20, 20, 20)); 		
	} 
	
	public void actionPerformed(ActionEvent evt) { 
		//버튼을 클릭하면 버튼을 비활성화 한다.
		startButton.setEnabled(false); 
		//첫번째 JProgressBar를 위한 스레드 생성
		ProgressBarThread p1 = new ProgressBarThread(
				progressBar1,startButton);
		//두번째 JProgressBar를 위한 스레드 생성
		ProgressBarThread p2 = new ProgressBarThread(
				progressBar2,startButton);
		//두 개의 스레드를 시작하면 스레드 스케쥴러에 의해 제어권을 서로 주고 받으며
		//JProgressBar를 진행하게 된다.
		p1.start();
		p2.start();
	} 
	
	
	public static void main(String[] args) { 
		JFrame.setDefaultLookAndFeelDecorated(true); 
		JFrame frame = new JFrame("MultiThreadProgressEx"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		MultiThreadProgressEx pbd = new MultiThreadProgressEx();
		frame.add(pbd); 
		frame.pack(); 
		frame.setVisible(true);
	} 
} 
class ProgressBarThread extends Thread{
	private JProgressBar jpb;
	private JButton jb;
	public ProgressBarThread(JProgressBar jpb,JButton jb){
		this.jpb = jpb;
		this.jb = jb;
	}
	public void run(){
		int current =0;
		//JProgressBar의 최대값이 1000이므로 1000이상일 때는 스레드를 종료해야 한다.
		while(current <= 1000){
			//0이상 99이하의 임의의 값을 구하여 current 변수에 계속 저장한다.
			current += Math.random() * 100; 
			jpb.setValue(current);
			try{
				//두 개의 스레드가 서로 번갈아 가며 제어권을 가지기 위해 sleep메소드 사용함.
				sleep(100);
			}catch(InterruptedException e){
			}
		}
		jb.setEnabled(true); 
	}
}

