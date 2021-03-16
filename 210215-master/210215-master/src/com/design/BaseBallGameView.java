package com.design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGameView {
	//컴파일 타임에 인스턴스화 하기 - 이른 인스턴스화(멀티스레드에서 안전하지 못함, 메모리 문제)
	//파라미터를 갖는 생성자가 한개라도 있으면 어떠한 생성자도 제공하지 않음
	////////////메뉴바 추가하기 ///////////////
	JMenuBar jmb        = new JMenuBar();
	JMenu    jm_game    = new JMenu("게임(G)");
	JMenuItem  jmi_new  = new JMenuItem("게임시작");
	JMenuItem  jmi_dap  = new JMenuItem("정답");
	JSeparator js_game = new JSeparator();
	JMenuItem  jmi_exit = new JMenuItem("나가기");
	JMenu    jm_about   = new JMenu("도움말(H)");
	JMenuItem jmi_info  = new JMenuItem("야구숫자게임이란?");
	JMenuItem jmi_maker = new JMenuItem("만든사람들");
	///////////   메뉴바 추가하기 ///////////////
	JOptionPane jop   = new JOptionPane();
	JFrame jf         = new JFrame();
	JPanel jp_center  = new JPanel();//동서남북중앙
	JPanel jp_east    = new JPanel();//버튼4개 GridLayout(4,1)
	JTextArea jta_display = new JTextArea();
	JScrollPane jsp_display = new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextField jtf_input = new JTextField();
	String[] jbtns_label = {"새게임","정답","지우기","종료"};
	JButton[] jbtns = new JButton[4];
	//JTexaArea에 순번 출력하기
	int cnt = 0;
	//만든이들 다이얼로그 닫기 버튼추가
	JButton jbtn_close = null;	
	BaseBallGameLogic bbgLogic = new BaseBallGameLogic();
	BaseBallGameEvent bbgEvent = new BaseBallGameEvent(this, bbgLogic);
	
	//화면처리하기
	public void initDisplay(){
		jm_game.add(jmi_new);
		jm_game.add(jmi_dap);
		jm_game.add(js_game);
		jm_game.add(jmi_exit);
		jm_about.add(jmi_info);
		jm_about.add(jmi_maker);
		jmb.add(jm_game);
		jmb.add(jm_about);
		//JFrame에 JMenuBar설정
		jf.setJMenuBar(jmb);
		jm_game.setMnemonic('G');
		jta_display.setEditable(false);
		jp_center.setLayout(new BorderLayout());
		jp_east.setLayout(new GridLayout(4,1,2,2));
		jp_center.setBackground(Color.green);
		jp_east.setBackground(Color.yellow);
		for(int i=0;i<4;i++){
			jbtns[i] = new JButton(jbtns_label[i]);
			System.out.println(jbtns[i]);//@abc1234
			jp_east.add(jbtns[i]);
			jbtns[i].addActionListener(bbgEvent);
		}
		//이벤트소스와 이벤트핸들러 클래스 매핑 코드
		jtf_input.addActionListener(bbgEvent);
		Font myFont = new Font("Thoma",Font.BOLD,12);
		jbtns[0].setFont(myFont);
		//Color newColor = new Color(158,9,9);
//		jbtns[0].setBackground(newColor);
		jbtns[0].setBackground(new Color(158,9,9));
		jbtns[0].setForeground(new Color(212,212,212));
		jbtns[1].setBackground(new Color(7,84,170));
		jbtns[1].setForeground(new Color(212,212,212));
		jbtns[2].setBackground(new Color(19,99,57));
		jbtns[2].setForeground(new Color(212,212,212));
		jbtns[3].setBackground(new Color(54,54,54));
		jbtns[3].setForeground(new Color(212,212,212));
		jta_display.setBackground(new Color(255,255,200));
		jta_display.setForeground(new Color(57,109,165));
		int width = 400;
		int height = 300;
		boolean isVisible = true;
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_input);
		jf.add("Center",jp_center);
		jf.add("East",jp_east);
		//화면이 열리면서 JTextField쪽에 커서가 깜박이기.
		jtf_input.requestFocus();
		jf.setTitle("야구숫자게임2");
		jf.setSize(width, height);
		jf.setVisible(isVisible);
	}
	
	public static void main(String[] args) {
		BaseBallGameView bbgView = new BaseBallGameView();
		bbgView.initDisplay();
	}
}
