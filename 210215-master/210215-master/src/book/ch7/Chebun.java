package book.ch7;

import java.util.Random;

public class Chebun {
	int com[] = new int[3];
	void nansu() {
		Random r = new Random();
		com[0] = r.nextInt(10);
		do {
			com[1] = r.nextInt(10);
		}while(com[0] == com[1]);
		do {
			com[2] = r.nextInt(10);
		}while(com[0] == com[2] || com[1] == com[2]);
	}
	
	public static void main(String[] args) {
		Chebun cb = new Chebun();
		int cnt = 0;
		for(int i = 0; i < 3; i++) {
			cb.nansu();
			System.out.println(++cnt);
		}
	}

}
