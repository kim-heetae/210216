package book.ch14;

public class UserException extends Exception {
	private int port = 7000;
	public UserException() {}
	public UserException(String msg) {
		super(msg);//super는 Exception을 뜻함.
	}
	public UserException(String msg, int port) {
		super(msg);//super는 Exception을 뜻함.
		//부모클래스에는 생성자 파라미터에 두번째 자리에 int인 생성자가 없다. -- Exception클래스의 생성자에는 두번째 파라미터로 int를 받는 생성자가 없다.
//		super(msg, port);//불가능
	}
	public int getPort() {
		return port;
	}
}
