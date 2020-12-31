package com.oleh;

import java.util.Random;

public class SingletonProblem_Volatile
{
	private long time; // to make this class not utility for IntelliJ
	private static SingletonProblem_Volatile singleton; // volatile
	private static boolean b = true;
	private SingletonProblem_Volatile(long time){
		this.time = time;
	}

	public static SingletonProblem_Volatile getInstance() // synchronized needed
	{
		b=false;
		if (singleton == null) { // lazy initialized
			synchronized (SingletonProblem_Volatile.class) {
				if (singleton == null)
				{
					System.out.println("called");
					singleton = new SingletonProblem_Volatile(System.currentTimeMillis());
				}
			}
		}
		return singleton;
	}

	public static void main(String[] args)
	{
		new Thread(() -> {
			while(b){} // if singleton is not volatile this will not end. singleton in thread cache
			System.out.println("singleton not null!");
		}).start();
			new Random().ints(8).parallel().forEach(i -> {
				SingletonProblem_Volatile instance = getInstance();
			});
	}
}
