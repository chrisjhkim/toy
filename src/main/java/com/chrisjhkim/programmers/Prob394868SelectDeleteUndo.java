package com.chrisjhkim.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

@SuppressWarnings("java:S125")
public class Prob394868SelectDeleteUndo {
	
//	private static final Logger logger = LoggerFactory.getLogger(Prob394868SelectDeleteUndo.class);

	
	public String solution(int n, int p, String[] cmd) {
//		logger.info("{} {} {} ", n, p, Arrays.toString(cmd));
		ArrayList<String> list = new ArrayList<>();
		for ( int i = 0 ; i < n ; i ++ ) {
			list.add(i+"");
		}
//		list.add("무지");
//		list.add("콘");
//		list.add("어피치");
//		list.add("제이지");
//		list.add("프로도");
//		list.add("네오");
//		list.add("튜브");
//		list.add("라이언");
		Deque<ArrayList<String>> stack = new ArrayDeque<>();
//		logger.info("start {}", list);  
		for ( int i = 0 ; i < cmd.length ; i ++ ) {
//			logger.info("{} ", list);
			if ( cmd[i].equals("C")) {
				@SuppressWarnings("unchecked")
				ArrayList<String> item= (ArrayList<String>)list.clone();
				stack.add(item);
				if ( p == list.size()-1 ) {
					list.remove(p);
					p--;
				}else {
					list.remove(p);
				}
//				logger.info("C");
				
			}else if (cmd[i].equals("Z")) {
//				list = stack.poll();
				String temp = list.get(p);
				list = stack.pop();
//				logger.info("Z");
				if ( !temp.equals(list.get(p))) {
					p++;
				}
//				logger.info("{} -> {}", temp, list.get(p));
			}else {
				int move = Integer.parseInt(cmd[i].substring(2));
				if ( cmd[i].startsWith("D")) {
//					logger.info("D {}", move);
					p += move;
				}else {
//					logger.info("U {}", move);
					p -= move;
					
				}
				
			}
			if ( !stack.isEmpty()) {
//				logger.info("stack = {}", stack);
			}
//			logger.info("p = {}", p);
//			logger.info("{} ", list);
//			logger.info("---------------------------");
		}
//		logger.info("{} ", list);
//		logger.info("p = {}", p);
//		logger.info("---------------------------");
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < n ; i ++ ) {
			if ( list.contains(i+"")) {
				sb.append('O');
			}else {
				sb.append('X');
			}
		}
		return sb.toString();
	}

}
