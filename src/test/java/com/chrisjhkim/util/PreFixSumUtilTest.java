package com.chrisjhkim.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.chrisjhkim.util.prefixsum.PreFixSumUtil;

class PreFixSumUtilTest {

	@Test
	void test() {
		int[] input = new int[] {1,2,3,4,5};
		PreFixSumUtil util = new PreFixSumUtil(input );
		
		assertEquals(9, util.getSum(2, 4));
		assertEquals(1, util.getSum(1));
		assertEquals(3, util.getSum(2));
		assertEquals(6, util.getSum(3));
		assertEquals(10, util.getSum(4));
		assertEquals(15, util.getSum(5));
		assertEquals(15, util.getSum(1,5));
		assertEquals(1, util.getSum(1,1));
		
		
	}

}
