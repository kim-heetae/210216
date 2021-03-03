package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionMgr {
	private final static String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String _URL 	= "jdbc:oracle:thin:@192.168.0.27:1521:orcl11";
	private final static String _USER 	= "scott";
	private final static String _PW 	= "tiger";
	static DBConnectionMgr dbMgr = null;
	Connection con = null;
	public static DBConnectionMgr getInstance() {
		if(dbMgr == null) {
			dbMgr = new DBConnectionMgr();
		}
		return dbMgr;
	}
	public Connection getConnection() {
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버 클래스를 찾을수 없습니다.");
		} catch (SQLException se) {
			System.out.println("SQL에 접속할 수 없습니다.");
		}
		return con;
	}
	//사용한 자원 반납하기
	//이것을 하지 않으면 오라클 서버에 접속할 때 세션 수의 제한 때문에 오라클 서버를 재기동 해야할 수도 있음.
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void freeConnection(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
