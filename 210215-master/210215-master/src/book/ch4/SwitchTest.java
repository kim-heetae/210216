package book.ch4;

public class SwitchTest {

	public static void main(String[] args) {
		int protocol = 100;//로그인
		protocol = 200;//입장하기
		protocol = 300;//다자간 대화
		protocol = 301;//1대1채팅
		String id = "tomato";
		String input = "오늘 스터디 할까?";
		String msg = protocol + "#" + id + "#" + input;
		//제어문의 역할은 업무 순서에 대한 흐름을 바꾼다.
		//순서에 대한 정보를 바탕으로 의사를 결정할 수 있는 것은 팀장, 차장, 부장 - 선택자
		//선택(비즈니스 로직 - Model계층)에 따라
		//break <> continue
		//활용빈도 : break > continue
		//for문 , while문.... - 무한루프 방지를 위해 사용
		//if문 - break대신 return사용. if문에서 return사용시 메소드 탈출
		//switch에서의 break는 switch문을 빠져나감.
		switch(protocol) {//원시형타입 + String타입
		case 0:
			//실행문
			System.out.println("0입니다");
			break;
		case 301:
			System.out.println("301입니다");
			break;
		case 100:
			System.out.println("100입니다");
			break;
		default:
			System.out.println("default입니다");
			break;
		}
		System.out.println("여기");
	}

}
