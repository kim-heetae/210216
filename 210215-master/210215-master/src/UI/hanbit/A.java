package UI.hanbit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;
class AA extends Test1 implements ActionListener {
	Test1 t1 = new Test1();
	public AA(){
		logger.info("AA생성자 실행");
	}
	public void test() {
		logger.info("AA의 test실행");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}
class Test1{
	Logger logger = LogManager.getLogger(AA.class);
	public Test1() {
		logger.info("Test1 생성자호출");
	}
}
public class A extends AA {
	public A() {
		logger.info("A의 생성자 실행");
		super.test();
		test();
	}
	public void initDisplay() {
//		new AA();
	}
	public void test() {
		logger.info("A의 test실행");
	}
	public static void main(String[] args) {
		System.setProperty(XmlConfigurationFactory.CONFIGURATION_FILE_PROPERTY
				,"C:\\workspace80\\210216\\210215-master\\210215-master\\log4j.xml");
		new A();
	}
}
