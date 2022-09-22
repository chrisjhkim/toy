package com.chrisjhkim.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Prob6085OperatorOrderMaxNumberTest {

	@Test
	public void testProb6085OperatorOrderMaxNumber() {
		Prob6085OperatorOrderMaxNumber solver = new Prob6085OperatorOrderMaxNumber();
		assertEquals( 60420	, solver.solution("100-200*300-500+20" ));
		assertEquals( 300	, solver.solution("50*6-3*2" ));
	
		
	}

}
