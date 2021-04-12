package UI.hanbit;
//내 생각을 표현하는데 장애가 있지 않도록..... 불편하지 않도록 코딩연습을 해야 한다.
//어디까지 허용되는가? 어떤것이 허용되지 않는것인가? 등등에 대한 기준을 잡자
import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;

public class BookManager extends JFrame {
	Logger logger = LogManager.getLogger(BookManager.class);
	//선언부
	JFrame jf = new JFrame();//new Window()
//	static JFrame bm = new BookManager(); //new JFrame()
//	static BookManager bm2 = new BookManager();
	static BookManager bm3 = null;
	//생성자
	public BookManager() {
//		bm.initDisplay();
//		jf.initDisplay();
//		initDisplay();
		//this - BookManager / super - JFrame
//		this.setSize(500, 400);
//		bm3.setSize(600, 700);
		this.setSize(600, 700);		
		//우리는 setVisible에 대해서 오버라이딩을 하지 않았다. 따라서 부모의 메소드가 호출된다.
//		bm3.setVisible(true);
		this.setVisible(true);
	}
	//화면처리부
	public void initDisplay() {
		logger.info("initDisplay() 호출");
	}
	//메인메소드
	public static void main(String[] args) {
//		System.setProperty(XmlConfigurationFactory.CONFIGURATION_FILE_PROPERTY
//				,"C:\\workspace80\\210216\\210215-master\\210215-master\\log4j.xml");
		bm3 = new BookManager();
		bm3.initDisplay();
	}
}
