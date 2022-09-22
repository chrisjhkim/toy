package com.chrisjhkim.tree;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chrisjhkim.toy.Block;

class BinarySearchTreeTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BinarySearchTreeTest.class);

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
	void testInsert() {
		int testSize = 6;
		int itemMaxNum = 15;
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		Random rnd = new SecureRandom();
//		Set<Integer> set = new HashSet<>();
		List<Integer> set = new ArrayList<>();
		while ( set.size() < testSize ) {
			int item = rnd.nextInt(itemMaxNum);
			if ( !set.contains(item)) {
				set.add(item);
			}
		}
		

		logger.info("item to insert to tree = {}", set);
		for ( Integer item : set) {
			bst.insert(new BinaryNode<>(item));
		}
		logger.info("bst Insert Result = {}", Arrays.toString(bst.getInOrder().toArray()));
		
	}
	@Test
	public void testExpectedOrder() {
		/*
		 *           8
		 *      3       10
		 *   1   6    x    14(7)
		 * x x  4 7  x x  13(14) x
		 * 
		 * In-order: 1 3 4 6 7 8 10 13 14
		 * Pre-order: 8 3 1 6 4 7 10 14 13
		 * Post-order: 1 4 7 6 3 13 14 10 8
		 * Level-order: 8 3 10 1 6 14 4 7 13
		 */
		List<Integer> inOrderResult = bst.getInOrder();
		assertTrue(Arrays.equals(new Integer[] {1,3,4,6,7,8,10,13,14}, inOrderResult.toArray()  ) );
		List<Integer> preOrderResult = bst.getPreOrder();
		assertTrue(Arrays.equals(new Integer[] {8,3,1,6,4,7,10,14,13}, preOrderResult.toArray()  ) );
		List<Integer> postOrderResult = bst.getPostOrder();
		assertTrue(Arrays.equals(new Integer[] {1,4,7,6,3,13,14,10,8}, postOrderResult.toArray()  ) );
		List<Integer> levelOrderResult = bst.getLevelOrder();
		assertTrue(Arrays.equals(new Integer[] {8,3,10,1,6,14,4,7,13}, levelOrderResult.toArray()  ) );
	}

}
