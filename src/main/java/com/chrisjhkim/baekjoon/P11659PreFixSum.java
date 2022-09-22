package com.chrisjhkim.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P11659PreFixSum {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int count = sc.nextInt();
		
//		sc.nextLine();
		int[] numbers = new int[size];
		int[] preFixSum = new int[size+1];
		
		for ( int i = 0 ;i < size ; i ++) {
			int item = sc.nextInt();
			numbers[i] = item;
			preFixSum[i+1] = preFixSum[i] + item;
		}
//		System.out.println();
//		System.out.println("size="+size);
//		System.out.println("count="+count);
//		System.out.println("input     =   "+Arrays.toString(numbers));
//		System.out.println("preFixSum ="+Arrays.toString(preFixSum));
//		System.out.println();
		for ( int i = 0 ; i < count ; i ++ ) {
//			sc.nextLine();
			int startIndex = sc.nextInt();
			int lastIndex = sc.nextInt();
//			int sum = preFixSum[lastIndex] - preFixSum[startIndex-1];
			System.out.println(preFixSum[lastIndex] - preFixSum[startIndex-1]);
		}
//		System.out.println();
		sc.close();
	}

}

