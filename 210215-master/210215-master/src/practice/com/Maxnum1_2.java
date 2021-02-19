package practice.com;

import java.util.Random;

class RandomArray{//배열에 랜덤의 수 10개 넣는 클래스
	int[] rnum(int[] nrr) {
		Random r = new Random();
		for(int i = 0; i < nrr.length; i++) {
			nrr[i] = r.nextInt(20) + 1;
		}
		return nrr;
	}
}

class Max{//배열에서 최대값을 찾는 클래스
	int maxnum(int max, int[] nrr) {
		for(int i = 0; i < nrr.length; i++) {
			if(max <= nrr[i]) {
				max = nrr[i];
			}
		}
		return max;
	}
}

class Print{//출력 클래스
	void printArray(int max, int[] nrr) {
		System.out.print("배열 : ");
		for(int i = 0; i < nrr.length; i++) {
			if(i == (nrr.length - 1)) {
				System.out.println(nrr[i]);
			}
			else {
				System.out.print(nrr[i] + ", ");				
			}
		}
		System.out.println("가장 큰 수는 " + max +"입니다");
	}
}

public class Maxnum1_2 {

	int max = 0;
	int[] nrr = new int[10];
	public static void main(String[] args) {
		Maxnum1_2 mn = new Maxnum1_2();
		RandomArray ra = new RandomArray();
		Max mx = new Max();
		Print p = new Print();
		mn.nrr = ra.rnum(mn.nrr);
		mn.max = mx.maxnum(mn.max, mn.nrr);
		p.printArray(mn.max, mn.nrr);
	}
}
