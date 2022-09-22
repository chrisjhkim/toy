package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BiggestRectTest {

	@Test
	void test() {
		BiggestRect solver = new BiggestRect();
		int[][] prob1 = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int answer1 = solver.solution(prob1);
		assertEquals(9, answer1);
		int[][] prob2 = {{0,0,1,1},{1,1,1,1}}	;
		int answer2 = solver.solution(prob2);
		assertEquals(4, answer2);
	}

}
