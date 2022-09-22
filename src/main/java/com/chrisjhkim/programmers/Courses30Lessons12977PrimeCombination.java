package com.chrisjhkim.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Courses30Lessons12977PrimeCombination {
	
//	private static final Logger logger = LoggerFactory.getLogger(Courses30Lessons12977PrimeCombination.class);

	private Deque<Integer> stack;
	private List<int[]> combinationResult;

	private int[] input;
	private boolean[] used;
	
	public int solution(int[] nums) {
		int answer = 0;
		this.input = nums;
		this.stack = new ArrayDeque<>();
		this.combinationResult = new ArrayList<>();
		this.used = new boolean[input.length];
		
		combination(3, 0, nums.length-1);
		
		for ( int i = 0 ; i < combinationResult.size() ; i ++ ) {
			int num = 0 ;
			for ( int j = 0 ; j < combinationResult.get(i).length ; j ++ ) {
				num += combinationResult.get(i)[j];
			}
			if ( isPrime(num)) {
				answer++;
			}
		}
		return answer;
	}

	
	public boolean isPrime(int num) {
		for ( int i = 2 ; i < num ; i ++ ) {
			if ( num%i == 0) {
				return false;
			}
		}
		return true;
	}

	

	private void combination(int targetSize, int start, int end) {
		if ( this.stack.size() == targetSize ) {
			int[] oneResult = new int[this.stack.size()];
			oneResult = this.stack.stream().mapToInt(i->i).toArray();
			this.combinationResult.add(oneResult);
//		}else if ( end-start 
		}else {
//			logger.info("@@ {} ", stack);
			for ( int i = start ; i < end+1 ; i ++ ) {
				if ( !used[i]) {
					used[i] = true;
					stack.push(input[i]);
					combination(targetSize, i+1, end);
					stack.pop();
					used[i] = false;
					
				}
			}
		}
		
	}
}
