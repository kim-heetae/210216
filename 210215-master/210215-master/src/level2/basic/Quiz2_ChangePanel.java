package level2.basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Quiz2_ChangePanel extends JPanel{
	DefaultTableModel dtm = new DefaultTableModel();
	JTable jt = new JTable(dtm);
	JScrollPane jsp = new JScrollPane();
	JButton jbtn_action = new JButton("처리");
	JButton jbtn_exit = new JButton("종료");
	JPanel jp_south = new JPanel(new FlowLayout());
//	JFrame jf = new JFrame();
	public void initDisplay() {
		this.setLayout(new BorderLayout());
		jp_south.add(jbtn_action);
		jp_south.add(jbtn_exit);
		jp_south.setBackground(Color.orange);
		jsp.add(jt);
		this.add("Center", jsp);
		this.add("South", jp_south);
//		jf.add(this);
//		jf.setSize(300, 200);
//		jf.setVisible(true);
	}
//	public Quiz2_ChangePanel() {
//		initDisplay();
//	}
//
//		public static void main(String[] args) {
//		new Quiz2_ChangePanel();
//	}
}
