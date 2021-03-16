package com.design.zipcode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.util.DBConnectionMgr;

public class ZipcodeSearchConsole {
	//선언부
	String zdo = null;
	//생성자
	public ZipcodeSearchConsole() {
		userInput();
	}
	//조회된 우편번호 출력하기
	public void printZipcode(ArrayList<ZipcodeVO> zipCode) {
		for(ZipcodeVO zcVO: zipCode) {
			System.out.println(zcVO.getAddress() + ", " + zcVO.getZipcode());
		}
	}
	
	//사용자로부터 동을 입력받는 메소드를 구현하시오 - dos창에서 입력받는다.
	public String userInput() {
		String userDong = null;
		Scanner sc = new Scanner(System.in);
		userDong = sc.next();
		return userDong;
	}
	
	//메인메소드
	public static void main(String[] args) {
		System.out.println("동을 입력하세요");
		String userDong = null;
		ZipcodeSearchConsole zcs = new ZipcodeSearchConsole();
		userDong = zcs.userInput();
		ZipcodeDao zcDao = new ZipcodeDao();
		ArrayList<ZipcodeVO> al = zcDao.getZipcodeList(userDong);
		zcs.printZipcode(al);
	}
	public void refreshData(String zdo, String dong) {
		System.out.println("zdo:"+zdo+", dong:"+dong);
		try {
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
}
