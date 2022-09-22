package com.chrisjhkim.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prob6536Pyramid {
	
	private static final Logger logger = LoggerFactory.getLogger(Prob6536Pyramid.class);

	public int[] solution(int n) {
		int[] answer = {};
		
		
		
		int[][] pyramid = makeEmptyPyramid(n);
		logger.info(Arrays.deepToString(pyramid));
		fillPyramid(pyramid);
		logger.info(Arrays.deepToString(pyramid));
		List<Integer> list = new ArrayList<>();
		for ( int i = 0 ;i < pyramid.length ; i ++ ) {
			Arrays.stream( pyramid[i] ).boxed().collect( Collectors.toList() );
			list.addAll(Arrays.stream( pyramid[i] ).boxed().collect( Collectors.toList() ));
		}
		logger.info("-->>>> {}", list);
		return Arrays.stream(list.toArray(new Integer[list.size()])).mapToInt(Integer::intValue).toArray();
	}
	private enum Direction {
		LD, R, UL
	}
	private void fillPyramid(int[][] pyramid) {
		int limit = (pyramid.length)*(pyramid.length+1)/2;
		int x = 0;
		int y = 0;
		Direction dir = Direction.LD;
		pyramid[x][y] = 1;
		for ( int i = 1 ; i < limit ; i ++ ) {
			if ( dir == Direction.LD ) {
				x ++;
				if ( x+1 == pyramid.length || pyramid[x+1][y] != 0 ) {
					dir = Direction.R;
				}
			}else if ( dir == Direction.R ) {
				y++;
				if ( y+1 == pyramid.length || pyramid[x][y+1]!= 0 ) {
					dir = Direction.UL;
				}
			}else {
				y--;
				x--;
				if ( pyramid[x-1][y-1] != 0 ) {
					dir = Direction.LD;
				}
			}
			pyramid[x][y] = i+1;
			
		}

		
	}

	private int[][] makeEmptyPyramid(int size) {
		int[][] result = new int[size][];
		for ( int i = 0 ; i < size ; i ++ ) {
			result[i] = new int[i+1];
		}
		return result;
	}

}
