package com.chrisjhkim.util.prefixsum;

public class PreFixSum2DUtil {

	protected int[][] preFixSumBoard;

	public PreFixSum2DUtil(int[][] input) {
		super();
		
		this.preFixSumBoard = new int[input.length+1][];
		this.preFixSumBoard[0] = new int[input[0].length+1];
		for ( int i = 0 ; i < input.length ; i ++ ) {
			this.preFixSumBoard[i+1] = new int[input[0].length+1];
			for ( int j = 0 ; j < input[0].length; j ++ ) {
				this.preFixSumBoard[i+1][j+1] = this.preFixSumBoard[i+1][j] + this.preFixSumBoard[i][j+1] - this.preFixSumBoard[i][j]+ input[i][j] ;
			}
		}
	}

	public int[][] getPreFixSumBoard() {
		return preFixSumBoard;
	}

	
	public int valueAt(int row, int column) {
		if ( row > this.preFixSumBoard[0].length || column > this.preFixSumBoard.length ) {
			throw new IllegalArgumentException("input out of box");
		}
		return this.preFixSumBoard[row+1][column+1] 
				- this.preFixSumBoard[row][column+1]
				- this.preFixSumBoard[row+1][column]
				+ this.preFixSumBoard[row][column];
	}
	
	public int[][] getValues(){
		int[][] result = new int[this.preFixSumBoard.length-1][];
		for ( int i = 0 ;i < result.length ; i ++ ) {
			result[i] = new int[this.preFixSumBoard[i].length-1];
			for ( int j = 0 ; j < result[i].length ; j ++ ) {
				result[i][j] = valueAt(i, j);
			}
		}
		return result;
	}
}
