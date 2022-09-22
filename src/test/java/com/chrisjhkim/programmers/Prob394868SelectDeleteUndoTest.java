package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob394868SelectDeleteUndoTest {
	
	@Test
	void test() {
		Prob394868SelectDeleteUndo solver = new Prob394868SelectDeleteUndo();
		
		assertEquals("OOOOXOOO", solver.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}	));
		assertEquals("OOXOXOOO", solver.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}	));
		fail("효율성 테스트에서 실패함");
	}

}
