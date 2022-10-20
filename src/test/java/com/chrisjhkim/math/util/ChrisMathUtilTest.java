package com.chrisjhkim.math.util;

import static org.junit.jupiter.api.Assertions.*;

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

}
