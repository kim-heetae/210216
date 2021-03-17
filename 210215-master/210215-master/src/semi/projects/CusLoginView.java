package semi.projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class CusLoginView implements ActionListener, KeyListener{
	JFrame 		jf 			= new JFrame();	
	JPanel 		jp_south 	= new JPanel();	
	JPanel 		jp_south1 	= new JPanel();	
	JPanel 		jp_south2 	= new JPanel();	
	JPanel 		jp_center	= new JPanel();
	JLabel 		jlb_id 		= new JLabel("ID");
	JTextField 	jtf_id 		= new JTextField();
	JLabel 		jlb_pw 		= new JLabel("PW");
	JPasswordField jpf_pw	= new JPasswordField();
	JButton 	jbtn_back 	= new JButton("이전");  	
	JButton 	jbtn_login 	= new JButton("로그인"); 	
	JButton 	jbtn_exit 	= new JButton("닫기");  	
	JButton 	jbtn_join 	= new JButton("회원가입");  	
//	JScrollPane jsp_center 	= new JScrollPane(jp_center);
//	JScrollPane jsp_south 	= new JScrollPane(jp_south);
	Font		font		= new Font(null, 0, 20);
//	static LoginView	lv	= null;
//	DBConnectionMgr dbMgr 	= DBConnectionMgr.getInstance();
	DBConnectionMgr 	dbMgr 	= null;
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	ResultSet 			rs 		= null;
//	MgrView mv = new MgrView();
	MgrView mv = null;
	
	public CusLoginView() {
		initDisplay();
	}
	
	public void initDisplay() {
		jf.setResizable(false);
		jbtn_login.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jtf_id.addKeyListener(this);
		jtf_id.setFocusTraversalKeysEnabled(false);
		jpf_pw.setFocusTraversalKeysEnabled(false);
		jpf_pw.addKeyListener(this);
		jlb_id.setBounds(100, 70, 150, 25);
		jtf_id.setBounds(150, 70, 150, 25);
		jlb_pw.setBounds(100, 120, 150, 25);
		jpf_pw.setBounds(150,120, 150, 25);
		jbtn_login.setBounds(315, 70, 80, 75);
//		jp_south1.setBackground(Color.orange);
		jp_south.setLayout(new GridLayout(2,1));
		jp_south.add(jp_south1);
		jp_south.add(jp_south2);
		jp_center.add(jlb_id);
		jp_center.add(jtf_id);
		jp_center.add(jlb_pw);
		jp_center.add(jpf_pw);
		jp_center.add(jbtn_login);
		jp_south2.add(jbtn_back);
		jp_south2.add(jbtn_join);
		jp_south2.add(jbtn_exit);
		jf.add("Center", jp_center);
		jf.add("South", jp_south);
		jp_center.setLayout(new BorderLayout());
		jf.setSize(500, 300);
		jf.setTitle("로그인");
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new CusLoginView();		
	}
	public void login() {
		String 	id = jtf_id.getText();
		String 	pw = jpf_pw.getText();		
		String 	sql = "SELECT mem_id, mem_pw FROM custbl";
				sql += " WHERE mem_id = ?";
				sql += " AND mem_PW = ?";
		try {
			dbMgr = DBConnectionMgr.getInstance();
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			int result = pstmt.executeUpdate();
			if(result == 1) {
				JOptionPane.showMessageDialog(jf, "환영합니다");				
				dbMgr.freeConnection(con, pstmt, rs);
				mv = new MgrView();
//				mv.initDisplay();
//				mv.setlv(lv);
				jf.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(jf, "아이디와 비밀번호를 확인하세요");
				jtf_id.setText("");
				jpf_pw.setText("");
				jtf_id.grabFocus();
			}
		}catch(Exception e) {
			System.out.println("오류");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
			
		if(obj == jbtn_login) {
			login();
		}
		else if(obj == jbtn_exit) {
			System.exit(0);
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		Object obj = e.getSource();
		if (e.getKeyCode()==KeyEvent.VK_ENTER){
			login();
		}
		else if(obj == jtf_id && e.getKeyCode() == KeyEvent.VK_TAB) {
			jpf_pw.grabFocus();
		}
		else if(obj == jpf_pw && e.getKeyCode() == KeyEvent.VK_TAB) {
			jtf_id.grabFocus();
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
