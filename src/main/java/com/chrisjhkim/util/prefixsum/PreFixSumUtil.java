package com.chrisjhkim.util.prefixsum;

/**
 * input이 변하지 않을 경우 먼저 preFixSum 을 구해두고 
 * 이후 부분합을 구한다.
 * @author chris1108
 *
 */
public class PreFixSumUtil {
	
	protected int[] preFixSum;

	public PreFixSumUtil(int[] input) {
		super();
		this.preFixSum = new int[input.length+1];
		for ( int i = 0 ; i < input.length ; i ++ ) {
			preFixSum[i+1] = preFixSum[i]+input[i];
		}
	}
	
	private int insertP = 0;
	public PreFixSumUtil(int size) {
		super();
		this.preFixSum = new int[size+1];
		insertP = 1;
	}
	public void insert(int item) {
		this.preFixSum[insertP] = this.preFixSum[insertP-1] + item;
		insertP++;
	}
	
	/**
	 * lastIndex 번째 숫자 까지의 합을 구한다.
	 * @param lastIndex (preFixSum배열의 lastIndex가 아닌 실제 lastIndex 번째이다.)
	 * @return
	 */
	public int getSum(int lastIndex) {
		return preFixSum[lastIndex];
	}
	
	/**
	 * startIndex 번째 숫자 부터 lastIndex번째 숫자 까지의 합을 구한다.
	 * @param startIndex (preFixSum배열의 startIndex 번째가 아닌 실제 startIndex 번째이다.)
	 * @param lastIndex (preFixSum배열의 lastIndex 번째가 아닌 실제 lastIndex 번째이다.)
	 * @return
	 */
	public int getSum(int startIndex, int lastIndex) {
		return preFixSum[lastIndex]-preFixSum[startIndex-1];
	}

	/**
	 * index 번쨰 아이템 구한다.
	 * @param index 
	 * @return
	 */
	public int intAt(int index) {
		return preFixSum[index] - preFixSum[index-1];
	}

}
