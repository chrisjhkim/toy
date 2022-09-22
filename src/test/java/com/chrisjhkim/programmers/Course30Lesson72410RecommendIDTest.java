package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Course30Lesson72410RecommendIDTest {

	@Test
	void test() {
		Course30Lesson72410RecommendID solver = new Course30Lesson72410RecommendID();
//		solver.solution("!!abc---------");
//		solver.solution("abc.");
//		solver.solution("1234567890123456");
		
		
		assertEquals("abc", solver.solution("abc."));
		assertEquals("bat.y.abcdefghi", solver.solution("...!@BaT#*..y.abcdefghijklm"));
		assertEquals("z--", solver.solution("z-+.^."));
		assertEquals("aaa", solver.solution("=.="));
		assertEquals("123_.def", solver.solution("123_.def"	));
		assertEquals("abcdefghijklmn", solver.solution("abcdefghijklmn.p"	));
		
		
		
	}

}
