package com.design.zipcode;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

/*
 * A a = new A();
 * A a = null;
 * a = new A();
 * 
 * A a = A.getInstance();
 * 
 */
public class MyBatisZipcodeDao {
	SqlSessionFactory	sqlSessionFactory	= null;
	public MyBatisZipcodeDao() {
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		System.out.println("sqlSessionFactory : " + sqlSessionFactory);
	}
	public List<ZipcodeVO> getZipcodeList(ZipcodeVO pzVO) {
		System.out.println("getZipcodeList 호출 성공 " + pzVO);
		List<ZipcodeVO>	zipcodeList	= new ArrayList<ZipcodeVO>();
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			zipcodeList = sqlSession.selectList("refreshData", pzVO);
			System.out.println(zipcodeList.size());
		}
		catch (Exception e) {
			System.out.println("[[Exception]]" + e.toString());
		}
		finally {
			sqlSession.close();
		}
		return zipcodeList;
	}

	public static void main(String args[]) {
		MyBatisZipcodeDao zcd = new MyBatisZipcodeDao();
		List<ZipcodeVO>	zipcodeList	= new ArrayList<ZipcodeVO>();
		ZipcodeVO pzVO = new ZipcodeVO();
		pzVO.setDong("공덕동");
		zipcodeList = zcd.getZipcodeList(pzVO);
		for(ZipcodeVO rzVO : zipcodeList) {
			System.out.println("rzVO : " + rzVO.getAddress() + ", " + rzVO.getZipcode() + ", " + rzVO.isChkBox());
		}
	}
}
