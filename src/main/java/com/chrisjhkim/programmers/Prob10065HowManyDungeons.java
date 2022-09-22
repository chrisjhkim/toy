package com.chrisjhkim.programmers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prob10065HowManyDungeons {
	
	private static final Logger logger = LoggerFactory.getLogger(Prob10065HowManyDungeons.class);


	public int solution(int k, int[][] dun) {
		int answer = -1;
		logger.info("{}", dun.length);
		int facto = 1;
		for ( int i = 1; i < dun.length+1; i ++ ) {
			facto = facto * i;
		}
		logger.info("{}", facto);
		int[][] dunOrder = new int[facto][dun.length];
		
		int[] refOrder = new int[dun.length];// {1,2,3};
		for ( int i = 0 ; i < dun.length ; i ++ ) {
			refOrder[i] = i;
		}
		dunOrder[0] = refOrder;
		for ( int i = 1 ; i < dunOrder.length +1; i ++ ) {
			if ( i == 0 ) {
				for ( int j = 0 ; j < dun.length ; j ++ ) {
					dunOrder[0][j] = refOrder[j];
				}
			}else {
				if ( i %2 == 1 ) {
//					dunOrder[i][0] = refOrder
				}
				
			}
		}
		
		return answer;
	}
	
}
