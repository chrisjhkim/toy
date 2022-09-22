package com.chrisjhkim.baekjoon;

import java.util.Scanner;

public class P1806PreFixSum {

	/**
input
10 15
5 1 3 5 10 7 4 9 2 8

expected output
2

input
10 15
5 1 3 5 10 7 4 19 2 8

expected output
1


input
10 20
5 1 3 5 10 7 4 9 2 8

expected output
1




	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrSize = sc.nextInt();
		int targetSum = sc.nextInt();
//		int[] testInput = new int[arrSize];
		int[] preFixSum = new int[arrSize+1];
		for ( int i = 0 ; i < arrSize ; i ++ ) {
			int item = sc.nextInt();
//			testInput[i] = item;
			preFixSum[i+1] = preFixSum[i]+item;
		}
//		System.out.println("targetSum="+targetSum);
//		System.out.println("input="+Arrays.toString(testInput));
//		System.out.println("preFixSum = "+Arrays.toString(preFixSum));
		
		int pStart = 1;
		int pEnd = 1;
		int answer = Integer.MAX_VALUE;
		while ( pStart < arrSize +1 && pEnd < arrSize+1 ) {
			int testSum = getSum(preFixSum, pStart, pEnd);
			if ( testSum < targetSum) {
				pEnd ++;
			}else {
//				System.out.println(pStart + " ~ " +pEnd + " -> " + testSum);
				answer = Math.min(answer, (pEnd-pStart+1));
				pStart++;
			}
		}
		if ( answer == Integer.MAX_VALUE ) {
			System.out.println(0);
		}else {
			System.out.println(answer);
		}
		sc.close();
	}

	private static int getSum(int[] preFixSum,  int startIndex, int lastIndex) {
		return preFixSum[lastIndex] - preFixSum[startIndex-1];
	}
	
}
