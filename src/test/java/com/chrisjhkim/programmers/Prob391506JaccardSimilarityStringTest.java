package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob391506JaccardSimilarityStringTest {

	@Test
	void test() {
		Prob391506JaccardSimilarityString solver = new Prob391506JaccardSimilarityString();
//		assertEquals(9999999, solver.solution("aaaa", "aaabb"));
		assertEquals(16384, solver.solution("FRANCE", "french"));
		assertEquals(65536, solver.solution("handshake", "shake hands"));
		assertEquals(43690, solver.solution("aa1+aa2", "AAAA12"));
		assertEquals(65536, solver.solution("E=M*C^2", "e=m*c^2"));
	}

}
