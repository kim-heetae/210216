package practice.com;

import java.util.Random;

class Lotto{
	LottoGame lg = new LottoGame();
	Random r = new Random();
	int[] rnum(int[] lotto) {
		for(int i = 0; i < lotto.length; i++) {
			if(i < 1) {
				lotto[i] = r.nextInt(45) + 1;				
			}
			else {
				lotto[i] = r.nextInt(45) + 1;				
				for(int j = (i - 1); j >= 0; ) {
					if(lotto[i] == lotto[j]) {
						lotto[i] = r.nextInt(45) + 1;
						j = i - 1;
					}
					else {
						j -= 1;
					}
				}
			}
		}
		return lotto;
	}
}

class PrintLotto{
	void print(int[] lotto){
		System.out.println("추천 번호 : ");
		for(int i = 0; i < lotto.length; i++) {
			System.out.println((i + 1) + "번째 숫자는 " + lotto[i] + "입니다");
		}
	}
}

public class LottoGame {
	
	int[] lotto = new int[6];
	public static void main(String[] args) {
		LottoGame lg = new LottoGame();
		Lotto r = new Lotto();
		PrintLotto pl = new PrintLotto();
		lg.lotto = r.rnum(lg.lotto);
		pl.print(lg.lotto);
		
	}

}
