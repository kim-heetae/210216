package UI.hanbit;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class JColorChooserEx extends JFrame implements ActionListener{
	
	JMenuBar mb =new JMenuBar();
	JMenu mnuselect = new JMenu("선택");
	JMenuItem mnucolor=new JMenuItem("색샹");
	JLabel l=new JLabel("출력창");
	JTextArea ta=new JTextArea();
			
	public JColorChooserEx(){

		super("JColorChooser 테스트");
			
		mnuselect.add(mnucolor);
		
		mb.add(mnuselect);
		
		setJMenuBar(mb);
		
		add("North",l);
		add("Center",ta);
		
		setBounds(300, 300, 300, 200);
		setVisible(true);
		
		mnucolor.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==mnucolor){
			JColorChooser chooser = new JColorChooser();
			Color col=chooser.showDialog(this,"색상을 고르세요",Color.blue);
			l.setText("선택한 색상은"+col);
			ta.setBackground(col);
		}
	}
	
	public static void main(String[] args){
		new JColorChooserEx();
	}
}