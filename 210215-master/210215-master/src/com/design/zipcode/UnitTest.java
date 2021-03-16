package com.design.zipcode;

import java.util.ArrayList;

public class UnitTest {

	public static void main(String[] args) {
		ZipcodeDao zcd = new ZipcodeDao();
		ArrayList<ZipcodeVO> zipcodeList = null;
		zipcodeList = zcd.getZipcodeList("가산동");
		zipcodeList = zcd.getZipcodeList("당산동");
		zipcodeList = zcd.getZipcodeList("개봉동");
		System.out.println(zipcodeList);
	}

}
