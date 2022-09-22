package com.chrisjhkim.programmers;

public class BiggestRect {
	
	
	public int solution(int [][]board)
	{
		int max = 0;
		for ( int i = 0 ; i < board.length ; i ++ ) {
			for ( int j = 0 ; j < board[i].length ; j ++ ) {
				int nodeMax = 0; 
				if ( board[i][j] == 1 ) {
					nodeMax =1;
					int testBoxSize = 2;
					while ( lowSideIs1(testBoxSize, i, j, board ) && rightSideIs1(testBoxSize, i, j , board) && cornerIs1(testBoxSize, i, j , board) ) {
						nodeMax +=1;
						testBoxSize +=1;
					}
					max = Math.max(nodeMax, max);
					
				}
			}
		}
		
		return max*max;
	}

	private boolean cornerIs1(int testBoxSize, int i, int j, int[][] board) {
		return ( board[i+testBoxSize-1][j+testBoxSize-1] == 1 ) ;
	}

	private boolean rightSideIs1(int testBoxSize, int i, int j, int[][] board) {
		if ( j+testBoxSize-1 < board[0].length) {
			for ( int jj = 0 ; jj < testBoxSize-1 ; jj ++ ) {
				if ( board[i+jj][j+testBoxSize-1] == 0)
					return false;
			}
			return true;
		}
		return false;
	}

	private boolean lowSideIs1(int testBoxSize, int i, int j, int[][] board) {
		if ( i+testBoxSize-1 < board.length) {
			for ( int ii = 0 ; ii < testBoxSize-1 ; ii ++ ) {
				if ( board[i+testBoxSize-1][j+ii] == 0)
					return false;
			}
			return true;
		}
		return false;
	}
	
	
	
	

}
