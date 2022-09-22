package com.chrisjhkim.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;


public class Prob393543RemoveRocksDist {
//	private static final Logger logger = LoggerFactory.getLogger(Prob393543RemoveRocksDist.class);

	public int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		//logger.info("input = {}", Arrays.toString(rocks));
		rocks = new int[] {2,11, 14,17, 21};
		
		int[][] tests = removeRocks(rocks, n); 
		//logger.info("tests = {}", Arrays.deepToString(tests));
//		rocks = new int[] {11, 21,27};
		int maxDist = -1;
		for ( int i = 0 ; i < tests.length ; i ++ ) {
			maxDist = Math.max(maxDist,  getMinDist(tests[i], distance));
		}
		
		return maxDist;
	}

	private int[][] removeRocks(int[] rocks, int n) {
		//logger.info("input = {} , {} ", Arrays.toString(rocks), n);
		int[] rockNumbers = new int[rocks.length];
		for (int i = 0 ;i < rockNumbers.length ; i ++ ) {
			rockNumbers[i] = i;
		}
		//logger.info("{} ", Arrays.toString(rockNumbers));
		
		
		
		List<int[]> removeCombinationList = getCombination(rockNumbers, n);
		
		int[][] result = new int[removeCombinationList.size()][];
		for ( int i = 0 ;i < removeCombinationList.size() ; i ++ ) {
			Arrays.sort(removeCombinationList.get(i));
			//logger.info("remove {}  rocks", Arrays.toString(removeCombinationList.get(i)));
			result[i] = new int[rocks.length-n];
			
			int p = 0;
			int removeP = 0;
			for ( int j = 0 ; j < rocks.length; j ++ ) {
				if ( removeP < removeCombinationList.get(i).length  
						&& removeCombinationList.get(i)[removeP] == j ) { 
					removeP++;
				}else {
					result[i][p++] = rocks[j];
				}
			}
			
			//logger.info("removed result = {}", Arrays.toString(result[i]));
//			
		}
		
		
		
		return result;
	}

	private List<int[]> getCombination(int[] rockNumbers, int n) {
		Deque<Integer> stack = new ArrayDeque<>();;
		List<int[]> result = new ArrayList<>();;
		int[] input = rockNumbers;
		boolean[] used = new boolean[rockNumbers.length];;
		Arrays.fill(used, false);
		combination(n, 0, rockNumbers.length-1, stack, result, used, input);
		
		return result;
	}
	private void combination(int targetSize, int start, int end, Deque<Integer> stack, List<int[]> result, boolean[] used, int[] input) {
		if ( stack.size() == targetSize ) {
			Integer[] tempArray = stack.toArray(new Integer[0]);
			int[] oneResult = new int[stack.size()];
			oneResult = stack.stream().mapToInt(i->i).toArray();
			result.add(oneResult);
//		}else if ( end-start 
		}else {
//			//logger.info("@@ {} ", stack);
			for ( int i = start ; i < end+1 ; i ++ ) {
				if ( !used[i]) {
					used[i] = true;
					stack.push(input[i]);
					combination(targetSize, i+1, end, stack, result, used, input);
					stack.pop();
					used[i] = false;
					
				}
			}
		}
		
	}
	private int getMinDist(int[] rocks, int distance) {
		int result = 1000000000;
		result = Math.min(result, rocks[0]);
		result = Math.min(result, distance-rocks[rocks.length-1]);
		for ( int i = 0 ;i < rocks.length-1 ; i ++ ) {
			result = Math.min(result, rocks[i+1]-rocks[i]);
		}
		//logger.info("min = {} in n={}, {}", result, distance, Arrays.toString(rocks));
		return result;
	}
	
	

}
