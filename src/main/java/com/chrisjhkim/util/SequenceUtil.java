package com.chrisjhkim.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequenceUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(SequenceUtil.class);

	private Deque<Integer> stack;
	private List<int[]> result;
	private int[] input; 
	private boolean[] used;
	
	private SequenceUtil(int[] input) {
		super();
		this.input = input;
		this.stack = new ArrayDeque<>();
		this.result = new ArrayList<>();
		this.used = new boolean[input.length];
		Arrays.fill(used, false);
	}
	
	
//	
	private void permutation(int index, int targetSize) {
		if ( this.stack.size() == targetSize) {
			logger.info("{}", stack);
			
			Integer[] tempArray = this.stack.toArray(new Integer[0]);
			int[] oneResult = new int[this.stack.size()];
			oneResult = this.stack.stream().mapToInt(i->i).toArray();

			this.result.add(oneResult);
		}else {
			for ( int i=0; i < this.input.length ; i ++ ) {
				if ( !used[i]) {
					used[i] = true;
					stack.push(input[i]);
					permutation(index, targetSize);
					stack.pop();
					used[i] = false;
					
				}
			}	
		}
		
	}
	
	
	/**
	 * input 중에서 targetSize개를 뽑음
	 * @param input
	 * @param targetSize
	 * @return
	 */
	public static List<int[]> permutation(int[] input, int targetSize) {
		SequenceUtil util = new SequenceUtil(input);
		util.permutation(targetSize);
		return util.result;
	}


	private void permutation(int targetSize) {
		permutation(0, targetSize);
	}


	public static int permutationCount(int[] input, int targetSize) {
		SequenceUtil util = new SequenceUtil(input);
		util.permutation(targetSize);
		return util.result.size();
	}

	
	public static List<int[]> combination(int[] input, int targetSize){
		SequenceUtil util = new SequenceUtil(input);
		util.combination(targetSize);
		return util.result;
	}


	private void combination(int targetSize) {
		combination(targetSize, 0, this.input.length-1);
		
	}


	private void combination(int targetSize, int start, int end) {
		if ( this.stack.size() == targetSize ) {
			Integer[] tempArray = this.stack.toArray(new Integer[0]);
			int[] oneResult = new int[this.stack.size()];
			oneResult = this.stack.stream().mapToInt(i->i).toArray();
			this.result.add(oneResult);
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
