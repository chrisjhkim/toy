package com.chrisjhkim.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Prob394103HighwayCameras {

	public int solution(int[][] routes) {
		
		
		Arrays.sort(routes, this::compare);
		Queue<int[]> que = new ArrayDeque<>();
		Collections.addAll(que, routes);

		List<int[]> list = new ArrayList<>(); 
		
		int camCount = 0;
		while ( !que.isEmpty() || !list.isEmpty()) {
			if ( list.isEmpty() ) {
				list.add(que.poll());
			}else {
				int[] nextCar = que.peek();
				if ( nextCar == null || firstOut(list) <  nextCar[0] ){
					// 다음차가 들어오기전에 먼저 나가면
					list.clear();
					camCount++;
				}else {
					list.add(que.poll());
				}
			}
		}
		
		return camCount;
	}

	private int compare(int[] item1, int[] item2) {
		if ( item1[0] == item2[0] ) {
			return item1[1]-item2[1];
		}
		return item1[0] - item2[0];
	}
	
	private int firstOut(List<int[]> list) {
		if ( list.isEmpty() )throw new IllegalArgumentException();
		int min = 999999999;
		for ( int i = 0 ;i < list.size() ; i ++ ) {
			min = Math.min(min, list.get(i)[1]);
		}
		return min;
	}

}
