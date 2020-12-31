package com.oleh;

import java.io.IOException;
import java.nio.file.Paths;

public class MainMethod
{
	public static void main(String[] args) throws Exception
	{
//		true.if
		monthFiles();
	}

	private static void monthFiles() throws IOException
	{
		String first = "C:\\Users\\bovo\\Desktop\\2020";
		for (int i = 1; i <= 31; i++)
		{
			if (!Paths.get(first, String.valueOf(i)).toFile().delete())
			{
				System.out.println("not del " + i);
			}
			if (!Paths.get(first, String.valueOf(i) + ".txt").toFile().delete())
			{
				System.out.println("not created " + i);
			}
		}
	}
}
