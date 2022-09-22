package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob8630FindPrimeCountsTest {

	@Test
	void testSolution() {
		Prob8630FindPrimeCounts solver = new Prob8630FindPrimeCounts();
		assertEquals(3,  solver.solution(437674, 3));
		assertEquals(2,  solver.solution(110011, 10));
		assertEquals(1,  solver.solution(3, 4));
		
	}
	
	@Test
	public void testChnageDigits() {
		Prob8630FindPrimeCounts solver = new Prob8630FindPrimeCounts();
		assertEquals("101", solver.changeToDigit(5, 2));
		assertEquals("111", solver.changeToDigit(7, 2));
		assertEquals("101", solver.changeToDigit(10, 3));
	}

}
