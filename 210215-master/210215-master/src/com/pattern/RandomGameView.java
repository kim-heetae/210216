package com.pattern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class RandomGameView implements ActionListener{
	//선언부
	//동쪽에 붙일 속지 선언 및 생성
	JPanel jp_east = new JPanel();//안드로이드에서 Fragment
	JButton jbtn_new = new JButton("새게임");
	JButton jbtn_clear = new JButton("지우기");
	JButton jbtn_dap = new JButton("정답");
	JButton jbtn_exit = new JButton("종료");
	//중앙에 그려질 속지 선언 및 생성
	JTextArea jta_display = new JTextArea(7, 20);
	JScrollPane jsp_display = new JScrollPane(jta_display,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//남쪽에 그려질 속지 선언 및 생성 - 여기에는 버튼 10개를 붙임. 
	JPanel jp_south = new JPanel();
	JButton jbtns[] = new JButton[10];//방만 만듬
	//참조형 타입의 초기화는 null로 할수 있다.
	JButton jbtn = null;
	//문자열을 담을 수 있는 방 10개를 만들고 숫자를 0~9까지 초기화하였음
	String nums_label[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	//생성자
	
	//화면처리부
	public void initDisplay() {
		jbtn_exit.addActionListener(this);
		JFrame jf = new JFrame();
		jp_south.setLayout(new GridLayout(1, 10, 2, 2));
		jp_east.setLayout(new GridLayout(4, 1, 2, 2));
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_exit);
		
		for(int i = 0; i < jbtns.length; i++) {
			jbtn = new JButton(nums_label[i]);
			jp_south.add(jbtn);
			jbtns[i] = jbtn;
			jbtn.addActionListener(this);
		}
		jp_east.setBackground(Color.blue);
		jp_south.setBackground(Color.darkGray);
		//JFrame의 배치 레이아웃을 정함
		jf.setLayout(new BorderLayout());
		jf.add("East", jp_east);
		jf.add("Center", jsp_display);
		jf.add("South", jp_south);
		jf.setSize(700, 500);
		jf.setVisible(true);
	}
	
	//메인메소드
	public static void main(String[] args) {
		RandomGameView rgView = new RandomGameView();
		rgView.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command + " , " + e.getSource());
		if(e.getSource() == jbtn_exit) {
			System.exit(0);
		}
//		else if (e.getSource() == jbtns[5]){
		else if ("5".equals(command)){
			jta_display.append(command);
		}
	}

}
