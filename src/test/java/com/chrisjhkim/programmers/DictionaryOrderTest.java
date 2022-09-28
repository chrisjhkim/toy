package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DictionaryOrderTest {
	DictionaryOrder solver = new DictionaryOrder();
	@Test
	void test() {
		solver.solution("AE");
		assertEquals(6, solver.solution("AAAAE"));
		assertEquals(10, solver.solution("AAAE"));
		assertEquals(1563, solver.solution("I"));
		assertEquals(1189, solver.solution("EIO"));
	}

}
