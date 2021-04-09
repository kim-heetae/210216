package book.ch6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;

class Outter{	
	Logger logger = LogManager.getLogger(OutterInnerTest.class);
	int i = 5;
	Outter(){
		System.out.println("Outter호출");
	}
	class Inner{
		int j = 10;
		public void go() {
			logger.info("go()");
		}
	}
	public void print() {
		logger.info("print()");
	}
}
public class OutterInnerTest {
	public static void main(String[] args) {
		System.setProperty
		(XmlConfigurationFactory.CONFIGURATION_FILE_PROPERTY,"C:\\workspace80\\210216\\210215-master\\210215-master\\log4j.xml");		
		Outter outter = new Outter();
		outter.print();
		Outter.Inner inner = outter.new Inner();
		inner.go();
	}

}
