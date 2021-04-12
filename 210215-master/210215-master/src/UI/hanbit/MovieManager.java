package UI.hanbit;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovieManager extends JFrame {
	MovieWest mw = new MovieWest();
	JPanel jp_west = new JPanel();
	JPanel jp_center = new JPanel();
	
	public void initDisplay() {
		jp_west.setBackground(Color.green);
		jp_center.setBackground(Color.orange);
//		jp_west.add(mw);
		jp_west = mw;
		this.add("West", jp_west);
		this.add("Center", jp_center);
		this.setSize(900, 700);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MovieManager mm = new MovieManager();
		mm.initDisplay();
	}

}
