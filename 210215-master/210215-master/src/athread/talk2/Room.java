package athread.talk2;

import java.util.List;
import java.util.Vector;

public class Room {
	private List<PotatoServerThread> 	userList = new Vector<>();
	private List<String>				nameList = new Vector<>();
	private String title = null;
	private String state = null;
	public List<PotatoServerThread> getUserList() {
		return userList;
	}
	public void setUserList(List<PotatoServerThread> userList) {
		this.userList = userList;
	}
	public List<String> getNameList() {
		return nameList;
	}
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
