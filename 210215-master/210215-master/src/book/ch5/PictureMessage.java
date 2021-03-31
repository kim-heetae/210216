package book.ch5;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PictureMessage {
	String imgPath = "C:\\workspace80\\210216\\210215-master\\210215-master\\src\\book\\ch5\\";
	JPanel jp_emoticon = new JPanel();
	GridLayout gl_emoticon = new GridLayout(1,5,2,2);
	JButton pic0 = new JButton();
	JButton pic1 = new JButton();
	JButton pic2 = new JButton();
	JButton pic3 = new JButton();
	JButton pic4 = new JButton();
	String imgFile[] = {"lion11.png", "lion22.png", "lion33.png", "lion44.png", "lion55.png"};
	JButton imgButton[] = {pic0, pic1, pic2, pic3, pic4};
	
	public void initDisplay() {
		
	}
	
	
	public static void main(String[] args) {
		
	}

}
