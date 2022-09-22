package com.chrisjhkim.programmers.kakao2022;

import com.chrisjhkim.util.prefixsum.PreFixSum2DUtilExtended;

public class UnDestroyedBuildings {
	int[][] preFixDiff;
	public int solution(int[][] board, int[][] skill) {
		PreFixSum2DUtilExtended util = new PreFixSum2DUtilExtended(board);
		
		for ( int i = 0 ; i < skill.length ; i ++ ) {
			if ( skill[i][0] == 1) {
				util.addNumbers(-skill[i][5], skill[i][1], skill[i][2], skill[i][3], skill[i][4]);
			}else {
				util.addNumbers(skill[i][5], skill[i][1], skill[i][2], skill[i][3], skill[i][4]);
				
			}
		}
		util.updatePreFixSum();
		int answer = 0;
		for ( int i = 0 ;i < board.length ; i ++ ) {
			for ( int j = 0 ; j < board[0].length ; j ++ ) {
				if ( util.valueAt(i, j) > 0 ) {
					answer++;
				}
			}
		}
		return answer;
	}

}
