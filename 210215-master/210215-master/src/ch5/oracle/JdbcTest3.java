package ch5.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConnectionMgr;
import com.vo.EmpVO;

/*
 * 물리적으로 떨어져있는 192.168.0.24번 서버에 접속하고 한다.
 * 서버 컴퓨터의 오라클제품에 접속하려면 해당 회사가 제공하는 드라이버 클래스가 있어야 한다
 * 따라서 우리는 ojdb6.jar를 주입받을 수 있도록 등록하였다.
 * 
 */
public class JdbcTest3 {
	//선언부
	//물리적으로 떨어져 있는 서버에 연결통로 만들기
	Connection 			con 	= null;
	//24번 서버에 내가 작성한 select 문을 전달해줄 객체 선언
	PreparedStatement 	pstmt 	= null;
	//오라클에 커서를 조작하는 객체선언
	ResultSet 			rs 		= null;
	DBConnectionMgr dbMgr = null;
	//생성자
	public JdbcTest3() {
		String sql = "SELECT empno, ename, sal FROM emp";
		dbMgr = new DBConnectionMgr();
		try {
			//연결통로확보하기
			con = dbMgr.getConnection();
			//오라클 서버에 select문을 전달할 전령객체 생성
			pstmt = con.prepareStatement(sql);
			//오라클에 살고있는 커서 조작을 위해서 자바가 제공하는 객체 생성
			rs = pstmt.executeQuery();
			EmpVO eVO = null;
			System.out.println("empno" + "\t" + "ename" + "\t" + "sal");
			while(rs.next()) {
				eVO = new EmpVO();
				eVO.setEmpno(rs.getInt("empno"));
				eVO.setEname(rs.getString("ename"));
				eVO.setSal(rs.getDouble("sal"));
//				int 	rempno 	= rs.getInt("empno");
//				String 	rename 	= rs.getString("ename");
//				double 	rsal 	= rs.getDouble("sal");
				System.out.println(eVO.getEmpno() + "\t" + eVO.getEname() + "\t" + eVO.getSal());
			}
		}catch(SQLException se) {
			//부적합한 식별자 입니다.
			System.out.println("SQLExcption : " + se.getMessage());//좀 더 구체적인 예외처리 클래스 정보를 알수 있다.			
		}
		System.out.println("here");
	}
	//오라클 서버 접속
	public static void main(String[] args) {
		JdbcTest3 jt = new JdbcTest3();//생성자 호출도 동시에 일어납니다.
		
	}

}
