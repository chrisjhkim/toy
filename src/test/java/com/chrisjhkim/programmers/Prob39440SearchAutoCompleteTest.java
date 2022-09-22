package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob39440SearchAutoCompleteTest {

	@Test
	void testSolution() {
		Prob39440SearchAutoComplete solver = new Prob39440SearchAutoComplete();
		
		assertEquals(7,solver.solution(new String[] {"go","gone","guild"}));
		assertEquals(4,solver.solution(new String[] {"abc","def","ghi","jklm"}));
		assertEquals(15,solver.solution(new String[] {"word","war","warrior","world"}));
		
		
	}

}
