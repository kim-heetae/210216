package com.vo;

public class Member89VO {
	private String mem_id  = null;
	private String mem_pw  = null;
	private boolean gender  = false;
	/*
	 * 생성자는 반환타입이 없다.
	 * 클래스 이름과 동일해야함
	 * 전역변수의 초기화를 담당
	 * static블록에서 하는일을 맡겨도 괜찮다.
	 * 만일 소켓 통신을 통해서 서버사이드와 클라이언트 사이트 구형(구축)할 때 중요
	 *  -> 메소드 오버로딩
	 * 메소드 오버로딩
	 * 전제조건 - 모두 같은 이름이다. 다른이름이라면 해당이 없다
	 * 접근제한자가 있고 없고는 영향이 없다
	 * 리턴타입이 있고 없고는 영향이 없다. - 생성자는 해당없음 - void가 들어오면 메소드이다 - 생성자라고 할 수 없다
	 * 예외를 던지고 그렇지 않고는 영향이 없다.
	 * void go() throws Exception, SQLException{}
	 * 
	 */
	public Member89VO() {	}//디폴트 생성자
	public Member89VO(String mem_id){//파라미터가 있는 생성자
		this.mem_id = mem_id;
	}
	public Member89VO(String mem_id, String mem_pw){//파라미터가 있는 생성자
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
	}
	public Member89VO(String mem_id, String mem_pw, boolean gender){//파라미터가 있는 생성자
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.gender = gender;
	}
		public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
}
