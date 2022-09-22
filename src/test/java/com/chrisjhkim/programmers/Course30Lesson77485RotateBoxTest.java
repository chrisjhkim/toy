package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Course30Lesson77485RotateBoxTest {

	@Test
	void test() {
		Course30Lesson77485RotateBox solver = new Course30Lesson77485RotateBox();
		assertTrue( Arrays.equals(new int[]{8, 10, 25}, solver.solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}}	)));
		assertTrue( Arrays.equals(new int[]{1, 1, 5, 3}, solver.solution(3,3,new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}})));	
		assertTrue( Arrays.equals(new int[]{1}, solver.solution(100,97,new int[][]{{1,1,100,97}}	)));
		
	}

}
