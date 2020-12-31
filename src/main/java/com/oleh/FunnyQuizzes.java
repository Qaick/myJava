package com.oleh;

public class FunnyQuizzes
{
	class Ракетница{}
	public static void main(String[] args)
	{
//		System.out.println("" == new StringBuilder()); // ERROR - compilator doesn't allow co compare different types
//		System.out.println(new String() == new Integer(1)); // ERROR

//		byte b = 1;
//		action(b, b);
	}
	static void action(byte... args) { // vararg всегда имеет самый низкий приоритет
		System.out.println("Some.action");
	}
	static void action(long l, short s) { // приведение к примитивным типам приортитетнее чем боксинг
		System.out.println("Some.action2");
	}
	static void action(Byte b, Byte b2) {
		System.out.println("Some.action3");
	}

	void run() {
		System.out.println("best conf");
		http://www.javapoint.ru
		return;
	}
//1 > best confhttp://www.javapoint.ru
//2 > best conf
//3 > Compilation Error

	static void work() {
		try {
			work();
		} finally {
			work(); // 100% процессора, и зависнет
		}
	}
}
