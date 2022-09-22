package com.chrisjhkim.toy;

import org.junit.jupiter.api.Test;

class NemoSolverTest {
	@Test
	public void testNemoSolver() {
		int size = 5;
		int[] prob = {2,2};
		NemoSolver solver = new NemoSolver(size, prob);
		int[] result = solver.solve();
	}
}
