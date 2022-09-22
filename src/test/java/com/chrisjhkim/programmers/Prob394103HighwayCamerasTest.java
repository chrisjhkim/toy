package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob394103HighwayCamerasTest {

	@Test
	void testProb394103HighwayCameras() {
		Prob394103HighwayCameras solver = new Prob394103HighwayCameras();
			
		assertEquals(2, solver.solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
		assertEquals(4, solver.solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}, {0,5} ,{0,1},{0,2},{4,6}}));
	}

}
