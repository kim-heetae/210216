package mybatis.step1;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BookDao {
	String resource = "mybatis/step1/MapperConfig.xml";
	//SqlSessionFactory를 통하여 xml문서의 정보를 읽어서 커넥션을 얻어내는데 사용함.
	SqlSessionFactory sqlMapper = null;//connection을 맺을때 필요
	
	public List<Map<String, Object>> getBookList(){
		List<Map<String, Object>> bookList = null;
		SqlSession session = null;//sql문을 처리하기 위해 필요, 물리적으로 떨어져있는 서버에 인증받고 커밋과 롤백을 할수 있음.
		//slqsessiondml autocommit메소드의 default값이 false. con.autocommit은 default값이 true 
		//insert, update, delete의 경우 트래내잭션 처리이므로
		//commit, rollback이 필요(con.commit이 아닌 sqlsession.commit을 해야 커밋반영)
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMapper.openSession();
//			session = sqlMapper.openSession(true); - autocommit옵션
//			String currentTime = session.selectOne("currentTime");
			List<Object> currentTime = null;
//			currentTime.addAll(session.selectList("currentTime"));
			currentTime = session.selectList("currentTime");
			bookList = session.selectList("currentTime");
//			System.out.println("currentTime => " + currentTime);
			for(Object a : currentTime) {
				System.out.println(a);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	public static void main(String[] args) {
		BookDao bDao = new BookDao();
		List<Map<String, Object>> bookList = null;
		bookList = bDao.getBookList();
//		for(Object q : bookList) {
			System.out.println(bookList);
//		}
	}

}
