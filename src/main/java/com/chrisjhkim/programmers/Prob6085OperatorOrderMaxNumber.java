package com.chrisjhkim.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chrisjhkim.util.SequenceUtil;

@SuppressWarnings("java:S125")
public class Prob6085OperatorOrderMaxNumber {
	
	
	private static final Logger logger = LoggerFactory.getLogger(Prob6085OperatorOrderMaxNumber.class);

	private static final int PLUS = 0;
	private static final int MINUS = 1;
	private static final int MULTI = 2;
	

	public long solution(String expression) {
		int[] operators = getOperators(expression);
		List<int[]> operatorOrders = SequenceUtil.permutation(operators, operators.length);
		ArrayList<String> equation = (ArrayList<String>) splitToEquation(expression);
		int max = 0;
		for ( int i = 0 ; i < operatorOrders.size() ; i ++ ) {
			@SuppressWarnings("unchecked")
			List<String> copied = (ArrayList<String>)equation.clone(); 
			Collections.copy(copied, equation);
			int tryResult = Math.abs(calculateWithOrder(operatorOrders.get(i), copied));
			
			logger.info("@@ {} -> {}", Arrays.toString(operatorOrders.get(i)), tryResult);
			max = Math.max(max, Math.abs(tryResult));
		}
		return max;
	}

	private int calculateWithOrder(int[] operatorOrders, List<String> equation) {
		//logger.info("try with order {}", Arrays.toString(operatorOrders));
//		char plus  = '+';	//43	// 0 
//		char minus = '-';	//45	// 1
//		char multi = '*';	//42	// 2
//		//logger.info("{}", (int)plus);
//		//logger.info("{}", (int)minus);
//		//logger.info("{}", (int)multi);
		for ( int i = 0 ;i < operatorOrders.length ; i ++ ) {
			if ( operatorOrders[i] == 0) {
				// plus
				for ( int j = 0 ; j < equation.size() ; j ++ ){
					if ( equation.get(j).equals("+")) {
						//logger.info("{} {} {} ", equation.get(j-1), equation.get(j), equation.get(j+1));
						//logger.info("{}", equation);
						int result = Integer.parseInt(equation.get(j-1)) + Integer.parseInt(equation.get(j+1));
						equation.set(j-1, result+"");
						equation.remove(j+1);
						equation.remove(j);
						j = j-2;
						//logger.info("{}", equation);
					}
				}
			}else if( operatorOrders[i] == 1) {
				// minus
				for ( int j = 0 ; j < equation.size() ; j ++ ){
					if ( equation.get(j).equals("-")) {
						//logger.info("{} {} {} ", equation.get(j-1), equation.get(j), equation.get(j+1));
						//logger.info("{}", equation);
						int result = Integer.parseInt(equation.get(j-1)) - Integer.parseInt(equation.get(j+1));
						equation.set(j-1, result+"");
						equation.remove(j+1);
						equation.remove(j);
						j = j-2;
						//logger.info("{}", equation);
					}
				}
			}else if( operatorOrders[i] == 2) {
				// multi
				for ( int j = 0 ; j < equation.size() ; j ++ ){
					if ( equation.get(j).equals("*")) {
						//logger.info("{} {} {} ", equation.get(j-1), equation.get(j), equation.get(j+1));
						//logger.info("{}", equation);
						int result = Integer.parseInt(equation.get(j-1)) * Integer.parseInt(equation.get(j+1));
						equation.set(j-1, result+"");
						equation.remove(j+1);
						equation.remove(j);
						j = j-2;
						//logger.info("{}", equation);
					}
				}
			}
			
			
		}
		if ( equation.size() > 1 ){
			throw new IllegalArgumentException();
		}
		return Integer.parseInt(equation.get(0));
	}

	private List<String> splitToEquation(String expression) {
		ArrayList<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < expression.length() ; i ++ ) {
			if ( Character.isDigit(expression.charAt(i)) ) {
				// start number
				sb.append(expression.charAt(i));
				
				// or continue number
			}else {
				// finish prev number
//				sb.append(expression.charAt(i-1));
				list.add(sb.toString());
				sb.setLength(0);
				// and add operator
				list.add(expression.charAt(i)+"");
			}
		}
		list.add(sb.toString());
		//logger.info("{} -> {}", expression, list);
		return list;
	}

	// 안에 있는 operator 종류들을 list로 return
	private int[] getOperators(String expression) {
		Deque<Integer> stack = new ArrayDeque<>();
		if (expression.indexOf('+') > -1) {
			stack.add(PLUS);
		}
		
		if (expression.indexOf('-') > -1) {
			stack.add(MINUS);
		}
		
		if (expression.indexOf('*') > -1) {
			stack.add(MULTI);
		}
		
		int[] result = new int[stack.size()];
		int i = 0 ; 
		while (!stack.isEmpty() ) {
			result[i++] = stack.pop();
		}
		return result;
	}
	
	
	
}
