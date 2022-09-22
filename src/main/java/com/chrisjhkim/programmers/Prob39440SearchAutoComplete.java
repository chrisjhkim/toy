package com.chrisjhkim.programmers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prob39440SearchAutoComplete {
	
	private static final Logger logger = LoggerFactory.getLogger(Prob39440SearchAutoComplete.class);

	public int solution(String[] words) {
		int answer = 0;
		
		
		for ( int i = 0 ; i < words.length ; i ++ ) {
			logger.info("check word {}", words[i]);
			for ( int j = 0 ; j < words[i].length() ; j ++ ) {
				if ( j+1 == words[i].length() ) {
					logger.info("check word {} full word. ", words[i]);
					answer = answer + j+1;
					break;
				}else {
					String subString = words[i].substring(0,j+1);
					logger.info("check word {} with {}", words[i], subString);
					
//					boolean moreThanOne = false;
//					for ( int k = 0 ; k < words.length ; k ++ ) {
//						if ( i!= k ) {
////							words[i].substring(i)
//							if ( words[k].startsWith(subString)) {
//								moreThanOne = true;
//							}
//						}else {
//							logger.info("skip {} - {} ", words[i], words[k]);
//						}
//					}
//					
				}
//					
			}
			logger.info("---------");
		}
		return answer;
	}
	

}
