package den.util;

import java.util.ArrayList;
import java.util.Iterator;


public class PrimeNumList {
	private static ArrayList<Long> primeNumList = new ArrayList<Long>(); // Prime number list
	private static long calculatedNum = 1; // Prime num listed max number

	/**
	 * Private constructor. Static APIs only.
	 */
	private PrimeNumList(){}

	/**
	 * Return list contains prime nums up to given argument.
	 * @param num :Argument for list max number.
	 * @return ArrayList type. Ascending order of prime numbers list.
	 *         The given argument "num" is 1 or less, return empty list.
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Long> getPrimeNumList(long num){
		// 1 or less
		if(1 >= num) return new ArrayList<Long>();

		// return the culculated list
		if(num < calculatedNum){
			ArrayList<Long> list = new ArrayList<Long>();
			for(long n : primeNumList){
				if(n > num ) break;
				list.add(n);
			}
			return list;
		}

		// reculculate
		calcPrimeNum(num);
		return (ArrayList<Long>) primeNumList.clone();
	}

	/**
	 * Calculate prime numbers up to given argument, hold static list.
	 * @param num
	 */
	private static void calcPrimeNum(long num){
		if(num <= calculatedNum) return;
		for(long i = calculatedNum + 1 ; i <= num ; i++){
			boolean isPrime = true;
			Iterator<Long> ite = primeNumList.iterator();
			while(ite.hasNext())
			{
				long primeNum = ite.next();
				if( 0 == (i % primeNum) )
				{
					// not prime
					isPrime = false;
					break;
				}
			}
			if(isPrime) primeNumList.add(i);
		}
		calculatedNum = num;
	}
}
