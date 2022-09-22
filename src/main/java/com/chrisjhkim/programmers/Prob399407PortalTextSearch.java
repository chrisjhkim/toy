package com.chrisjhkim.programmers;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prob399407PortalTextSearch {
	
	private static final Logger logger = LoggerFactory.getLogger(Prob399407PortalTextSearch.class);

	private String[] sorted; 
	public int solution(String[] words) {
		int answer = 0;
		Arrays.sort(words);
		sorted = words;
		logger.info(Arrays.toString(words));
		boolean[] done;

		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < words.length ; i ++ ) {
			boolean moreThanOne = false;
			for ( int j = 0 ; j < words[i].length() ; j ++ ) {
//				if ( )
				sb.append(words[i].charAt(j));
				logger.info("test {} {}", i, sb.toString());
				
				if ( words[i].length() == sb.length()) {
					answer += j+1;
					break;
				}else {
					for ( int k = i+1 ; k < words.length ; k ++ ) {
						if ( words[k].startsWith(sb.toString())) {
							moreThanOne = true;
							break;
						}
					}
					if ( !moreThanOne ) {
						answer += j+1;
						break;
					}				
					
				}
				
			}
		}
		return answer;
	}
	private boolean moreThanOne(String searchText , int currentIndex ) {
		return false;
	}


}
