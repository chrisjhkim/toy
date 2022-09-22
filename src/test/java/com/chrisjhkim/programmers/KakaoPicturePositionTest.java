package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KakaoPicturePositionTest {

	@Test
	void testSolution() {
		KakaoPicturePosition solver = new KakaoPicturePosition();
		 
		String[] prob1 = {"N~F=0", "R~T>2"};
		int answer1 = solver.solution(2, prob1);
		assertEquals(3648, answer1);
		
		String[] prob2 = {"M~C<2", "C~M>1"};
		int answer2 = solver.solution(2, prob2);
		assertEquals(0, answer2);
	}

}
