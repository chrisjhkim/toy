package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob399407PortalTextSearchTest {

	@Test
	void test() {
		Prob399407PortalTextSearch solver = new Prob399407PortalTextSearch();
//		assertEquals(1, solver.solution(new String[]{"go"}	));
		assertEquals(6, solver.solution(new String[]{"ab","ac","ad"}	));
		assertEquals(8, solver.solution(new String[]{"a","go","gone","guild"}	));
		assertEquals(7, solver.solution(new String[]{"go","gone","guild"}	));
		assertEquals(4, solver.solution(new String[]{"abc","def","ghi","jklm"}		));
		assertEquals(15, solver.solution(new String[]{"word","war","warrior","world"}		));
				
	}

}
