package com.chrisjhkim.util.prefixsum;

public class UPreFixSumUtil extends PreFixSumUtil{
	private int[] diffArr;
	
	public UPreFixSumUtil(int[] input) {
		super(input);
		this.diffArr = new int[input.length+1];
	}

	
	public void addNumbers(int number, int startIndex, int lastIndex) {
		diffArr[startIndex-1] += number;
		diffArr[lastIndex] -= number;
	}
	
	
	public void updatePreFixSum() {
		int diffSum = 0;
		int currentDiff = 0;
		for ( int i = 0 ; i < diffArr.length-1 ; i ++ ) {
			currentDiff = currentDiff + diffArr[i];
			diffSum = currentDiff + diffSum;
			super.preFixSum[i+1] = super.preFixSum[i+1] + diffSum;
			diffArr[i] = 0;
		}
		diffArr[diffArr.length-1]=0;
	}


	@Override
	public int getSum(int lastIndex) {
		updatePreFixSum();
		return super.getSum(lastIndex);
	}


	@Override
	public int getSum(int startIndex, int lastIndex) {
		updatePreFixSum();
		return super.getSum(startIndex, lastIndex);
	}
	
}
