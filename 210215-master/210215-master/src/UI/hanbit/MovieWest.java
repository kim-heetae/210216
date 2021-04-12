package UI.hanbit;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovieWest extends JPanel{
	JButton jbtn_login = new JButton("로그인");
	JButton jbtn_search = new JButton("영화검색");
	JButton jbtn_res = new JButton("영화예매");

	public MovieWest() {
		initDisplay();
	}
	
	public void initDisplay() {
		this.setLayout(new GridLayout(3,1,3,3));
		this.add(jbtn_login);
		this.add(jbtn_search);
		this.add(jbtn_res);
		this.setPreferredSize(new Dimension(300,700));
	}
}
