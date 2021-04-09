package book.ch12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vo.DeptVO;

//화면 처리하기 - 출력
//데이터 마이그레이션 업무
//데이터 수집 - 빅데이터, 챠트를 이용한 화면처리
public class DeptList extends JFrame implements ActionListener {
	//선언부
	JButton jbtn_search = new JButton("조회");
	String cols[] = {"부서번호", "부서명", "지역"};
	//DataSet선언
	DefaultTableModel 	dtm = null;
	JTable 				jtb = null;
	JScrollPane			jsp = null;
	//생성자
	public DeptList() {//인스턴스화 될때 화면이 즉시 그려지도록
		initDisplay();
	}
	public void tableCreate() {
		dtm = new DefaultTableModel(new Object[3][3],cols);
		jtb = new JTable(dtm);
		jsp = new JScrollPane(jtb);
		this.add("Center", jsp);
	}
	//데이터 수집하기1
	public List<Map<String,Object>> getDeptList(){
		System.out.println("getDeptList(List<Map>) 실행");
		List<Map<String,Object>> deptList = new ArrayList<>();
		Map<String,Object> r1 = new HashMap<>();
		r1.put("deptno", 10);
		r1.put("dname", "인사부");
		r1.put("loc", "서울");
		deptList.add(r1);
		r1 = new HashMap<String, Object>();
		r1.put("deptno", 20);
		r1.put("dname", "총무부");
		r1.put("loc", "인천");
		deptList.add(r1);
		r1 = new HashMap<String, Object>();
		r1.put("deptno", 30);
		r1.put("dname", "개발부");
		r1.put("loc", "제주");
		deptList.add(r1);
		return deptList;
	}
	//데이터 수집하기2
	public List<DeptVO> getDeptList2(){
		System.out.println("getDeptList2(List<DeptVO>) 실행");
		return null;
	}
	//화면처리부
	public void initDisplay() {
		jbtn_search.addActionListener(this);
		this.add("North",jbtn_search);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		tableCreate();//메소드 호출도 동기화가 필요하다. - 시점문제
		this.setTitle("부서목록");
		this.setSize(400, 300);
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		new DeptList();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(jbtn_search == ae.getSource()); {
			List<Map<String,Object>> deptList = getDeptList();
			Iterator<Map<String,Object>> iter = deptList.iterator();
			Object keys[] = null;
			for(int i = dtm.getRowCount()-1; i >=0; i--) {
				dtm.removeRow(i);
			}
			while(iter.hasNext()) {
				Map<String, Object> data = iter.next();
				keys = data.keySet().toArray();
				Vector onerow = new Vector();
				onerow.add(data.get(keys[2]));
				onerow.add(data.get(keys[1]));
				onerow.add(data.get(keys[0]));
				dtm.addRow(onerow);
			}
		}
	}

}
