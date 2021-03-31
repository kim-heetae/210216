package di.step1;

public class HelloBeanImpl implements HelloBean {
	private String msg333 = null;
	//아래 코드는 객체 생성을 내가 관리해야함.
	String name = new String("SCOTT");
	//setter객체 주입법이다. (자바코드 적용) - default
	//생성자 객체 주입법(xml코드)
	//setter메소드로 사용하는 것은 객체 생성 및 관리를 스프링에서 해줌.
	public void setMsg333(String msg) {
		this.msg333 = msg;
	}
	//msg = new String("안녕"); 이런 코드 x
	@Override
	public String getGreeting(String msg) {
		return "Spring " + this.msg333;
	}
	//Bean이 초기화 된 후 호출되는 메소드
	public void initMethod() {
		System.out.println("initMethod 호출 성공");
	}
	//Bean이 소멸되기 전에  호출되는 메소드
	public void destroyMethod() {
		System.out.println("destroyMethod 호출 성공");
	}

}
