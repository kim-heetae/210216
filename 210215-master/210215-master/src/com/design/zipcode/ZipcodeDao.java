package com.design.zipcode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.util.DBConnectionMgr;
/*
 * A a = new A();
 * A a = null;
 * a = new A();
 * 
 * A a = A.getInstance();
 * 
 */
public class ZipcodeDao {
	Connection 			con		= null;
	PreparedStatement 	pstmt 	= null;
	ResultSet 			rs 		= null;
	DBConnectionMgr 	dbMgr 	= null;
	public ZipcodeDao() {
		dbMgr = DBConnectionMgr.getInstance();
		try {
			con = dbMgr.getConnection();
		} catch (Exception e) {
			System.out.println("오라클 서버 연결 실패");
		}
	}
	/******************************************************************************
	 * 쿼리문
	 * select '전체' zdo from dual
		union all
		select distinct(zdo) from zipcode_t order by zdo asc
	 * @return String[]
	 * 전체, 경기, 강원, 경북.......
	 */
	public String[] getZdoList() {
		//원격에 있는 오라클 서버에 접속하기 위해 DBConnectionMgr객체 생성하기
		//콤보박스에 도에 대한 정보 가져오기
		String zdos[] = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select '전체' zdo from dual");
		sql.append(" union all");
		sql.append(" select distinct(zdo) from zipcode_t order by zdo asc");
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			while(rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			for(String zdo1 : v) {
				System.out.println(zdo1);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
		} catch (SQLException se) {
			System.out.println("[[query]] : " + sql.toString());
		} catch (Exception e) {
			System.out.println("Exception : " + e.toString());
		} finally {
			//사용한 자원 반납하기
			//이걸 상습적으로 안하면 오라클에서 세션을 닫아버린다. - 자바 튜닝관리팀의 권장사항
			//닫아줄 때는 열린것의 역순으로 닫아준다.
			/*
			 * con
			 * pstmt = con.prepaerdStatement();
			 * rs = pstmt.executeQuery();
			 */
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return zdos;
	}
	//클래스 쪼개기에서 초급자가 항상 염두에 둘 사항은 배달사고임.
	public ArrayList<ZipcodeVO> getZipcodeList(String dong){
		System.out.println("getZipcodeList 호출 성공 " + dong);
		ArrayList<ZipcodeVO> zipcodeList = new ArrayList<ZipcodeVO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select  ");
		sql.append(" zipcode, address");
	    sql.append(" from zipcode_t ");
	    sql.append(" where dong like ?||'%'");
	    try {
	    	con = dbMgr.getConnection();
	    	pstmt = con.prepareStatement(sql.toString());
	    	pstmt.setString(1, dong);
	    	rs = pstmt.executeQuery();
	    	ZipcodeVO zcVO = null;
	    	while(rs.next()) {
	    		zcVO = new ZipcodeVO();
	    		zcVO.setZipcode(rs.getInt("zipcode"));
	    		zcVO.setAddress(rs.getString("address"));
	    		zipcodeList.add(zcVO);
	    	}
	    } catch(SQLException se) {
	    	System.out.println("[[query]]" + sql.toString());
	    	System.out.println("[[SQLException]]" + se.toString());
		} catch (Exception e) {
			System.out.println("[[Exception]]" + e.toString());			
		}
		return zipcodeList;
	}
	public static void main (String args[]) {
		ZipcodeDao zcd = new ZipcodeDao();
		zcd.getZdoList();
//		zcd.getZipcodeList("가산동");
		ArrayList<ZipcodeVO> zipcodeList = zcd.getZipcodeList("가산동");
		for(ZipcodeVO zcVO : zipcodeList) {
			System.out.println(zcVO.getAddress() + " , " + zcVO.getZipcode());
		}
	}
}
