package semi.projects;

import java.awt.BorderLayout;
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


public class LoginView implements ActionListener, KeyListener{
	JFrame 		jf 			= new JFrame();	
	JPanel 		jp_south 	= new JPanel();	
	JPanel 		jp_center	= new JPanel();
	JLabel 		jlb_id 		= new JLabel("ID");
	JTextField 	jtf_id 		= new JTextField();
	JLabel 		jlb_pw 		= new JLabel("PW");
	JPasswordField jpf_pw	= new JPasswordField();
	JButton 	jbtn_back 	= new JButton("이전");  	
	JButton 	jbtn_login 	= new JButton("로그인"); 	
	JButton 	jbtn_exit 	= new JButton("닫기");  	
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
	
	public LoginView() {
		initDisplay();
	}
	
	public void initDisplay() {
		jf.setResizable(false);
		jbtn_login.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jtf_id.addKeyListener(this);
		jpf_pw.addKeyListener(this);
		jlb_id.setBounds(120, 70, 150, 25);
		jtf_id.setBounds(200, 70, 150, 25)	;
		jlb_pw.setBounds(120, 120, 150, 25);
		jpf_pw.setBounds(200,120, 150, 25);
		jp_center.add(jlb_id);
		jp_center.add(jtf_id);
		jp_center.add(jlb_pw);
		jp_center.add(jpf_pw);
		jp_south.add(jbtn_back);
		jp_south.add(jbtn_login);
		jp_south.add(jbtn_exit);
		jf.add("Center", jp_center);
		jf.add("South", jp_south);
		jp_center.setLayout(new BorderLayout());
		jf.setSize(500, 300);
		jf.setTitle("로그인");
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new LoginView();		
	}
	public void login() {
		String 	id = jtf_id.getText();
		String 	pw = jpf_pw.getText();		
		String 	sql = "SELECT id, pw FROM login";
				sql += " WHERE id = ?";
				sql += " AND PW = ?";
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
		if (e.getKeyCode()==KeyEvent.VK_ENTER){
			login();
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
