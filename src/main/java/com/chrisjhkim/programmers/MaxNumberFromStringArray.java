package com.chrisjhkim.programmers;

import java.util.Arrays;

public class MaxNumberFromStringArray {
	public String solution(int[] numbers) {
		
		NumString[] arr = new NumString[numbers.length];
		for ( int i = 0 ; i < numbers.length;  i ++ ) {
			arr[i] = new NumString(numbers[i]);
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for ( NumString num : arr) {
			sb.append(num.num);
		}
		
		return sb.toString();
	}
	public class NumString implements Comparable<NumString>{
		public String num;

		public NumString(int num) {
			super();
			this.num = num+"";
		}

		@Override
		public int compareTo(NumString o) {
			char[] a = this.num.toCharArray();
			char[] b = o.num.toCharArray();
			int p = 0;
			while ( p < a.length && p < b.length ) {
				if ( a[p] > b[p] ) {
					return -1;
				}else if ( a[p] < b[p] ) {
					return 1;
				}else {
					p++;
				}
			}
			if ( p == a.length ) {
				if ( a[p-1] > b[p] ) {
					return -1;
				}else {
					return 1;
				}

			}else if ( p == b.length ) {
				if ( b[p-1] > a[p] ) {
					return 1;
				}else {
					return -1;
				}
			}
		
			return 0;
		}

		@Override
		public String toString() {
			return this.num;
		}
		
		
	}
}
