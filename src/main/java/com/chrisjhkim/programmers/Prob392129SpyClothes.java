package com.chrisjhkim.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Prob392129SpyClothes {

	public int solution(String[][] clothes) {
		
		int[] typeCounts = getTypesCounts(clothes);
		
		int multiplier = 1;
		for ( int i = 0 ; i < typeCounts.length ; i ++ ) {
			multiplier = multiplier  * (typeCounts[i]+1);
		}
		
		return multiplier-1;
	}

	// 각 부위별로 몇개씩 있는지 확인
	private int[] getTypesCounts(String[][] clothes) {
		Map<String, Integer> typeCounterMap = new HashMap<>();
		for ( int i = 0 ;i < clothes.length ; i ++ ) {
			String partName = clothes[i][1];
			if ( typeCounterMap.containsKey(partName)){
				int a = typeCounterMap.get(partName)+1;
				typeCounterMap.put(partName, a);
			}else {
				typeCounterMap.put(partName, 1);
			}
		}
		
		int[] result = new int [typeCounterMap.size()];
		int i = 0 ;
		for( Entry<String, Integer> entry : typeCounterMap.entrySet() ){
			result[i++] = entry.getValue();
		}
		return result;
	}
}
