package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob10065HowManyDungeonsTest {

	@Test
	void test() {
		Prob10065HowManyDungeons solver = new Prob10065HowManyDungeons();
		int[][] prob1 = {{80,20},{50,40},{30,10}};
		assertEquals(3, solver.solution(80, prob1 ));
	}

}
