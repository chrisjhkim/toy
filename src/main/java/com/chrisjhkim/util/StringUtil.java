package com.chrisjhkim.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

	
	public static boolean isFirstInDictionary(String str1 , String str2) {
		
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		int p = 0;
		while ( p <a.length && p<b.length) {
			if ( a[p] < b[p] ) {
				logger.info("{} < {}", a[p], b[p]);
				return true;
			}else if ( a[p] > b[p] ) {
				logger.info("{} > {}", a[p], b[p]);
				return false;
			}else {
				logger.info("{} = {}", a[p], b[p]);
				p++;
			}
		}
		return a.length < b.length;
	}

}
