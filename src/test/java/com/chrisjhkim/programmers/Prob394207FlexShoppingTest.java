package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Prob394207FlexShoppingTest {

	@Test
	void testSolution() {
		Prob394207FlexShopping solver = new Prob394207FlexShopping();
		
		assertTrue(Arrays.equals(new int[] {3,7}, solver.solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}	)));
		assertTrue(Arrays.equals(new int[] {1,3}, solver.solution(new String[] {"AA", "AB", "AC", "AA", "AC"}		)));
		assertTrue(Arrays.equals(new int[] {1,1}, solver.solution(new String[] {"XYZ", "XYZ", "XYZ"}		)));
		assertTrue(Arrays.equals(new int[] {1,5}, solver.solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}		)));
	}

}
