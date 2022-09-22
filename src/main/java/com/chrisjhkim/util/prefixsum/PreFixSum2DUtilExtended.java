package com.chrisjhkim.util.prefixsum;

public class PreFixSum2DUtilExtended extends PreFixSum2DUtil{
	
	private int[][] diffBoard; // 구간 합 계산을 위한 구간합의 미분 
	
	public PreFixSum2DUtilExtended(int[][] input) {
		super(input);
		this.diffBoard = new int[input.length+1][];
		this.diffBoard[0] = new int[input[0].length+1];
		for ( int i = 0 ; i < input.length ; i ++ ) {
			this.diffBoard[i+1] = new int[input[0].length+1];
		}
	}
	
	/**
	 * number 크기의 수를 (startRow, startColumn) 부터 (endRow,endColumn) 을 대각선 끝 모서리로 하는 직사각형에 더한다.
	 * @param number
	 * @param startRow
	 * @param startColumn
	 * @param endRow
	 * @param endColumn
	 */
	public void addNumbers(int number, int startRow, int startColumn , int endRow, int endColumn) {
		diffBoard[startRow][startColumn] += number;
		diffBoard[startRow][endColumn+1] -=number;
		diffBoard[endRow+1][startColumn] -=number;
		diffBoard[endRow+1][endColumn+1] +=number;
	}


	/**
	 * 미분 테이블을 적분하여 구간합 input을 구하고 이를 다시 적분(preFixedSum과 동위)하여 구간합을 구하여 preFixSum과 합친다.
	 */
	public void updatePreFixSum() {
		int boardHeight = super.preFixSumBoard.length-1;
		int boardWidth = super.preFixSumBoard[0].length-1;

		
		int[][] updated  = new int[boardHeight+1][];
		updated[0] = new int[boardWidth+1];
		int[][] preFixSumOfUpdated= new int[boardHeight+1][];
		preFixSumOfUpdated[0] = new int[boardWidth+1];
		
		for ( int i = 0 ; i < boardHeight ; i ++ ) {
			updated[i+1] = new int[boardWidth+1];
			preFixSumOfUpdated[i+1] = new int[boardWidth+1];
			
			for ( int j = 0 ; j < boardWidth ; j ++ ) {
				updated[i+1][j+1] = updated[i+1][j] + updated[i][j+1] - updated[i][j] + diffBoard[i][j];
				preFixSumOfUpdated[i+1][j+1] = preFixSumOfUpdated[i+1][j] + preFixSumOfUpdated[i][j+1] - preFixSumOfUpdated[i][j] + updated[i+1][j+1];
				diffBoard[i][j] = 0;
				super.preFixSumBoard[i+1][j+1] += preFixSumOfUpdated[i+1][j+1];
			}
		}
		
	}

	@Override
	public int[][] getPreFixSumBoard() {
		updatePreFixSum();
		return super.getPreFixSumBoard();
	}

	@Override
	public int[][] getValues() {
		updatePreFixSum();
		return super.getValues();
	}
	
	
	
	
}
