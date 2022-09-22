package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Courses30Lessons12977PrimeCombinationTest {
	Courses30Lessons12977PrimeCombination solver = new Courses30Lessons12977PrimeCombination();
	
	@Test
	public void testAnswer() {
		assertEquals(1, solver.solution(new int[] {1,2,3,4}	));
		System.out.println();
		System.out.println();
		System.out.println();
		assertEquals(4,solver.solution(new int[] {1,2,7,6,4}		));
	}

	@Test
	void testPrime() {
		
		assertTrue(solver.isPrime(2));
		assertTrue(solver.isPrime(3));
		assertTrue(!solver.isPrime(4));
		assertTrue(solver.isPrime(5));
		assertTrue(!solver.isPrime(6));
		assertTrue(solver.isPrime(7));
		assertTrue(!solver.isPrime(8));
		assertTrue(!solver.isPrime(9));
		assertTrue(!solver.isPrime(10));
		assertTrue(solver.isPrime(11));
		assertTrue(!solver.isPrime(12));
		assertTrue(solver.isPrime(13));
		assertTrue(!solver.isPrime(14));
		assertTrue(!solver.isPrime(15));
		assertTrue(!solver.isPrime(16));
		assertTrue(solver.isPrime(17));
		assertTrue(!solver.isPrime(18));
		assertTrue(solver.isPrime(19));
		assertTrue(!solver.isPrime(20));
		assertTrue(!solver.isPrime(21));
		assertTrue(!solver.isPrime(22));
	}

}
