package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Prob6536PyramidTest {
	
	private static final Logger logger = LoggerFactory.getLogger(Prob6536PyramidTest.class);


	@Test
	void testProb6536Pyramid() {
		Prob6536Pyramid solver = new Prob6536Pyramid();
		int[] answer1 = {1,2,9,3,10,8,4,5,6,7};
		int[] answer2 = {1,2,12,3,13,11,4,14,15,10,5,6,7,8,9};
		int[] answer3 = {1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11};
		assertTrue(Arrays.equals(answer1, solver.solution(4)));
		assertTrue(Arrays.equals(answer2, solver.solution(5)));
		assertTrue(Arrays.equals(answer3, solver.solution(6)));
		
	}

}
