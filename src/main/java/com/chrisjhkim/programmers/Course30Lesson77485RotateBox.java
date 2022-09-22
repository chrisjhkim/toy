package com.chrisjhkim.programmers;

import java.util.Arrays;

import javax.management.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Course30Lesson77485RotateBox {

	
	private static final Logger logger = LoggerFactory.getLogger(Course30Lesson77485RotateBox.class);


	
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = {};
		int[][] box = new int[rows][columns];
		int k = 1;
		for ( int i = 0 ; i < rows ; i ++ ) {
			for ( int j = 0 ;j < columns ; j ++ ) {
				box[i][j] = k++;
			}
		}
		
		printBox(box);
		
		for ( int i = 0 ; i < queries.length ; i ++ ) {
			box = rotateBox(box, queries[i]);
			printBox(box);
		}
		return answer;
	}
	
	private int[][] rotateBox(int[][] box, int[] is) {
		System.out.println("query="+Arrays.toString(is));
		int x1=is[0]; //2
		int y1=is[1]; //2
		int x2=is[2]; //5
		int y2=is[3]; //4
		
		int temp = -1;
		// 오른쪽으로
//		temp = box[y1-1][x2-2];
//		System.out.println("temp = " + temp);
//		for ( int i = 1 ; i < x2-x1 ; i ++ ) {
//			System.out.println(box[y1-1][x2-1-i]);
//			box[y1-1][x2-1-i]=box[y1-1][x2-2-i];
//		}
		
		// 아래로
		for ( int i = 0 ; i < y2-y1 ; i ++ ) {
			System.out.println(box[y1-1][x1-1]);
//			box[y1-1][x2-1-i]=box[y1-1][x2-2-i];
		}
//		
//		// 왼쪽으로
//		for ( int i = x1 ; i < x2 ; i ++ ) {
//			System.out.println(box[y1-1][i-1]);
//		}
//		
//		// 위로
//		for ( int i = x1 ; i < x2 ; i ++ ) {
//			System.out.println(box[y1-1][i-1]);
//		}
		
		return box;
	}

	private void printBox(int[][] box) {
		logger.info(Arrays.deepToString(box));
		for ( int i = 0; i < box.length ; i ++ ) {
			logger.info(Arrays.toString(box[i]));
			
		}
	}

}
