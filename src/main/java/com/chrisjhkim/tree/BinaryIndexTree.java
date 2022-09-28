package com.chrisjhkim.tree;

/**
 * A.K.A Fenwick Tree
 * @author chris1108
 *
 * @param <T>
 */
public class BinaryIndexTree {
	private int[] arr;

	public BinaryIndexTree(int[] input) {
		super();
		this.arr = new int[input.length+1];
		
		for ( int i = 0 ;i < input.length ; i ++ ) {
			if ( i%2 == 1) {
				this.arr[i+1] = input[i];
			}
		}
		// 1  2    3    4 
		// 1   10 11  11 
		// 10  20  30   40
		// 10  30   30   
	}
	
	
	
	
	


}
