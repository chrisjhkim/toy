package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import java.security.SecureRandom;
import java.util.Random;

import org.junit.jupiter.api.Test;

class Prob398693PalindromeTest {

	@Test
	void test() {
		Prob398693Palindrome solver = new Prob398693Palindrome();
		int bba = 3/2;
		System.out.println(bba);
		
		
		assertEquals(1, solver.solution("abcde"));
		assertEquals(3, solver.solution("caba"));
		assertEquals(7, solver.solution("abcdcba"));
		StringBuilder sb = new StringBuilder();
		Random rnd = new SecureRandom();
		String a = "abcdefghijklmnopqrstuvwxyz";
		for ( int i = 0 ; i < 2500 ; i ++ ) {
			sb.append(a.charAt(rnd.nextInt(a.length())));
		}
		System.out.println("--------------------------");
		int result = solver.solution(sb.toString());
		System.out.println("result = {}"+ result);
		fail("효율성 테스트 실패....");
	}

}
