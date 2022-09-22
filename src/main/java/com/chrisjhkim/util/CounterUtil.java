package com.chrisjhkim.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CounterUtil {
	
	
	public static Map<String, Integer> count(List<Countable> list){
		Map<String, Integer> result = new HashMap<>();
		
		for ( Countable item : list ) {
			if ( result.containsKey(item.getCountKey())) {
				Integer count = result.get(item.getCountKey());
				result.put(item.getCountKey(), count+1);
			}else {
				result.put(item.getCountKey(), 0);
			}
		}
		
		
		return result;
	}
}
