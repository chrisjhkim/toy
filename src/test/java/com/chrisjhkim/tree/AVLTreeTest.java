package com.chrisjhkim.tree;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chrisjhkim.tree.util.HeapTreeHandler;

public class AVLTreeTest {
	private static final Logger logger = LoggerFactory.getLogger(AVLTreeTest.class);
	
	@Test
	void testInsertRR() {
		AVLTree<Integer> avlTree = new AVLTree<>();
		avlTree.insert(new BinaryNode<>(1));
		avlTree.insert(new BinaryNode<>(2));
		avlTree.insert(new BinaryNode<>(3));
		logger.info("avl result = {}", avlTree.getRootNode());
		// TODO
	}
	@Test
	void testInsertRL() {
		AVLTree<Integer> avlTree = new AVLTree<>();
		avlTree.insert(new BinaryNode<>(1));
		avlTree.insert(new BinaryNode<>(3));
		avlTree.insert(new BinaryNode<>(2));
		logger.info("avl result = {}", avlTree.getRootNode());
		// TODO
	}
	@Test
	void testInsertLL() {
		AVLTree<Integer> avlTree = new AVLTree<>();
		avlTree.insert(new BinaryNode<>(3));
		avlTree.insert(new BinaryNode<>(2));
		avlTree.insert(new BinaryNode<>(1));
		logger.info("avl result = {}", avlTree.getRootNode());
	}
	@Test
	void testInsertLR() {
		AVLTree<Integer> avlTree = new AVLTree<>();
		avlTree.insert(new BinaryNode<>(3));
		avlTree.insert(new BinaryNode<>(1));
		avlTree.insert(new BinaryNode<>(2));
		logger.info("avl result = {}", avlTree.getRootNode());
	}
	
	@Test
	void testToHeapArray() {
		AVLTree<Integer> avlTree = new AVLTree<>();
		avlTree.insert(new BinaryNode<>(4));
		avlTree.insert(new BinaryNode<>(2));
		avlTree.insert(new BinaryNode<>(6));
		avlTree.insert(new BinaryNode<>(1));
		avlTree.insert(new BinaryNode<>(2));
		avlTree.insert(new BinaryNode<>(5));
		avlTree.insert(new BinaryNode<>(7));
//		avlTree.insert(new BinaryNode<>(3));
		logger.info("avl result = {}", avlTree.getRootNode());
		Object[] heapArray = avlTree.toHeapArray();
		logger.info("avlTree to HeapArray  = {}", Arrays.toString(heapArray));
		List<Object[]> printingArrList = HeapTreeHandler.getTreePrintingArrayList(heapArray);
		for ( int i = 0 ; i < printingArrList.size() ; i ++ ) {
			logger.info(Arrays.toString(printingArrList.get(i)));
		}
		HeapTreeHandler.printAsTree(heapArray);
		
		HeapTreeHandler.printAsTree(heapArray, "x");
	}
	@Test
	void testToHeapArray2() {
		AVLTree<Integer> avlTree = new AVLTree<>();
		avlTree.insert(new BinaryNode<>(1));
		avlTree.insert(new BinaryNode<>(2));
		avlTree.insert(new BinaryNode<>(3));
		avlTree.insert(new BinaryNode<>(4));
		avlTree.insert(new BinaryNode<>(5));
		avlTree.insert(new BinaryNode<>(6));
		avlTree.insert(new BinaryNode<>(7));
//		avlTree.insert(new BinaryNode<>(3));
		logger.info("avl result = {}", avlTree.getRootNode());
		Object[] heapArray = avlTree.toHeapArray();
		logger.info("avlTree to HeapArray  = {}", Arrays.toString(heapArray));
		List<Object[]> printingArrList = HeapTreeHandler.getTreePrintingArrayList(heapArray);
		for ( int i = 0 ; i < printingArrList.size() ; i ++ ) {
			logger.info(Arrays.toString(printingArrList.get(i)));
		}
		HeapTreeHandler.printAsTree(heapArray);
		
		HeapTreeHandler.printAsTree(heapArray, "x");
	}
	@Test
	void testInsertRandom() {
		int testSize = 6;
		int itemMaxNum = 15;
		AVLTree<Integer> avlT = new AVLTree<>();
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
			avlT.insert(new BinaryNode<>(item));
		}
		logger.info("avlT Insert Result = {}", Arrays.toString(avlT.getInOrder().toArray()));
		
	}
	@Test
	public void testExpectedOrder() {
		AVLTree<Integer> avlT = new AVLTree<>();
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
			avlT.insert(new BinaryNode<>(item));
		}

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
		List<Integer> inOrderResult = avlT.getInOrder();
		assertTrue(Arrays.equals(new Integer[] {1,3,4,6,7,8,10,13,14}, inOrderResult.toArray()  ) );
		List<Integer> preOrderResult = avlT.getPreOrder();
		assertTrue(Arrays.equals(new Integer[] {8,3,1,6,4,7,10,14,13}, preOrderResult.toArray()  ) );
		List<Integer> postOrderResult = avlT.getPostOrder();
		assertTrue(Arrays.equals(new Integer[] {1,4,7,6,3,13,14,10,8}, postOrderResult.toArray()  ) );
		List<Integer> levelOrderResult = avlT.getLevelOrder();
		assertTrue(Arrays.equals(new Integer[] {8,3,10,1,6,14,4,7,13}, levelOrderResult.toArray()  ) );
	}
}
