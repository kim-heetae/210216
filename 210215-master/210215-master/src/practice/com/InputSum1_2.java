package practice.com;

import java.util.Scanner;

/*
 * 1부터 n까지의 정수의 합계를 구하시오
 * 
 */
public class InputSum1_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1부터 end까지 숫자를 세는 변수
		int start = 0;
		//1부터 어디까지 셀것인지 담을 변수
		int end = 0;
		//합을 구해서 담을 변수 선언
		int hap = 0;
		System.out.println("계산하고 싶은 정수를 입력하세요.");
		end = sc.nextInt();
		//String s = sc.nextInt(); 타입을 맞추지 않음
		for(start = 1; start <= end; start++) {
			//System.out.println(start);
			hap += start;
			System.out.println(hap);
		}
		System.out.println(hap);
	}

}
