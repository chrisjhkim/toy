package com.chrisjhkim.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryNodeTest {

	@Test
	void testCompare() {
		BinarySearchNode<Integer> node1 = new BinarySearchNode<>();
		node1.setData(1);
		
		BinarySearchNode<Integer> node2 = new BinarySearchNode<>();
		node2.setData(2);
		
		
		assertTrue(node1.isSmallerThan(node2));
		assertFalse(node2.isSmallerThan(node1));
		assertFalse(node1.isLargerThan(node2));
		assertTrue(node2.isLargerThan(node1));
	}
	@Test
	void testCopmare2() {
		BinarySearchNode<Integer> node1 = new BinarySearchNode<>();
		node1.setData(5);
		
		BinarySearchNode<Integer> node2 = new BinarySearchNode<>();
		node2.setData(5);
		
		assertFalse(node1.isSmallerThan(node2));
		assertFalse(node2.isSmallerThan(node1));
		assertFalse(node2.isLargerThan(node1));
		assertFalse(node1.isLargerThan(node2));
	}
	
	@Test
	void testSwitch() {
		BinaryNode<Integer> rightNode = new BinaryNode<>(10); 
		BinaryNode<Integer> parentNode= new BinaryNode<>(5); 
		BinaryNode<Integer> rightRightNode = new BinaryNode<>(15);
		parentNode.setRightNode(rightNode);
		rightNode.setRightNode(rightRightNode);
		
		
		System.out.println(parentNode);
		parentNode = leftRotate(parentNode);
		System.out.println(parentNode);
	}
	private BinaryNode<Integer> leftRotate(BinaryNode<Integer> parentNode) {
		BinaryNode<Integer> newParentNode = parentNode.getRightNode();
		BinaryNode<Integer> nullNode = newParentNode.getLeftNode();
		parentNode.setRightNode(nullNode);
		newParentNode.setLeftNode(parentNode);
		return newParentNode;
	}
	
	

}
