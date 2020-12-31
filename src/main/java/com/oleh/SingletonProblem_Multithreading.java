package com.oleh;

import java.util.Random;

/**
 * Problem with multithreading - it outputs multiple creation of the singleton
 * Lazy.
 * When Singleton is not initialized and getInstance is called from 2 threads in the same time there will be several singletons.
 */
public class SingletonProblem_Multithreading
{
	private long time; // not utility for IntelliJ
	private static SingletonProblem_Multithreading singleton;
	private SingletonProblem_Multithreading(long time){
		this.time = time;
	}

	// if this method will be synchronized it's performance will drop
	public static SingletonProblem_Multithreading getInstance() // synchronization needed
	{
		if (singleton == null) { // lazy initialized
			System.out.println("singleton instance creation");
			sleep(1);
			singleton = new SingletonProblem_Multithreading(System.currentTimeMillis());
		}
		return singleton;
	}

	public static void main(String[] args)
	{
		new Random().ints(8).parallel().forEach(i -> getInstance());
	}

	public static void sleep(int time){
		try
		{
			Thread.sleep(time);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
