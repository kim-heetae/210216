package com.ocjp;

enum Dogs {collie, harrier, shepherd};

public class Ocjp52 {
	void m() {
		System.out.println(Dogs.collie);
		System.out.println(Dogs.harrier);
		System.out.println(Dogs.shepherd);
		String name = "이순신";
		switch (name) {
		case "이순신":
			System.out.println("이순신");
			break;
		case "김유신":
			System.out.println("김유신");
			break;
		}
	}
	public static void main(String[] args) {
		Ocjp52 q = new Ocjp52();
		q.m();
		Dogs myDog = Dogs.shepherd;
		switch (myDog) {
		case collie:
			System.out.println("collie");
		case shepherd:
			System.out.println("shepherd");
		case harrier:
			System.out.println("harrier");
		}
		
	}
}
