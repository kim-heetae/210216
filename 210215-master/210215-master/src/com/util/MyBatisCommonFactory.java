package com.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisCommonFactory {
	private static SqlSessionFactory sqlSessionFactory = null;
//	private SqlSession sqlSession = null;
	public static SqlSessionFactory getInstance() {
		if(sqlSessionFactory == null) {
			synchronized (SqlSessionFactory.class) {
				//동기화 블럭에 들어온 후에도 다시한번 널체크
				if(sqlSessionFactory == null) {				
					try {
						String resource = "mybatis/step1/MapperConfig.xml";
						Reader reader = Resources.getResourceAsReader(resource);
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return sqlSessionFactory;
	}
}
