package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob393543RemoveRocksDistTest {

	@Test
	void testSolution() {
		Prob393543RemoveRocksDist solver = new Prob393543RemoveRocksDist();
		assertEquals(4, solver.solution(25, new int[] {2, 14, 11, 21, 17}, 2));
//		assertEquals(4, solver.solution(25, new int[] {2, 14, 11, 21, 17}, 2));
	}

}
