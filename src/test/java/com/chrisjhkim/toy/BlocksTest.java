package com.chrisjhkim.toy;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//import org.junit.jupiter.api.Test;
//import org.slf4j.LoggerFactory;


class BlocksTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BlocksTest.class);

	@Test
	void testCopy() {
		int[] prob = {2,2};
		Blocks origin = new Blocks(prob );
		
		
		Blocks copied = Blocks.copy(origin);
		logger.info("origin : {}", origin);
		logger.info("copied : {}", copied);
		
	}

}
