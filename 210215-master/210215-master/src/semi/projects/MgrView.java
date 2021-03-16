package semi.projects;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class MgrView extends JFrame implements MouseListener ,KeyListener{
	JTextArea 			jta 		= new JTextArea();
	JTextField 			jtf 		= new JTextField();
	JLabel 				jlb 		= new JLabel("KOSMO 문고");
	JButton 			jbtn_sel	= new JButton("검색");
	JButton 			jbtn_ins	= new JButton("추가");
	JButton 			jbtn_del 	= new JButton("삭제");
	JButton 			jbtn_back	= new JButton("이전");
	String[] 			combo 		= { "도서명", "도서번호", "저자", "출판사" };
	JComboBox<String> jcb = new JComboBox<String>(combo);
	String cols[] = { "도서번호", "분류", "도서명", "저자", "출판사", "출간일", "판매가격", "원가", "재고", "위치", "판매량", "이익" };
	String data[][] = new String[0][12];
	DefaultTableModel dtm_book = new DefaultTableModel(data, cols) 
	{
		public boolean isCellEditable(int rowindex, int mcolindex) {
		return false;
		}
	};
//	JTable jtb_book = new JTable(dtm_book);
	JTable jtb_book = new JTable();
	JScrollPane jsp_book = new JScrollPane(jtb_book, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
										 , JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	TableColumnModel tcm = jtb_book.getColumnModel();
	Font myfont = new Font(null, Font.BOLD, 50);
//	JScrollPane			jsp 		= new JScrollPane(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	BookVO bVO = null;
	DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	static LoginView lv = null;
	static MgrView mv = null;
	EditView ev = null;
	StringBuffer sql = new StringBuffer();
	Vector<BookVO> vecbook = null;
	String oldbooknum = null;
	public MgrView() {
		loading();
		initDisplay();
	}

	public void initDisplay() {
		this.setResizable(false);
		jlb.setFont(myfont);
		jlb.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
		jtb_book.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.getContentPane().setLayout(null);
		jbtn_back.addMouseListener(this);
		jtb_book.addMouseListener(this);
		jbtn_sel.addMouseListener(this);
		jbtn_ins.addMouseListener(this);
		jlb.addMouseListener(this);
		jtf.addKeyListener(this);
		jbtn_del.addMouseListener(this);
		jtb_book.getTableHeader().setReorderingAllowed(false);
		jlb.setBounds(500, 50, 400, 60);
		jcb.setBounds(50, 140, 100, 20);
		jtf.setBounds(160, 140, 980, 20);
		jbtn_sel.setBounds(1150, 140, 100, 20);
		jbtn_ins.setBounds(670, 850, 180, 50);
		jbtn_del.setBounds(870, 850, 180, 50);
		jbtn_back.setBounds(1070, 850, 180, 50);
		jsp_book.setBounds(50, 170, 1200, 630);
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		resizeCoulumnWidth(jtb_book);
		this.add(jlb);
		this.add(jcb);
		this.add(jtf);
		this.add(jbtn_sel);
		this.add(jbtn_ins);
		this.add(jbtn_del);
		this.add(jbtn_back);
		this.add("Center", jsp_book);
		this.setSize(1300, 1000);
		this.setTitle("관리자 페이지");
		this.setVisible(true);
		jtf.grabFocus();
		loading();
	}
	
	public void resizeCoulumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for(int column = 0; column < table.getColumnCount(); column++) {
			int width = 50;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width+1, width);
			}
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
	
	public void loading() {
		sql.setLength(0);
		sql.append("SELECT m.booknum, m.class, m.bookname, m.author, m.publisher, m.pdate, "
				+ "m.sprice, i.oprice, i.inventory, i.loc, i.sales, i.profit FROM bookmgr m, inventorytbl i "
				+ "WHERE m.booknum = i.booknum order by m.booknum");
		select(sql, "");
	}
	
	public void select(StringBuffer sql, String q1) {
		dbMgr = DBConnectionMgr.getInstance();
		BookVO bVOS[] = null;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			if(q1 != "") {
				pstmt.setString(1, q1);
			}
			rs = pstmt.executeQuery();
			vecbook = new Vector<>();
			while (rs.next()) {
				bVO = new BookVO();
				bVO.setBooknum(rs.getString("booknum"));
				bVO.setParti(rs.getString("class"));
				bVO.setBookname(rs.getString("bookname"));
				bVO.setAuthor(rs.getString("author"));
				bVO.setPublisher(rs.getString("publisher"));
				bVO.setPdate(rs.getInt("pdate"));
				bVO.setSprice(rs.getInt("sprice"));
				bVO.setOprice(rs.getInt("oprice"));
				bVO.setInven(rs.getInt("inventory"));
				bVO.setLoc(rs.getString("loc"));
				bVO.setSales(rs.getInt("sales"));
				bVO.setProfit(rs.getInt("profit"));
				vecbook.add(bVO);
			}
			jtb_book.setModel(dtm_book);
			while (dtm_book.getRowCount() > 0) {
				dtm_book.removeRow(0);
			}
			for (int i = 0; i < vecbook.size(); i++) {
				Vector oneRow = new Vector();
				oneRow.add(vecbook.get(i).getBooknum());
				oneRow.add(vecbook.get(i).getParti());
				oneRow.add(vecbook.get(i).getBookname());
				oneRow.add(vecbook.get(i).getAuthor());
				oneRow.add(vecbook.get(i).getPublisher());
				oneRow.add(vecbook.get(i).getPdate());
				oneRow.add(vecbook.get(i).getSprice());
				oneRow.add(vecbook.get(i).getOprice());
				oneRow.add(vecbook.get(i).getInven());
				oneRow.add(vecbook.get(i).getLoc());
				oneRow.add(vecbook.get(i).getSales());
				oneRow.add(vecbook.get(i).getProfit());
				dtm_book.addRow(oneRow);
			}
		} catch (SQLException se) {
			System.out.println("SQLExcption : " + se.getMessage());// 좀 더 구체적인 예외처리 클래스 정보를 알수 있다.
		}
	}
	
	public void sqlsetting() {
		if(jcb.getSelectedItem() == "도서명") {
			sql.append(" where m.bookname like '%'||?||'%'   AND m.booknum = i.booknum");
		}
		else if(jcb.getSelectedItem() == "도서번호") {
			sql.append(" where m.booknum like '%'||?||'%'   AND m.booknum = i.booknum");
		}
		else if(jcb.getSelectedItem() == "저자") {
			sql.append(" where m.author like '%'||?||'%'   AND m.booknum = i.booknum");
		}
		else if(jcb.getSelectedItem() == "출판사") {
			sql.append(" where m.publisher like '%'||?||'%'   AND m.booknum = i.booknum");
		}
	}
	public int yesORno() {
		JDialog jd = new JDialog();
		int result = 0;
		Object[] options = {"네", "아니요"};
		result = JOptionPane.showOptionDialog(jd,
				"선태하신 정보를 정말로 삭제하시겠습니까?"
				, null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
				, null, options, options[0]);
		System.out.println("결과는"+result);
		return result;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (e.getClickCount() == 1 && obj == jbtn_back) {
//			new EditView();
			this.dispose();
			new LoginView();
		}
		else if(e.getClickCount() == 2 && obj == jtb_book) {
			int index[] = jtb_book.getSelectedRows();
			String booknum = dtm_book.getValueAt(index[0], 0).toString();
			oldbooknum = dtm_book.getValueAt(index[0], 0).toString();
			String 	sql = "SELECT m.booknum, m.class, m.bookname, m.author, m.publisher, m.pdate, m.sprice, i.oprice, i.inventory, i.loc, i.sales, i.profit"; 
					sql += " FROM bookmgr m, inventorytbl i";
					sql += " WHERE m.booknum = ? AND i.booknum = ?";
			ev = new EditView(true);
			ev.setOldbooknum(oldbooknum);
			try {
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, booknum);
				pstmt.setString(2, booknum);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					bVO = new BookVO();
					bVO.setBooknum(rs.getString("booknum"));
					bVO.setParti(rs.getString("class"));
					bVO.setBookname(rs.getString("bookname"));
					bVO.setAuthor(rs.getString("author"));
					bVO.setPublisher(rs.getString("publisher"));
					bVO.setPdate(rs.getInt("pdate"));
					bVO.setSprice(rs.getInt("sprice"));
					bVO.setOprice(rs.getInt("oprice"));
					bVO.setInven(rs.getInt("inventory"));
					bVO.setLoc(rs.getString("loc"));
					bVO.setSales(rs.getInt("sales"));
					bVO.setProfit(rs.getInt("profit"));
				}
				ev.set(bVO, this, "수정");
				}
			catch(Exception e1) {
					JOptionPane.showMessageDialog(this, "Exception : " + e1.toString());
			}
		}	
		else if(obj == jbtn_sel) {
			if(jtf.getText().length() != 0) {
				sql.setLength(0);
				sql.append("SELECT m.booknum, m.class, m.bookname, m.author"
						+ ", m.publisher, m.pdate, m.sprice"
						+ ", i.oprice, i.inventory, i.loc, i.sales, i.profit "
						+ " FROM bookmgr m, inventorytbl i ");
				sqlsetting();
				select(sql, jtf.getText());
			}
			else loading();
		}
		else if(obj == jbtn_ins) {
//			bVO = new BookVO();
			ev = new EditView(true);
			ev.set(this, "도서등록");
		}
		else if (obj == jlb) {
			loading();
		}
		else if(obj == jbtn_del) {
			if(yesORno() == 0) {
				int index[] = jtb_book.getSelectedRows();
				if(index.length == 0) {
					JOptionPane.showMessageDialog(this, "삭제하실 도서를 선택해주세요");
				}
				else {
		          ArrayList<String> booknum_arr = new ArrayList<>();
		          for(int i=0; i < index.length; i++) {
		              booknum_arr.add(dtm_book.getValueAt(index[i], 0).toString());    //도서번호를 가져와서 어/리에 담음
		          }
		          sql.setLength(0);
		          sql.append("DELETE FROM BOOKMGR WHERE BOOKNUM = ?");
		          try {
		                  con = dbMgr.getConnection();
		                  pstmt = con.prepareStatement(sql.toString());
		                  for(String booknum: booknum_arr) {
		                      pstmt.setString(1, booknum);
		                      rs = pstmt.executeQuery();
		                  }
		          } catch (SQLException e2) {
		              JOptionPane.showMessageDialog(this, "존재하지 않는 도서번호 입니다.");
		          }
				}
		          loading();
		          dbMgr.freeConnection(con, pstmt, rs);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(jtf.getText().length() != 0 && e.getKeyCode() == KeyEvent.VK_ENTER) {
			sql.setLength(0);
			sql.append("SELECT m.booknum, m.class, m.bookname, m.author"
					+ ", m.publisher, m.pdate, m.sprice"
					+ ", i.oprice, i.inventory, i.loc, i.sales, i.profit "
					+ " FROM bookmgr m, inventorytbl i ");
			sqlsetting();
			select(sql, jtf.getText());
		}
		else if(jtf.getText().length() == 0 && e.getKeyCode() == KeyEvent.VK_ENTER) {
			loading();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setlv(LoginView lv) {
		this.lv = lv;
	}
//	public static void main(String[] args) {
//		MgrView mv = new MgrView();
//		mv.initDisplay();
//	}
}
