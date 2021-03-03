package ch5.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vo.EmpVO;

/*
 * 물리적으로 떨어져있는 192.168.0.24번 서버에 접속하고 한다.
 * 서버 컴퓨터의 오라클제품에 접속하려면 해당 회사가 제공하는 드라이버 클래스가 있어야 한다
 * 따라서 우리는 ojdb6.jar를 주입받을 수 있도록 등록하였다.
 * 
 */
public class JdbcTest2 {
	//선언부
	static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String _URL 	= "jdbc:oracle:thin:@192.168.0.24:1521:orcl11";
	String 				_USER 	= "hit";
	String 				_PW 	= "tiger";
	//물리적으로 떨어져 있는 서버에 연결통로 만들기
	Connection 			con 	= null;
	//24번 서버에 내가 작성한 select 문을 전달해줄 객체 선언
	PreparedStatement 	pstmt 	= null;
	//오라클에 커서를 조작하는 객체선언
	ResultSet 			rs 		= null;
	//생성자
	public JdbcTest2() {
		String sql = "SELECT zipcode, address FROM zipcode_t";
		try {
			//오라클 드라이버 클래스 로딩하기
			Class.forName(JdbcTest._DRIVER);
			//연결통로확보하기
			con = DriverManager.getConnection(_URL, _USER, _PW);
			//오라클 서버에 select문을 전달할 전령객체 생성
			pstmt = con.prepareStatement(sql);
			//오라클에 살고있는 커서 조작을 위해서 자바가 제공하는 객체 생성
			rs = pstmt.executeQuery();
			EmpVO eVO = null;
			System.out.println("zipcode" + "\t" + "address");
			while(rs.next()) {
				eVO = new EmpVO();
				int 	rzipcode 	= rs.getInt("zipcode");
				String 	raddress 	= rs.getString("address");
				System.out.println(rzipcode + "\t" + raddress );
			}
		}catch(ClassNotFoundException ce) {
			System.out.println("드라이버 클래스 로딩 실패");
			return;
			
		}catch(SQLException se) {
			//부적합한 식별자 입니다.
			System.out.println("SQLExcption : " + se.getMessage());//좀 더 구체적인 예외처리 클래스 정보를 알수 있다.			
		}
		System.out.println("here");
	}
	//오라클 서버 접속
	public static void main(String[] args) {
		JdbcTest2 jt = new JdbcTest2();//생성자 호출도 동시에 일어납니다.
	}

}
