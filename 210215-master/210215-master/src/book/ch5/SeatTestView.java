package book.ch5;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeatTestView extends JFrame {
	//선언부
	//선택한 좌석수
	int inwon = 0;
	//좌석 최대 선택가능수
	int max_selection = 1;
   
   
	JPanel jp_north = new JPanel();
   
    //콤보박스에 넣을 숫자
    String[] choice = {"1","2","3","4"};  
    JLabel ticketinwon = new JLabel("예매좌석수");  
    
    //선택 가능 최대 좌석수 설정하는 콤보박스
    JComboBox jcbb_max = new JComboBox(choice);   
      
    JPanel jp_center = new JPanel(new GridLayout(3,6));

    //좌석번호
    String[] seatnumber = {"A1","A2","A3","A4","A5","A6","B1","B2","B3","B4","B5","B6","C1","C2","C3","C4","C5","C6"};
   
    //좌석 체크박스
    JCheckBox[] jcb_seat = new JCheckBox[18];

      
      
    JPanel jp_south = new JPanel();
    JLabel jlb_inwonsu = new JLabel("선택한 좌석 수 ");
      
    //선택한 좌석수 보여주는 라벨
    JLabel jlb_selseatnum = new JLabel(String.valueOf(inwon));  
    JLabel jlb_seatnumber = new JLabel("선택한 좌석 번호 ");
      
    //선택한 좌석의 좌석번호 보여주는 라벨
    JLabel[] jlb_selseat = new JLabel[4];
      
    JButton jbtn_pay = new JButton("결제");
//    SeatTestViewEvent stvEvent = new SeatTestViewEvent(this);

    //생성자
    public SeatTestView() {
    	initDisplay();
    }
   
    //메소드
    public void initDisplay() {
    	//insert here 이벤트 핸들러와 이벤트 소스 매핑
//    	jcbb_max.addItemListener(stvEvent);
    	
    	jp_north.add(ticketinwon);
    	jp_north.add(jcbb_max);
      
    	//좌석에 좌석 번호 붙이기 , jp_center에 좌석추가 , 좌석에 아이템 리스너추가
    	for(int i=0;i<jcb_seat.length;i++)   
    	{ 
    		jcb_seat[i] =new JCheckBox(seatnumber[i]); 
    		jp_center.add(jcb_seat[i]);
    		//insert here 이벤트 핸들러와 이벤트 소스 매핑
//    		jcb_seat[i].addItemListener(stvEvent);
    	} 
      
    	jp_south.add(jlb_inwonsu);
    	jp_south.add(jlb_selseatnum);
    	jp_south.add(jlb_seatnumber);
      
    	//선택한 좌석번호 표시하는 라벨 추가
    	for(int i=0; i<jlb_selseat.length;i++) {
    		jlb_selseat[i] = new JLabel();
    		jp_south.add(jlb_selseat[i]);
    	}
      
    	jp_south.add(jbtn_pay);
    	this.add("North",jp_north);
    	this.add("Center",jp_center);
    	this.add("South",jp_south);
    	this.setSize(500, 500);
    	this.setVisible(true);
      
    }
    public static void main(String[] args) {
    	new SeatTestView();
    }

	public JLabel getJlb_selseatnum() {
		return jlb_selseatnum;
	}

	public JLabel[] getJlb_selseat() {
		return jlb_selseat;
	}

    //insert here - JComboBox와 JCheckBox에 대한 이벤트 처리 해야 합니다. - 요기 아래 
   

}