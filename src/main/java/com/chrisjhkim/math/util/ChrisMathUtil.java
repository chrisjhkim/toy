package com.chrisjhkim.math.util;

/**
 * The class {@code ChrisMathUtil} contains methods for performing 
 * numeric operations that {@link Math} class doesn't provides
 *
 * @author  chrisjhkim
 */
public final class ChrisMathUtil {
	/**
	 * Don't let anyone instantiate this class.
	 * methods of ChrisMathUtil should be accessed in a static way
	 */
	private ChrisMathUtil() {} 

	/**
	 * 
	 * @param numString1 String form positive integer
	 * @param numString2 String form positive integer 
	 * @return sum of numString1 and numString2 in String form
	 */
	public static String numberAdd(String numString1, String numString2) {
		int maxLength = Math.max(numString1.length(), numString2.length());
		
		final char[] arr1 = new char[maxLength];
		final char[] arr2 = new char[maxLength];
		
		System.arraycopy(numString1.toCharArray(), 0, arr1, maxLength-numString1.length(), numString1.length());
		System.arraycopy("0".repeat(maxLength-numString1.length()).toCharArray(), 0, arr1, 0, maxLength-numString1.length());
		
		System.arraycopy(numString2.toCharArray(), 0, arr2, maxLength-numString2.length(), numString2.length());
		System.arraycopy("0".repeat(maxLength-numString2.length()).toCharArray(), 0, arr2, 0, maxLength-numString2.length());
		boolean up = false;
		for ( int i = 0 ; i < maxLength ; i ++ ) {
			arr1[maxLength-1-i] += arr2[maxLength-1-i] + (up?1:0) -48;
			up = false;
			if ( arr1[maxLength-1-i] > 57) {
				arr1[maxLength-1-i] -=10;					
				up = true;
			}
		}
		if ( up ) {
			return new StringBuilder("1").append(arr1).toString();
		}else {
			return new String(arr1);
		}
		
	}
	
	
	/**
	 * validate if the number is prime or not
	 * note that 1 , 0 and negetive numbers are not prime number
	 * @param input 
	 * @return true if the number is prime
	 */
	public static boolean isPrime(int input) {
		if ( input < 2) return false;
		for ( int i = 2 ; i <= Math.sqrt(input) ; i ++ ) {
			if ( input%i == 0 ) {
				return false;
			}
		}
		return true;
	}
}
