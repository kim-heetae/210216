package ch5.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {

	ViewApp1_1 viewApp = null;
	public EventHandler(ViewApp1_1 viewApp) {
		this.viewApp = viewApp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewApp.jbtn) {//nullpointerexception발생 가능 구간
			System.out.println("전송호출");
		}
	}

}
