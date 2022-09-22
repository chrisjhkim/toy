package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob392206PathFirstTimeTest {

	@Test
	void testProb392206PathFirstTime() {
		Prob392206PathFirstTime solver = new Prob392206PathFirstTime();
		assertEquals(7, solver.solution("ULURRDLLU"));
		assertEquals(7, solver.solution("LULLLLLLU"));
		
	}

}
