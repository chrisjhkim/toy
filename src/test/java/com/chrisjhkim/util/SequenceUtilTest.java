package com.chrisjhkim.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SequenceUtilTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SequenceUtilTest.class);

	@Test
	public void testPermutation() {
		
		int[] input = {1,2,3};
		List<int[]> result = SequenceUtil.permutation(input , 3);
		for ( int i = 0 ; i < result.size() ; i ++ ) {
			logger.info("{}", Arrays.toString(result.get(i)));
		}
		
		assertEquals(6, SequenceUtil.permutationCount(input, 3));
		assertEquals(6, SequenceUtil.permutationCount(input, 2));
		
		
		int[] input4 = {1,2,3,4};
		assertEquals(24, SequenceUtil.permutation(input4, 4).size());
		assertEquals(24, SequenceUtil.permutation(input4, 3).size());
		assertEquals(12, SequenceUtil.permutation(input4, 2).size());
		
		int[] input8 = {1,2,3,4,5,6,7,8};
		List<int[]> result8 = SequenceUtil.permutation(input8 , 8);
		assertEquals(40320, result8.size());
		
	}

	
	@Test
	public void testCombination() {
		int[] input = {1,2,3};
		List<int[]> result = SequenceUtil.combination(input, 2);
		for ( int i = 0 ; i < result.size() ; i ++ ) {
			logger.info("{}", Arrays.toString(result.get(i)));
		}
	}
	
//	@Test
//	void testTempFactorial() {
//		assertEquals(1, SequenceUtil.factorial(1));
//		assertEquals(2, SequenceUtil.factorial(2));
//		assertEquals(6, SequenceUtil.factorial(3));
//		assertEquals(24, SequenceUtil.factorial(4));
//		assertEquals(120, SequenceUtil.factorial(5));
//		assertEquals(720, SequenceUtil.factorial(6));
//	}

}
