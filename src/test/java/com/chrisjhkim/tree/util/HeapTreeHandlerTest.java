package com.chrisjhkim.tree.util;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.chrisjhkim.tree.util.HeapTreeHandler;

class HeapTreeHandlerTest {

	@Test
	void testPrintTree() {
//		int[] heapData = new int[] {-10,10,20,30,40,50,60,70};
//		TreeHandler.printTree(heapData);
		HeapTreeHandler.printTree(new Integer[] {-10,10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170});
		
	}
	
	
	
	@Test
	public void testIntegerArrayStartWithNull() {
		Integer[] arr = new Integer[4];
		
		System.out.println(Arrays.toString(arr));
		assertNull(arr[0]);
	}

	
	
	@Test
	public void testGet() {
		Integer[] input = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 };
		
		Integer[] minHeap = HeapTreeHandler.getMinHeapTree(input);
		HeapTreeHandler.printTree(minHeap);
	}	
	
	
	@Test
	public void testGetHeapTree() {
		Integer[] input = new Integer[] {10, 20 , 30, 15, 9 };
		
		Integer[] minHeap = HeapTreeHandler.getMinHeapTree(input);
		HeapTreeHandler.printTree(minHeap);
		Integer[] maxHeap = HeapTreeHandler.getMaxHeapTree(input);
		HeapTreeHandler.printTree(maxHeap);
	}
}
