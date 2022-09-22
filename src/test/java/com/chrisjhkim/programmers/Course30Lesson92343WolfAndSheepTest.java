package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Course30Lesson92343WolfAndSheepTest {

	@Test
	void test() {
		Course30Lesson92343WolfAndSheep solver = new Course30Lesson92343WolfAndSheep();
		assertEquals(5, solver.solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}	, new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}	));
		assertEquals(5, solver.solution(new int[]{0,1,0,1,1,0,1,0,0,1,0}, new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}}	));
	}

}
