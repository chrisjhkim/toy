package com.chrisjhkim.tree.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayTreeHandler {
/*
 *      8
 *    3   10
 *   1  6    x  14(7)
 * x x 4 7 x x 13(14) x
 * In-order: 1 3 4 6 7 8 10 13 14
 * Pre-order: 8 3 1 6 4 7 10 14 13
 * Post-order: 1 4 7 6 3 13 14 10 8
 * Level-order: 8 3 10 1 6 14 4 7 13
 */
	public static Integer[] getInOrder(Integer[] heap) {
		List<Integer> listResult = new ArrayList<>();
		inOrder(heap, 1, listResult);
		return listResult.toArray(new Integer[0]);
	}
	private static void inOrder(Integer[] heapRef, int currentP, List<Integer> listResult) {
		if( leftNodeExists(heapRef, currentP)) {
			inOrder(heapRef, currentP*2, listResult);
		}
		listResult.add(heapRef[currentP]);
		if ( rightNodeExists(heapRef, currentP)) {
			inOrder(heapRef, currentP*2+1, listResult);
		}
	}
	
	public static Integer[] getPreOrder(Integer[] heap) {
		List<Integer> listResult = new ArrayList<>();
		preOrder(heap, 1, listResult);
		return listResult.toArray(new Integer[0]);
	}
	private static void preOrder(Integer[] heapRef, int currentP, List<Integer> listResult) {
		listResult.add(heapRef[currentP]);
		if( leftNodeExists(heapRef, currentP)) {
			preOrder(heapRef, currentP*2, listResult);
		}
		if ( rightNodeExists(heapRef, currentP)) {
			preOrder(heapRef, currentP*2+1, listResult);
		}
	}
	
	public static Integer[] getPostOrder(Integer[] heap) {
		List<Integer> listResult = new ArrayList<>();
		postOrder(heap, 1, listResult);
		return listResult.toArray(new Integer[0]);
	}
	private static void postOrder(Integer[] heapRef, int currentP, List<Integer> listResult) {
		if( leftNodeExists(heapRef, currentP)) {
			postOrder(heapRef, currentP*2, listResult);
		}
		if ( rightNodeExists(heapRef, currentP)) {
			postOrder(heapRef, currentP*2+1, listResult);
		}
		listResult.add(heapRef[currentP]);
	}
	public static Integer[] getLevelOrder(Integer[] heap) {
		List<Integer> listResult = new ArrayList<>();
		for ( int i = 0 ;i < heap.length ; i ++ ) {
			if ( heap[i]!= null ) {
				listResult.add(heap[i]);
			}
		}
		return listResult.toArray(new Integer[0]);
	}



	private static boolean rightNodeExists(Integer[] heapRef, int currentP) {
		return ( currentP *2+1 < heapRef.length && heapRef[currentP*2+1]!=null );
	}

	private static boolean leftNodeExists(Integer[] heapRef, int currentP) {
		return ( currentP *2 < heapRef.length && heapRef[currentP*2]!=null );
	}
}
