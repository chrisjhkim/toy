package com.chrisjhkim.tree;

public class AVLTree <T extends Comparable<? super T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(Node<T> node) {
		if ( node instanceof BinaryNode<T> == false) {
			throw new IllegalArgumentException("must insert binary node");
		}
		BinarySearchNode<T> newNode = new BinarySearchNode<>(node);
		
		if ( this.getRootNode() == null ) {
			super.setRootNode(newNode);
		}else {
			BinarySearchNode<T> newRootNode = insertAVL((BinarySearchNode<T>) this.getRootNode(), newNode);
			super.setRootNode(newRootNode);
			((BinarySearchNode<T>)this.getRootNode()).updateHeight();
		}
	}

	private BinarySearchNode<T> insertAVL(BinarySearchNode<T> targetNode, BinarySearchNode<T> newNode) {
		if ( newNode.isSmallerThan(targetNode)) {
			if ( targetNode.getLeftNode() == null ) {
				targetNode.setLeftNode(newNode);
			}else {
				targetNode.setLeftNode( insertAVL((BinarySearchNode<T>) targetNode.getLeftNode(), newNode) );
			}
		}else if ( newNode.isLargerThan(targetNode)){
			if ( targetNode.getRightNode() == null ) {
				targetNode.setRightNode(newNode);
			}else {
				targetNode.setRightNode( insertAVL((BinarySearchNode<T>) targetNode.getRightNode(), newNode));
			}
		}
		targetNode.updateHeight();
		
		targetNode = reBalance(targetNode);
		return targetNode;
	}

	private BinarySearchNode<T> reBalance(BinarySearchNode<T> targetNode) {
		int balanceFactor = targetNode.getBalanceFactor();
		BinarySearchNode<T> rightNode = (BinarySearchNode<T>) targetNode.getRightNode();
		BinarySearchNode<T> leftNode = (BinarySearchNode<T>) targetNode.getLeftNode();
		if ( balanceFactor < -1 && rightNode.isSmallerThan(rightNode.getRightNode())){
			// RR case
			targetNode = leftRotate(targetNode);
			targetNode.updateHeight();
		}else if ( balanceFactor < -1 && rightNode.isLargerThan(rightNode.getLeftNode())) {
			// RL case right, left
			targetNode.setRightNode(rightRotate(targetNode.getRightNode()));
			targetNode = leftRotate(targetNode);
			targetNode.updateHeight();
		}else if ( balanceFactor > 1 && leftNode.isLargerThan(leftNode.getLeftNode())){
			// LL case
			targetNode = rightRotate(targetNode);
			targetNode.updateHeight();
		}else if ( balanceFactor > 1 && leftNode.isSmallerThan(leftNode.getRightNode())) {
			// LR case 
			targetNode.setLeftNode(leftRotate(targetNode.getLeftNode()));
			targetNode = rightRotate(targetNode);
			targetNode.updateHeight();
		}
		
		return targetNode;
	}

	private BinarySearchNode<T> rightRotate(BinaryNode<T> binaryNode) {
		BinaryNode<T> newParentNode = binaryNode.getLeftNode();
		BinaryNode<T> nullNode = newParentNode.getRightNode();
		binaryNode.setLeftNode(nullNode);		// null 을 설정하면 parentNode 의 rightNode , 즉 neParentNode 가 null되어버린다.
		newParentNode.setRightNode(binaryNode);
		
		BinarySearchNode<T> newLeftNode = (BinarySearchNode<T>) newParentNode.getLeftNode();
		if ( newLeftNode != null ) 
			newLeftNode.updateHeight();
		BinarySearchNode<T> newRightNode = (BinarySearchNode<T>) newParentNode.getRightNode();
		if ( newRightNode!= null ) 
			newRightNode.updateHeight();
		((BinarySearchNode<T>) newParentNode).updateHeight();
		return (BinarySearchNode<T>) newParentNode;

	}

	private BinarySearchNode<T> leftRotate(BinaryNode<T> binaryNode) {
		BinaryNode<T> newParentNode = binaryNode.getRightNode();
		BinaryNode<T> nullNode = newParentNode.getLeftNode();
		binaryNode.setRightNode(nullNode);		// null 을 설정하면 parentNode 의 rightNode , 즉 neParentNode 가 null되어버린다.
		newParentNode.setLeftNode(binaryNode);
		
		BinarySearchNode<T> newRightNode = (BinarySearchNode<T>) newParentNode.getRightNode();
		if ( newRightNode != null ) 
			newRightNode.updateHeight();
		BinarySearchNode<T> newLeftNode = (BinarySearchNode<T>) newParentNode.getLeftNode();
		if ( newLeftNode!= null ) 
			newLeftNode.updateHeight();
		((BinarySearchNode<T>) newParentNode).updateHeight();
		return (BinarySearchNode<T>) newParentNode;
	}

	

}
