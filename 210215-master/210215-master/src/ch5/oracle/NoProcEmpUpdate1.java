package ch5.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.util.DBConnectionMgr;

import oracle.jdbc.OracleConnection.CommitOption;

public class NoProcEmpUpdate1 extends JFrame {
	Connection con1 			= null;
	Connection con2 			= null;
	Connection con3 			= null;
	PreparedStatement pstmt1 	= null;
	PreparedStatement pstmt2 	= null;
	PreparedStatement pstmt3 	= null;
	ResultSet rs1 				= null;
	ResultSet rs2 				= null;
	String sql1 				= "";
	String sql2 				= "";	
	String sql3 				= "";	
	DBConnectionMgr dbMgr 		= null;
	public void salUpdate(int p_empno) {
		String r_ename 			= null;
		double r_sal 			= 0.0;
		double r_avg_sal 		= 0.0;
		int result 				= 0;//0이면 수정실패 , 1이면 수정 성공
		double v_rate			= 0.0;
		sql1 += "SELECT ename, sal ";
		sql1 += "FROM emp ";
		sql1 += "WHERE empno = ?";
//		sql1 += "WHERE empno =" + p_empno;
		sql2 += "SELECT avg(sal) sal FROM emp";
		sql2 += " WHERE deptno = (SELECT deptno FROM emp WHERE empno = ?)";
//		sql2 += "WHERE deptno = (SELECT deptno FROM emp WHERE empno = " + p_empno+ ")";
		sql3 += "UPDATE emp SET sal = ? WHERE empno = ?";
//		sql3 += "UPDATE emp SET sal = ? WHERE empno =" + p_empno;
		dbMgr = DBConnectionMgr.getInstance();
		try {
			con1 = dbMgr.getConnection();
			pstmt1 = con1.prepareStatement(sql1);
			pstmt1.setInt(1, p_empno);
			rs1 = pstmt1.executeQuery();
			rs1.next();
			r_ename = rs1.getString("ename");
			r_sal = rs1.getDouble("sal");
			System.out.println("ename"  + "\t" + r_ename  + "\t" + "sal"  + "\t" + r_sal);
			dbMgr.freeConnection(con1, pstmt1, rs1);
			
			con2 = dbMgr.getConnection();
			pstmt2 = con2.prepareStatement(sql2);
			pstmt2.setInt(1, p_empno);
			rs2 = pstmt2.executeQuery();
			rs2.next();
			r_avg_sal = rs2.getDouble("sal");
			System.out.println("부서 평균 급여는 " + "\t" + r_avg_sal);
			if(r_sal > r_avg_sal) {
				v_rate = 1.1;
			}
			else {
				v_rate = 1.2;
			}			
			dbMgr.freeConnection(con2, pstmt2, rs2);
			
			con3 = dbMgr.getConnection();
			pstmt3 = con3.prepareStatement(sql3);
			pstmt3.setDouble(1, r_sal * v_rate);
			pstmt3.setInt(2, p_empno);
			result = pstmt3.executeUpdate();
			con3.setAutoCommit(false);
			System.out.println("result : " + result);
			if(result == 1) {
				JOptionPane.showMessageDialog(this, "수정이 되었습니다");
			}
			else {
				JOptionPane.showMessageDialog(this, "실패하였습니다");
			}
			dbMgr.freeConnection(con3, pstmt3);
		} catch (SQLException se) {
			System.out.println("[[sql1]]" + sql1);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public static void main(String[] args) {
		NoProcEmpUpdate1 npeu = new NoProcEmpUpdate1();
		String user_input = JOptionPane.showInputDialog("사원번호를 입력하세요");
		int empno = 0;
		if(user_input != null || user_input.length() > 1) {
			empno = Integer.parseInt(user_input);
		}
		npeu.salUpdate(empno);
	}

}
