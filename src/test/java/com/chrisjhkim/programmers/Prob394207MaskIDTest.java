package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob394207MaskIDTest {

	Prob394207MaskID solver = new Prob394207MaskID();
	@Test
	void testSolution() {
		
		assertEquals(2, solver.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
		assertEquals(2, solver.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}	, new String[]{"*rodo", "*rodo", "******"}	));
		assertEquals(3, solver.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}	, new String[]{"fr*d*", "*rodo", "******", "******"}));
		
		
	}

	
	@Test
	public void testIdMatches() {
		
		assertTrue(solver.idMatches("abc", "abc"));
		assertTrue(solver.idMatches("abc", "*bc"));
		assertTrue(solver.idMatches("abc", "**c"));
		assertTrue(solver.idMatches("abc", "***"));
		assertTrue(!solver.idMatches("abc", "d**"));
	}
}
