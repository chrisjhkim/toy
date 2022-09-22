package com.chrisjhkim.util;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class FileUtilTest {

	@Test
	void testFileCopyTest() throws IOException {
		FileUtil.doCopy();
		
		
	}
	
	@Test
	public void testMakeDir() throws IOException {
		FileUtil.makeDir("tempDirectoryMakeTest/bbb");
	}

}
