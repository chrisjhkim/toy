package com.chrisjhkim.math.util;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class ChrisMathUtilTest {

	@Test
	void testNumberAdd() {
		
		assertEquals("1245", ChrisMathUtil.numberAdd("11", "1234"));
		assertEquals("1245", ChrisMathUtil.numberAdd("1234", "11"));
		assertEquals("10122", ChrisMathUtil.numberAdd("4567", "5555"));
		assertEquals("1000000", ChrisMathUtil.numberAdd("999999", "1"));
		assertEquals("100000000000000000000000000000000000000000000000000000000000000000000000000000", ChrisMathUtil.numberAdd("99999999999999999999999999999999999999999999999999999999999999999999999999999", "1"));
		
	}
	
	
	@Test
	void testMultiply(){
		assertEquals("1", ChrisMathUtil.numberMultiply("1", "1"));
		assertEquals("0", ChrisMathUtil.numberMultiply("1", "0"));
		assertEquals("23115", ChrisMathUtil.numberMultiply("345", "67"));
		
		for ( int i = 0 ; i < 200 ; i ++ ) {
			for ( int j = 0 ; j < 200 ; j ++ ) {
				assertEquals(String.valueOf(i*j), ChrisMathUtil.numberMultiply(String.valueOf(i), String.valueOf(j)));
			}
		}
	}

	
	@Test
	public void testGetFactorizationInPrimeFactors() throws IOException {
		ChrisMathUtil.getFactorizationInPrimeFactors(1200);
		ChrisMathUtil.getFactorizationInPrimeFactors(143);
		
		
		ChrisMathUtil.getFactorizationInPrimeFactors(100000234);
	}
	
	
	@Test
	public void testGetPrimeNumFactorOfFactorial() {
		assertEquals(3, ChrisMathUtil.getPrimeNumFactorOfFactorial(5, 2));
		assertEquals(1, ChrisMathUtil.getPrimeNumFactorOfFactorial(5, 3));
		assertEquals(1, ChrisMathUtil.getPrimeNumFactorOfFactorial(5, 4));
		assertEquals(1, ChrisMathUtil.getPrimeNumFactorOfFactorial(5, 5));
		assertEquals(0, ChrisMathUtil.getPrimeNumFactorOfFactorial(5, 6));
		assertEquals(0, ChrisMathUtil.getPrimeNumFactorOfFactorial(5, 17));
	}
	
	@Test
	public void testGetGcdOf() {
		assertEquals(2, ChrisMathUtil.getGcdOf(6, 8));
		assertEquals(6, ChrisMathUtil.getGcdOf(12, 18));
		assertEquals(4, ChrisMathUtil.getGcdOf(8, 12));
		assertEquals(2, ChrisMathUtil.getGcdOf(2, 4));
		assertEquals(2, ChrisMathUtil.getGcdOf(2, 6));
		assertEquals(7, ChrisMathUtil.getGcdOf(77, 91));
		assertEquals(6, ChrisMathUtil.getGcdOf(18, 24));
		assertEquals(12, ChrisMathUtil.getGcdOf(36, 48));
		assertEquals(4, ChrisMathUtil.getGcdOf(4, 4));
		assertEquals(3, ChrisMathUtil.getGcdOf(3, 3));
		assertEquals(2, ChrisMathUtil.getGcdOf(2, 2));
	}
	
	@Test
	void testGetLcmOf() {
		assertEquals(24, ChrisMathUtil.getLcmOf(6, 8));
		assertEquals(6, ChrisMathUtil.getLcmOf(2, 3));
		assertEquals(4, ChrisMathUtil.getLcmOf(2, 4));
		assertEquals(8, ChrisMathUtil.getLcmOf(2, 8));
		assertEquals(24, ChrisMathUtil.getLcmOf(12, 8));
		assertEquals(1001, ChrisMathUtil.getLcmOf(77, 91));
		assertEquals(99990000, ChrisMathUtil.getLcmOf(9999, 10000));
		
		
	}
}
