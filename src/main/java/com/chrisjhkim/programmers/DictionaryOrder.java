package com.chrisjhkim.programmers;

import java.util.ArrayList;
import java.util.List;

public class DictionaryOrder {
	
	List<String> list = new ArrayList<>();
	
	
	public DictionaryOrder() {
		super();
		dfs("A");
	}

	private void dfs(String input) {
		list.add(input);
		if ( input.length() < 5 ) {
			dfs(input+"A");
		}
		String nextWord = next(input);
		if ( nextWord != null ) {
			dfs(nextWord);
		}
		
	}

	private String next(String input) {
		if ( input.charAt(input.length()-1) == 'A'){
			return input.substring(0, input.length()-1) + 'E';
		}else if ( input.charAt(input.length()-1) == 'E'){
			return input.substring(0, input.length()-1) + 'I';
		}else if ( input.charAt(input.length()-1) == 'I'){
			return input.substring(0, input.length()-1) + 'O';
		}else if ( input.charAt(input.length()-1) == 'O'){
			return input.substring(0, input.length()-1) + 'U';
		}else {
			return null;
		}
	}

	public int solution(String word) {
		for ( int i = 0 ; i < list.size() ; i ++ ) {
			if ( list.get(i).equals(word)) {
				return i+1;
			}
		}
		return -1;
	}		
	
}
