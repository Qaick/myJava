package com.oleh;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStranges
{

	public static void main(String[] args)
	{
		int[] ints = new Random(1).ints(1_000_000, 0, 1000).toArray();
		Integer[] integers = IntStream.of(ints).boxed().toArray(Integer[]::new);
		// boxing takes time... to measure time needed for operation boxing is better to do before
		// they are not terminated, so no work is done yet
		// if I'll use the same stream twice -> stream has already been operated upon or closed
		{
			long s = System.currentTimeMillis();
			long count = IntStream.of(ints).distinct().count();
			System.out.println(count + " " + (System.currentTimeMillis() - s));
		}
		{
			long s = System.currentTimeMillis();
			long count = IntStream.of(ints).boxed().sorted().distinct().mapToInt(x->x).sum();
			// sorted - стрим знает что он сортед
			System.out.println(count + " " + (System.currentTimeMillis() - s));
		}

		{
			long s = System.currentTimeMillis();
			long count = Stream.of(integers).sorted().distinct().count();
			System.out.println(count + " " + (System.currentTimeMillis() - s));
		}

		// 5 different pseudorandom numbers from 1 to 20 inclusive
		// doesn't matter where I'll write .parallel()
		// .sequential() - it sets the flag
		new Random().ints(1, 21).distinct().limit(5).sum();
	}
}
