package com.chrisjhkim.tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {
	static BinarySearchTree<Integer> bst;
	@BeforeAll
	public static void setUp() {
		bst = new BinarySearchTree<>();
		List<Integer> set= new ArrayList<>();
		set.add(8);
		set.add(3);
		set.add(10);
		set.add(1);
		set.add(6);
		set.add(4);
		set.add(7);
		set.add(14);
		set.add(13);
		for ( Integer item : set) {
			bst.insert(new BinaryNode<>(item));
		}
	}
	
	@Test
	void testGetLargest() {
		assertEquals(14, bst.getLargest());
	}
	@Test
	void testGetSmallest() {
		assertEquals(1, bst.getSmallest());
	}
	
	/*
	 *      8
	 *    3   10
	 *   1  6    x  14(p=7)
	 * x x 4 7 x x 13(p=14) x
	 * In-order: 1 3 4 6 7 8 10 13 14
	 * Pre-order: 8 3 1 6 4 7 10 14 13
	 * Post-order: 1 4 7 6 3 13 14 10 8
	 * Level-order: 8 3 10 1 6 14 4 7 13
	 */
	@Test
	void testHeight() {
		
		assertEquals(4, bst.height());
		assertEquals(4, bst.getRootNode().height());
		assertEquals(3, bst.getRootNode().getRightNode().height());
		assertEquals(3, bst.getRootNode().getLeftNode().height());
	}
	
	@Test
	void testSize() {
		assertEquals(9, bst.size());										// 8
		assertEquals(5, bst.getRootNode().getLeftNode().size()); 	// 3
		assertEquals(3, bst.getRootNode().getRightNode().size());	// 10
		assertEquals(1, bst.getRootNode().getLeftNode().getLeftNode().size()); 	//1
		assertEquals(3, bst.getRootNode().getLeftNode().getRightNode().size()); 	//6
		assertEquals(1, bst.getRootNode().getLeftNode().getRightNode().getLeftNode().size()); 	//4
		assertEquals(1, bst.getRootNode().getLeftNode().getRightNode().getRightNode().size()); 	//7
		assertEquals(3, bst.getRootNode().getRightNode().size());	// 10
		assertEquals(2, bst.getRootNode().getRightNode().getRightNode().size());	// 14
		assertEquals(1, bst.getRootNode().getRightNode().getRightNode().getLeftNode().size());	// 13
		
//		assertEquals(5, bst.getRootNode().getLeftNode().sizeTest()); 	// 3
//		assertEquals(3, bst.getRootNode().getRightNode().sizeTest());	// 10
//		assertEquals(1, bst.getRootNode().getLeftNode().getLeftNode().sizeTest()); 	//1
//		assertEquals(3, bst.getRootNode().getLeftNode().getRightNode().sizeTest()); 	//6
//		assertEquals(1, bst.getRootNode().getLeftNode().getRightNode().getLeftNode().sizeTest()); 	//4
//		assertEquals(1, bst.getRootNode().getLeftNode().getRightNode().getRightNode().sizeTest()); 	//7
//		assertEquals(3, bst.getRootNode().getRightNode().sizeTest());	// 10
//		assertEquals(2, bst.getRootNode().getRightNode().getRightNode().sizeTest());	// 14
//		assertEquals(1, bst.getRootNode().getRightNode().getRightNode().getLeftNode().sizeTest());	// 13
		
	}

}
