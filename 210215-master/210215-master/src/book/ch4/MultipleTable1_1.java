package book.ch4;

import java.util.Scanner;

class ChoiceNum{
	Scanner sc = new Scanner(System.in);
	MultipleTable1_1 mt = new MultipleTable1_1();
	int inputMN(int mainnum, int subnum) {
		System.out.println("출력할 단의 숫자를 입력해주세요");
		mainnum = sc.nextInt();
		return mainnum;
	}
	int inputSN(int mainnum, int subnum) {
		System.out.println("메인 숫자의 몇단까지 출력할지 입력해주세요");
		subnum = sc.nextInt();
		return subnum;
	}
	
}

class MakeTable{
	void multi(int mainnum, int subnum) {
		System.out.println(mainnum + "를 " + subnum + "단 까지 출력합니다");
		for(int i = 1; i <= subnum; i++) {
			System.out.println(mainnum + " * " + i + " = " + (mainnum * i));
		}
	}
}

public class MultipleTable1_1 {
	
	int mainnum = 0;
	int subnum = 0;
	public static void main(String[] args) {
		ChoiceNum cn = new ChoiceNum();
		MakeTable mt2 = new MakeTable();
		MultipleTable1_1 mt = new MultipleTable1_1();
		System.out.println("구구단중의 특정숫자의 단을 출력하는 프로그램입니다");
		mt.mainnum = cn.inputMN(mt.mainnum, mt.subnum);
		mt.subnum = cn.inputSN(mt.mainnum, mt.subnum);
		mt2.multi(mt.mainnum, mt.subnum);
	}

}
