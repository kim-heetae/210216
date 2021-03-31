package di.step1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
/*
 * spring-core.jar는 IoC 를 제공하는 역할을 함.
 * IoC는 Inversion of Conversion의 약자임 - 번역하면 역제어 또는 제어 역행, 제어의 역흐름 이라고 한다.
 * 최근에 사용되는 모든 컨테이너들이 공통으로 사용하고 있는 개념이다.
 * 기존 방식
 * 자바 기반으로 어플리케이션을 개발할 때 자바 객페를 생성하고 서로간의 의존관계를
 * 연결시키는 작업에 대한 제어권은 보통 새발되는 어플리케이션에 있음.
 * 
 * 문제제기
 * 컴포넌트간의 결합도가 높아서 컴포넌트의 확장 및 재사용이 어려운 문제점 발생
 * 
 * 해결방법
 * IoC사용
 * 제어권이 Container에게 넘어가 객체의 생명주기를 Container가 전담하게 됨
 * 
 * 해결내용
 * 컴포넌트 간의 결합도가 낮아져 컴포넌트의 재사용 및 확장이 쉽고
 * 컴포넌트의 의존관계 변경이 쉬움.
 */
public class HelloMain {
	//ClassPathXmlApplicationContext는 ApplicationContext의 구현체 클래스임.
	//생성자의 파라미터로 xml문서를 스캔함
	//
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
					("di\\step1\\helloBean.xml");
		ApplicationContext context2 = 
				new ClassPathXmlApplicationContext
									("di\\step1\\sonataBean.xml");
		Sonata himCar = (Sonata)context2.getBean("himCar");
		Sonata herCar = (Sonata)context2.getBean("herCar");
		Resource resource = new FileSystemResource("C:\\workspace80\\210216\\210215-master\\210215-master\\src\\di\\step1\\helloBean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		HelloBean helloBean = (HelloBean)context.getBean("helloBean222");
		HelloBean helloBean2 = (HelloBean)factory.getBean("helloBean222");
		System.out.println(helloBean.getGreeting("hi"));
		System.out.println(helloBean2.getGreeting("hi"));
	}

}
