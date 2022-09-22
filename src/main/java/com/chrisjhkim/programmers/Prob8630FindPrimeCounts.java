package com.chrisjhkim.programmers;

import java.util.Arrays;

public class Prob8630FindPrimeCounts {
	

	public int solution(int n, int k) {
		String changedDigit = changeToDigit(n, k);
		int[] numbers = getNumbersInDigit10(changedDigit, k);
		int answer = countPrimeNumbers(numbers);
		
		return answer;
	}
	
		
	public String changeToDigit(int n, int k ) {
		int rest = n;
		StringBuilder sb = new StringBuilder();
		while ( rest / k != 0 ) {
			sb.insert(0	, rest%k);
			rest = rest/k;
		}
		sb.insert(0	, rest%k);
		System.out.println(n + " " + k + " -> " + sb );
		return sb.toString();
	}
	
	private int[] getNumbersInDigit10 (String newDigitNum, int k) {
		int[] result;
		String[] numbers = newDigitNum.split("0",-1);
		result = new int[numbers.length];
		for ( int i = 0  ; i < numbers.length ; i ++ ) {
			if ( !numbers[i].isEmpty()) {
				String kDigitNum = numbers[i];
//				String tenDigitNum = changeTo10Digit(kDigitNum, k);
				
				
				result[i] = Integer.parseInt(kDigitNum);
			}
		}
		System.out.println(newDigitNum + " -> " + Arrays.toString(result));
		return result;
	}
	private int countPrimeNumbers(int...numbers) {
		int result = 0;
		for ( int num : numbers) {
			if ( num!=1 && num!= 0 &&  isPrime(num)) {
				result ++;
			}
		}
		return result;
	}
//	private String changeTo10Digit(String kDigitNum, int k) {
//		char[] n = kDigitNum.toCharArray();
//		System.out.println("start " + kDigitNum + " " + k);
//		StringBuilder sb = new StringBuilder();
//		int result = 0;
//		for ( int i = 0 ; i < kDigitNum.length(); i ++ ) {
//			int multiplier = 1;
//			for (int j = 0 ; j < i ; j ++ ) {
//				multiplier = multiplier * k;
//			}
//			
//			int add = (n[kDigitNum.length()-i-1]-48) * multiplier;
//			System.out.println("add " + add);
//			result += add;
//		}
//		System.out.println("result " + result);
//		return result+"";
//	}
	public boolean isPrime(int n) {
		
		for (int i = 2; i<=(int)Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
