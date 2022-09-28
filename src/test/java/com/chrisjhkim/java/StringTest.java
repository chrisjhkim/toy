package com.chrisjhkim.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
@SuppressWarnings("java:S5785")
public class StringTest {

	
	
	@Test
	void testChars() {
		String input = "abc";
//		System.out.println(result);
//		System.out.println(Arrays.toString(result.toArray()));
		fail("stream");
	}
	
	
	@Test
	void testStringMethods() {
		String input = "ABC";
		int result = input.codePointAt(0);
		System.out.println(result);
		System.out.println(input.codePointBefore(1));
		
		System.out.println(input.compareTo("BBC"));
		System.out.println(input.compareTo("aaa"));
		System.out.println(input.compareTo("AAA"));
		System.out.println(input.compareToIgnoreCase("aaa"));
		StringBuilder sb = new StringBuilder();
		sb.append("ABC");
		assertTrue(input.contentEquals(sb));
		
		sb.setLength(0);
		sb.append("BC");
		assertTrue(input.contains(sb));
		sb.append("C");
		assertFalse(input.contains(sb));
		
		String newInput = "ABC";
		
		assertTrue(input.equals(newInput));
	}
	
	@Test
	void testStringFormat() {
		String formatString = "int=%d string=%s STRING=%S floatOrDouble=%f";
		double doubleV = 50.123;
		String result = formatString.formatted(1, "abc", "abc", doubleV);
		System.out.println(result);
	}
	
	@Test
	void testGetChars() {
		String input = "abc";

		char[] dstCharArr = new char[input.length()];

		int srcBegin = 0;
		int srcEnd = input.length();
		int dstBegin = 0;
		input.getChars(srcBegin , srcEnd , dstCharArr , dstBegin );
		
//		System.out.println(Arrays.toString(input.toCharArray()));
//		System.out.println(Arrays.toString(dstCharArr));
		assertTrue(Arrays.equals(input.toCharArray(), dstCharArr));
		
		Charset defaultCharset = Charset.defaultCharset();
		assertTrue("UTF-8".equals(defaultCharset.toString()));
		assertTrue(Arrays.equals(new byte[] {97,98,99}, input.getBytes(defaultCharset)));

		String indentResult = input.indent(2);
		assertTrue(indentResult.equals("  " + input + "\n"));
		assertEquals(input+"\n", indentResult.indent(-2));
		
		assertEquals(0, input.indexOf('a'));
		assertTrue("abcabcabc".equals(input.repeat(3)));
		
		
	}
	
	
	@Test
	void testReplace() {
		String input = "abcdefg";
		input.replace("ab", "zz");
		input.replaceAll("ab", "zz");
		
		fail("정규식");
	}
	
	
}
