package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob392129SpyClothesTest {

	@Test
	void testProb392129SpyClothes() {
		Prob392129SpyClothes solver = new Prob392129SpyClothes();
		
		String[][] prob1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] prob2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		
		assertEquals(5, solver.solution(prob1 ));
		assertEquals(3, solver.solution(prob2 ));
	}

}
