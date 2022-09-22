package com.chrisjhkim.programmers;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prob392206PathFirstTime {
	
//	private static final Logger logger = LoggerFactory.getLogger(Prob392206PathFirstTime.class);

	
	private Set<String> dotToDotPath = null;
	public int solution(String dirs) {
		dotToDotPath = new HashSet<>();
		char[] moves = dirs.toCharArray();
		moveAndSave(moves);
		
		return dotToDotPath.size();
	}
	private void moveAndSave(char[] moves) {
		int x = 5 ;
		int y = 5 ;
		
		for ( int i = 0 ; i < moves.length ; i ++ ) {
			if ( moves[i] == 'U' && y > 0) {
				saveIfPossible(x,y, x,y-1);
				y --;
			}else if ( moves[i] == 'D' && y < 10 ) {
				saveIfPossible(x,y, x,y+1);
				y ++;
				
			}else if ( moves[i] == 'R' && x < 10) {
				saveIfPossible(x, y, x+1, y);
				x++;
			}else if ( moves[i] == 'L' && x > 0) {
				saveIfPossible(x, y, x-1, y);
				x--;
			}
			
		}
		
		
	}
	private void saveIfPossible(int x1, int y1, int x2, int y2) {
		String path = null;
		if ( x1 == x2 ) {		
			if ( y1 > y2 ) {
				path = ""+x2+y2+x1+y1;
			}else {
				path = ""+x1+y1+x2+y2;
			}
		}else {
			if ( x1 > x2 ) {
				path = ""+x2+y2+x1+y1;
			}else {
				path = ""+x1+y1+x2+y2;
			}
		}
		dotToDotPath.add(path);
	}
}
