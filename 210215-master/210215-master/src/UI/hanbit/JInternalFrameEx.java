package UI.hanbit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JInternalFrameEx extends JFrame implements ActionListener {

	JDesktopPane desktop = new JDesktopPane();
	
	JMenuItem openItem = new JMenuItem("New");
	JMenuItem closeItem = new JMenuItem("Close");
	JMenuItem exitItem = new JMenuItem("Exit");
	
	int cnt=1;

	public JInternalFrameEx() {
		
		super("JInternalFrame 테스트");
		
		buildGUI();

		setBounds(300,200,500,400);
		setVisible(true);
	}
	
	void buildGUI() {
    	
		add(desktop, BorderLayout.CENTER);
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		
		fileMenu.add(openItem);
		fileMenu.add(closeItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		openItem.addActionListener(this);
		closeItem.addActionListener(this);
		exitItem.addActionListener(this);
	}
	
	public void openFrame() {
		JInternalFrame frame = new JInternalFrame("새문서"+cnt, true, true, true, true );
		
		JLabel imageLabel = new JLabel("새문서");
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().add(imageLabel);
		if(cnt==1)
			frame.setSize(200,200);
		else
			frame.setBounds((cnt-1)*20, (cnt-1)*20, 200, 200);
		
		cnt++;

		desktop.add(frame);
		frame.setVisible(true);
	}
	
	public void closeFrame() {	
		JInternalFrame frame = desktop.getSelectedFrame();
		if(frame == null) { return; }		
		frame.setVisible(false);
		frame.dispose();	
	}
	
	public void actionPerformed(ActionEvent e) {
	
		Object obj = e.getSource();
		
		if(obj == openItem) {
			openFrame();
		}
		else if(obj == closeItem) {
			closeFrame();
		}
		else if(obj == exitItem) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args){
		new JInternalFrameEx();
	}
}