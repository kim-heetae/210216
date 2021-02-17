package book.ch4;

import java.util.Random;
import java.util.Scanner;

public class RandomGame1_1 {

	public static void main(String[] args) {
		//난수 발생을 지원하는 클래스 추가하기 - 인스턴스화 하기
		Random r = new Random();
		//그 클래스가 제공하는 메소드를 호출하여 채번하기
		int rnum = r.nextInt(10);
		//사용자로 부터 입력한 값 받아오기
		int num = 0;
		//사용자가 입력한 값 담기 - 선언하기, 초기화
		//0~9중에서 고르기
		Scanner sc = new Scanner(System.in);
		System.out.println("1부터 10까지의 수중 하나를 입력해주세요");
		int count = 0;
		String user = null;
		//기회를 3번까지 준다 - 1번, 2번, 3번 =>반복문
		for(int i = 0; (user = sc.nextLine()) != null; i++){
			//insert here - 실행문
			num = sc.nextInt();			
			//판별식
			if(count < 3) {
				//1번, 2번, 3번
				if(Integer.parseInt(user) == rnum) {
					System.out.println("정답입니다.");
					break;
				}
				else if(Integer.parseInt(user) > rnum) {
					count++;
					System.out.println(Integer.parseInt(user) + "보다 작은수입니다.");
				}
				else if(Integer.parseInt(user) < rnum) {
					count++;
					System.out.println(Integer.parseInt(user) + "보다 큰수입니다.");
				}
			}
			else {
				//넌 바보 - break; //for문을 탈출하기 if문을 탈출하려면 return
				System.out.println("실패입니다.");
				break;
			}
			//정답입니다.
			
		}//for문끝
	}

}
