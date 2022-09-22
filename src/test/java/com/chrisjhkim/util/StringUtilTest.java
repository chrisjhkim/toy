package com.chrisjhkim.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilTest {

	@Test
	void testIsFirstInDictionary() {
		assertTrue(StringUtil.isFirstInDictionary("a", "b"));
		assertTrue(!StringUtil.isFirstInDictionary("b", "a"));
		assertTrue(StringUtil.isFirstInDictionary("a", "abc"));
		assertTrue(!StringUtil.isFirstInDictionary("abc", "a"));
		assertTrue(StringUtil.isFirstInDictionary("aaa", "aab"));
	}

}
