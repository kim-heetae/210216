package semi.projects;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.vo.DeptVO;

public class EditView extends JFrame implements ActionListener, KeyListener{
//	JFrame 		jf 				= null;
	JLabel 		jlb_booknum 	= new JLabel("도  서  번  호:");
	JTextField 	jtf_booknum 	= new JTextField();
	JLabel 		jlb_bookname 	= new JLabel("도    서    명:");
	JTextField 	jtf_bookname 	= new JTextField();
	JLabel 		jlb_class 		= new JLabel("분	         류:");
	JTextField 	jtf_class 		= new JTextField();
	JLabel 		jlb_author 		= new JLabel("저         자:");
	JTextField 	jtf_author 		= new JTextField();
	JLabel 		jlb_publisher 	= new JLabel("출    판    사:");
	JTextField 	jtf_publisher 	= new JTextField();
	JLabel 		jlb_date 		= new JLabel("출    판    일:");
	JTextField 	jtf_date 		= new JTextField();
	JLabel 		jlb_sprice 		= new JLabel("판    매    가:");
	JTextField 	jtf_sprice 		= new JTextField();
	JLabel 		jlb_oprice 		= new JLabel("원         가:");
	JTextField 	jtf_oprice 		= new JTextField();
	JLabel 		jlb_inven 		= new JLabel("재         고:");
	JTextField 	jtf_inven 		= new JTextField();
	JLabel 		jlb_loc 		= new JLabel("위         치:");
	JTextField 	jtf_loc 		= new JTextField();
	JLabel 		jlb_sales 		= new JLabel("판    매    량:");
	JTextField 	jtf_sales 		= new JTextField();
	JLabel 		jlb_profit 		= new JLabel("순    이    익:");
	JTextField 	jtf_profit 		= new JTextField();
	JButton		jbtn_upd		= new JButton("도서등록");
	JButton		jbtn_exit		= new JButton("닫기");
	Font		myfont			= new Font("휴먼모음T",Font.PLAIN,16);
	BookVO		bVO				= null;
//	static MgrView	mv 			= null;
	MgrView	mv 			= null;
	DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql = new StringBuffer();
	Vector<BookVO> vecbook = null;
	String oldbooknum = null;
	public EditView(boolean visible) {
		initDisplay();
		this.setVisible(visible);
	}
	
	public void initDisplay() {
//		jf = new JFrame();
		this.getContentPane().setLayout(null);
		
	    jlb_booknum.setBounds(50, 50, 130, 40);
	    jlb_booknum.setFont(myfont);
	    jlb_bookname.setBounds(50, 100, 130, 40);
	    jlb_bookname.setFont(myfont);
	    jlb_class.setBounds(50, 150, 130, 40);
	    jlb_class.setFont(myfont);
	    jlb_author.setBounds(50, 200, 130, 40);
	    jlb_author.setFont(myfont);
	    jlb_publisher.setBounds(50, 250, 130, 40);
	    jlb_publisher.setFont(myfont);
	    jlb_date.setBounds(50, 300, 130, 40);
	    jlb_date.setFont(myfont);
	    jlb_sprice.setBounds(50, 350, 130, 40);
	    jlb_sprice.setFont(myfont);
	    jlb_oprice.setBounds(50, 400, 130, 40);
	    jlb_oprice.setFont(myfont);
	    jlb_inven.setBounds(50, 450, 130, 40);
	    jlb_inven.setFont(myfont);
	    jlb_loc.setBounds(50, 500, 130, 40);
	    jlb_loc.setFont(myfont);
	    jlb_sales.setBounds(50, 550, 130, 40);
	    jlb_sales.setFont(myfont);
	    jlb_profit.setBounds(50, 600, 130, 40);
	    jlb_profit.setFont(myfont);
	    jtf_booknum		.setBounds(200, 60, 300, 20);
	    jtf_bookname	.setBounds(200, 110, 300, 20);
	    jtf_class		.setBounds(200, 160, 300, 20);
	    jtf_author		.setBounds(200, 210, 300, 20);
	    jtf_publisher	.setBounds(200, 260, 300, 20);
	    jtf_date		.setBounds(200, 310, 300, 20);
	    jtf_sprice		.setBounds(200, 360, 300, 20);
	    jtf_oprice		.setBounds(200, 410, 300, 20);
	    jtf_inven		.setBounds(200, 460, 300, 20);
	    jtf_loc			.setBounds(200, 510, 300, 20);
	    jtf_sales		.setBounds(200, 560, 300, 20);
	    jtf_profit		.setBounds(200, 610, 300, 20);
	    jbtn_upd		.setBounds(180, 660, 100, 50);
	    jbtn_exit		.setBounds(300, 660, 100, 50);
	    jtf_booknum.addKeyListener(this);
	    jtf_bookname.addKeyListener(this);
	    jtf_class.addKeyListener(this);
	    jtf_author.addKeyListener(this);
	    jtf_publisher.addKeyListener(this);
	    jtf_date.addKeyListener(this);
	    jtf_sprice.addKeyListener(this);
	    jtf_oprice.addKeyListener(this);
	    jtf_inven.addKeyListener(this);
	    jtf_loc.addKeyListener(this);
	    jtf_sales.addKeyListener(this);
	    jtf_profit.addKeyListener(this);
	    jbtn_upd.addKeyListener(this);
	    jbtn_exit.addKeyListener(this);
		
	    jbtn_exit.addActionListener(this);
	    jbtn_upd.addActionListener(this);
	    
		this.add(jlb_booknum);
		this.add(jlb_bookname);
		this.add(jlb_class);
		this.add(jlb_author);
		this.add(jlb_publisher);
		this.add(jlb_date);
		this.add(jlb_sprice);
		this.add(jlb_oprice);
		this.add(jlb_inven);
		this.add(jlb_loc);
		this.add(jlb_sales);
		this.add(jlb_profit);
		this.add(jtf_booknum);
		this.add(jtf_bookname);
		this.add(jtf_class);
		this.add(jtf_author);
		this.add(jtf_publisher);
		this.add(jtf_date);
		this.add(jtf_sprice);
		this.add(jtf_oprice);
		this.add(jtf_inven);
		this.add(jtf_loc);
		this.add(jtf_sales);
		this.add(jtf_profit);
		this.add(jbtn_upd);
		this.add(jbtn_exit);
		this.setTitle("도서 등록");
		this.setSize(600, 800);
		this.setVisible(false);
	}
//	public void setMgrView(MgrView mv) {
//		this.mv = mv;
//	}
	public void set(BookVO bVO , MgrView mv, String title) {
		this.bVO 	= bVO;//굳이 전역변수로 선언할 필요 없다
		this.mv 	= mv;//전역변수이다
		this.setValue(this.bVO);
		this.setTitle(title);
		jbtn_upd.setText(title);
	}
	public void set(MgrView mv, String title) {
		this.mv 	= mv;//전역변수이다
		this.setEnabled(true);
		this.setTitle(title);
		jbtn_upd.setText(title);
	}
	private void setValue(BookVO bVO) {
		if(bVO == null) {
			jtf_booknum.setText("");	
			jtf_class.setText("");	
			jtf_bookname.setText("");
			jtf_author.setText("");	
			jtf_publisher.setText("");	
			jtf_date.setText("");	
			jtf_sprice.setText("");	
			jtf_oprice.setText("");	
			jtf_inven.setText("");	
			jtf_loc.setText("");	
			jtf_sales.setText("");	
			jtf_profit.setText("");	
		}
		else {
			jtf_booknum.setText(bVO.getBooknum());	
			jtf_class.setText(bVO.getParti());	
			jtf_bookname.setText(bVO.getBookname());	
			jtf_author.setText(bVO.getAuthor());
			jtf_publisher.setText(bVO.getPublisher());	
			jtf_date.setText(String.valueOf(bVO.getPdate()));	
			jtf_sprice.setText(String.valueOf(bVO.getSprice()));	
			jtf_oprice.setText(String.valueOf(bVO.getOprice()));	
			jtf_inven.setText(String.valueOf(bVO.getInven()));	
			jtf_loc.setText(bVO.getLoc());	
			jtf_sales.setText(String.valueOf(bVO.getSales()));	
			jtf_profit.setText(String.valueOf(bVO.getProfit()));
		}
	}

	public void insert() {
		if(jbtn_upd.getText() == "도서등록") {
			sql.setLength(0);
			sql.append("insert all into bookmgr "
					+ " values(?, ?, ?, ?, ?, ?, ?) into inventorytbl "
					+ " values(?, ?, ?, ?, ?, ?) select * from dual");
			String booknum = jtf_booknum.getText();
			String bookname =jtf_bookname.getText();
			String parti =jtf_class.getText();
			String author =jtf_author.getText();
			String publisher =jtf_publisher.getText();
			String pdate =jtf_date.getText();
			String sprice =jtf_sprice.getText();
			String oprice =jtf_oprice.getText();
			String inven =jtf_inven.getText();
			String loc =jtf_loc.getText();
			String sales =jtf_sales.getText();
			String profit =jtf_profit.getText();
			try {
				dbMgr = DBConnectionMgr.getInstance();
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, booknum);
				pstmt.setString(2, parti);
				pstmt.setString(3, bookname);
				pstmt.setString(4, author);
				pstmt.setString(5, publisher);
				pstmt.setString(6, pdate);
				pstmt.setString(7, sprice);
				pstmt.setString(8, booknum);
				pstmt.setString(9, loc);
				pstmt.setString(10, inven);
				pstmt.setString(11, sales);
				pstmt.setString(12, oprice);
				pstmt.setString(13, profit);
				rs = pstmt.executeQuery();
				JOptionPane.showMessageDialog(this, "등록하였습니다.");
				mv.loading();
			} catch (SQLException e1) {
				System.out.println(e1.toString());
				JOptionPane.showMessageDialog(this, "이미 존재하는 도서번호입니다.");
			}
			dbMgr.freeConnection(con, pstmt, rs);					
		}
		else if(jbtn_upd.getText() == "수정"){
			sql.setLength(0);
			sql.append("update bookmgr set booknum = ?, class = ?, bookname = ?"
					+ ", author = ?, publisher = ?, pdate = ?, sprice = ? "
					+ "where booknum = ?");
			String booknum = jtf_booknum.getText();
			String bookname =jtf_bookname.getText();
			String parti =jtf_class.getText();
			String author =jtf_author.getText();
			String publisher =jtf_publisher.getText();
			String pdate =jtf_date.getText();
			String sprice =jtf_sprice.getText();
			String oprice =jtf_oprice.getText();
			String inven =jtf_inven.getText();
			String loc =jtf_loc.getText();
			String sales =jtf_sales.getText();
			String profit =jtf_profit.getText();
			try {
				dbMgr = DBConnectionMgr.getInstance();
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, booknum);
				pstmt.setString(2, parti);
				pstmt.setString(3, bookname);
				pstmt.setString(4, author);
				pstmt.setString(5, publisher);
				pstmt.setString(6, pdate);
				pstmt.setString(7, sprice);
				pstmt.setString(8, oldbooknum);
				rs = pstmt.executeQuery();
			} catch (SQLException e1) {
				
			}
			sql.setLength(0);
			sql.append("update inventorytbl set loc = ?, inventory = ?"
					+ ", sales = ?, oprice = ?, profit = ?"
					+ " where booknum = ?");
			try {
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, loc);
				pstmt.setString(2, inven);
				pstmt.setString(3, sales);
				pstmt.setString(4, oprice);
				pstmt.setString(5, profit);
				pstmt.setString(6, booknum);
				rs = pstmt.executeQuery();
				JOptionPane.showMessageDialog(this, "수정하였습니다.");
			}
			catch(SQLException se){
				JOptionPane.showMessageDialog(this, "수정에 실패하였습니다. \n 도서번호가 중복되는지 확인해주세요");
			}
			dbMgr.freeConnection(con, pstmt, rs);
		}
//		mv.jtb_book.setModel(mv.dtm_book);
//		mv.dtm_count = 0;
		this.mv.loading();
		System.out.println("loading");
		this.setVisible(false);
	}
	public void setOldbooknum(String oldbooknum) {
		this.oldbooknum = oldbooknum;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_exit) {
			this.dispose();
		}
		else if(obj == jbtn_upd && jbtn_upd.getText() == "도서등록" ) {
			insert();
		}
		else if(obj == jbtn_upd && jbtn_upd.getText() == "수정") {
			insert();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			insert();
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

}
