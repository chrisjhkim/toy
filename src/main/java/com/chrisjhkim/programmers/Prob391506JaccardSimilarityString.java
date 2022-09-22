package com.chrisjhkim.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prob391506JaccardSimilarityString {
	private static final Logger logger = LoggerFactory.getLogger(Prob391506JaccardSimilarityString.class);

	public int solution(String str1, String str2) {
		List<String> set1 = getStringSets(str1);
		List<String> set2 = getStringSets(str2);
		
		int unionSize = getUnionSize(set1, set2);
		int intersectionSize = getIntersectionSize(set1, set2);
		
		int answer = 0;
		
		if ( intersectionSize == 0 ) {
			return 65536;
		}else{
			logger.info("{} / {} ", intersectionSize, unionSize );
			return intersectionSize * 65536 / unionSize;
		
		}
	}
	private int getIntersectionSize(List<String> set1, List<String> set2) {
		logger.info("getIntersectionSize {} , {}", set1 , set2);
		List<String> interList = new ArrayList<>();
		for ( String ele : set2 ) {
			logger.info("@@ {} {} ", set1, ele);
			for ( int i = 0 ; i < set1.size() ; i ++ ) {
				if ( ele.equalsIgnoreCase(set1.get(i))) {
					set1.remove(i);
					interList.add(ele);
					break;
				}
			}
		}
		logger.info("getIntersectionSize {} , {} -> {}", set1, set2, interList);
		return interList.size();
	}
	private int getUnionSize(List<String> set1, List<String> set2) {
		logger.info("getUnionSize {} , {}", set1 , set2);
		HashMap<String, Integer> set1CountMap = new HashMap<>();
		List<String> unionList = new ArrayList<>();
		for ( String ele : set1 ) {
			ele = ele.toUpperCase();
			if ( set1CountMap.containsKey(ele)) {
				Integer temp = set1CountMap.get(ele);
				set1CountMap.put(ele, temp+1);
			}else {
				set1CountMap.put(ele, 1);
			}
			unionList.add(ele);
		}
		logger.info("step1 set1CountMap={}", set1CountMap);
		
		for ( String ele : set2 ) {
			ele = ele.toUpperCase();
			if ( set1CountMap.containsKey(ele) ) {
				if ( set1CountMap.get(ele)> 0 ) {
					int count = set1CountMap.get(ele);
					set1CountMap.put(ele, count-1);
				}else {
					unionList.add(ele);
				}
			}else {
				unionList.add(ele);
			}
		}
		logger.info("step2 set1CountMap={}", set1CountMap);
		
		logger.info("getUnionSize {} , {} -> {}", set1 , set2, unionList);
		return unionList.size();
	}
	
	
	public List<String> getStringSets(String str1) {
		//타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다
		logger.info("getStringSets {} ", str1);
		List<String> list = new ArrayList<>();
		for ( int i = 0 ; i < str1.length()-1 ; i ++ ) {
			String element = str1.substring(i, i+2);
			if ( element.matches("[a-zA-Z]+")) {
				logger.info("O {}", element);
				list.add(element);
			}else {
				logger.info("X {}", element);
			}
		}
		
//		String[] result = list.toArray(new String[list.size()]);
//		logger.info("getStringSets {} -> {}", str1, Arrays.toString(result));
		logger.info("getStringSets {} -> {}", str1, list);
		return list;
//		return result;
	}
}
