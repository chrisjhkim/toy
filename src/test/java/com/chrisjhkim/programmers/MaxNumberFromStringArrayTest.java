package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chrisjhkim.programmers.MaxNumberFromStringArray.NumString;

class MaxNumberFromStringArrayTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MaxNumberFromStringArrayTest.class);

	@Test
	public void testSolution() {
		MaxNumberFromStringArray solver = new MaxNumberFromStringArray();
		int[] prob1 = {6, 10, 2};
		int[] prob2 = {3, 30, 34, 5, 9};
		
		String answer1 = solver.solution(prob1);
		assertEquals("6210", answer1); 
		String answer2 = solver.solution(prob2);
		assertEquals("9534330", answer2);
		
		
	}

	
}
