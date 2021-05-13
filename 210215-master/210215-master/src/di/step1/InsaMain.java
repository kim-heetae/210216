package di.step1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsaMain {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
									("di\\step1\\insaBean.xml");
		InsaList insaList = (InsaList)context.getBean("insa"/*해당bean의 id값*/);
		InsaMap mapBean = (InsaMap)context.getBean("insaMap"/*해당bean의 id값*/);
		System.out.println("mapBean : " + mapBean);
		System.out.println(insaList);
		System.out.println(insaList.insaBean);
		for(String s : insaList.insaBean) {
			System.out.println(s);
		}
		
		InsaList insaList2 = new InsaList();
		System.out.println(insaList2);
		System.out.println(insaList2.insaBean);
	}

}
