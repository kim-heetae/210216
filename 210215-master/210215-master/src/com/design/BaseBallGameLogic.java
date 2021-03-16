package com.design;

public class BaseBallGameLogic {
	//컴퓨터가 난수발생으로 얻어낸 값 저장
	//채번하는 메소드가 필요함
	//메소드 중심의 코딩 전개하기 - 재사용성의 첫단추
	//새 게임을 눌렀을 때
	//정답을 눌렀을 때
	int[] com = new int[3];//0 0 0 
	//사용자가 입력한 값은 로컬에서 온다
	int[] my = new int[3];	//0 0 0
	
	public void nanSu(){
		com[0] = (int)(Math.random()*10);
		do{
			com[1] = (int)(Math.random()*10);
		}while(com[0]==com[1]);
		do{
			com[2] = (int)(Math.random()*10);
		}while((com[0]==com[2])||(com[1]==com[2]));
		System.out.println(com[0]+""+com[1]+""+com[2]);
	}
	
	//전광판에 출력될 메시지를 작성하는 메소드 선언
	/***************************************************************
	 * 
	 * @param input jp_center라는 속지 - 남쪽 - JTextField - 숫자를 넣어도 문자로 받음
	 * @return 1스 0볼, 2스 1볼 (2자리는 숫자도 같고 위치도 같을때, 숫자는 있지만 위치가다를때)
	 * 1회 : 256 - 1스 0볼
	 * 2회 : 356 - 1스 1볼
	 * 전역변수 : 횟차를 말하는 cnt(static 고려대상이지만 바뀌어야 함)
	 * 지역변수 : 스트라이크, 볼(static은 고려대상이 아님)
	 ***************************************************************/
		public String call(String input){
			//스트라이크를 카운트할 변수
			int strike = 0;
			//볼을 카운트할 변수
			int ball = 0;		
			int temp = 0;
			//반드시 세자리 숫자 이어야 한다.
			if(input.length()!=3){
				return "세자리 숫자만 입력하세요!!!";
			}
			temp = Integer.parseInt(input);
			my[0] = temp/100;//백자리를 받는다.
			my[1] = (temp%100)/10;//십자리를 받는다.
			my[2] = temp%10;
			for(int i=0;i<com.length;i++){
				for(int j=0;j<my.length;j++){
					//같은 숫자가 존재하는 경우(볼확보)
					//컴퓨터가 채번한 숫자가 있는지 비교
					if(com[i] == my[j]){
						//자리수까지도 일치하는 경우(스트라이크확보)
						//그 숫자가 존재하는 배열의 인덱스값을 비교
						if(i==j){
							strike++;
						}else{
							ball++;
						}
					}//  end of if          ////////////////
				}//////  end of inner for   ////////////////
			}//////////  end of outter for  ////////////////
			if(strike == 3) return "정답입니다.";
			return strike+"스트라이크" +ball+"볼";
		}/////////////  end of call ////////////////////////
		
}
