package com.chrisjhkim.tree;

import java.util.function.Consumer;

public class BinarySearchTree <T extends Comparable<? super T>> extends BinaryTree<T>{

	@Override
	@SuppressWarnings("java:S1125")
	public void insert(Node<T> node) {
		if ( node instanceof BinaryNode<T> == false) {
			throw new IllegalArgumentException("must insert binary node");
		}
		
		if ( super.getRootNode() == null ) {
			super.setRootNode(node);
		}else {
			insertBST(super.getRootNode(), (BinarySearchNode<T>) node);
		}
	}

	private void insertBST(BinaryNode<T> nodePosition, BinarySearchNode<T> newNode) {
		BinaryNode<T> focusNode = nodePosition;
		
		while ( true ) {
//			focusNode.sizeUp();
			if ( newNode.isSmallerThan(focusNode)) {
				if ( focusNode.getLeftNode() == null ) {
					focusNode.setLeftNode(newNode);
					return;
				}else {
					focusNode = focusNode.getLeftNode();
				}
			}else if ( newNode.isLargerThan(focusNode)){
				if ( focusNode.getRightNode() == null ) {
					focusNode.setRightNode(newNode);
					return;
				}else {
					focusNode = focusNode.getRightNode();
				}
			}else {
				throw new IllegalArgumentException("data can't be same");
			}
		}
	}
	
	
	public boolean contains(T data) {
		return contains(this.getRootNode(), data);
	}

	private boolean contains(BinaryNode<T> currentNode, T data) {
		if ( currentNode == null ) {
			return false;
		}else if( currentNode.getData().equals(data)) {
			return true;
		}else if ( data.compareTo(currentNode.getData()) < 0 ) {
			return contains(currentNode.getLeftNode(), data);
		}else if ( currentNode.getData().compareTo(data) < 0 ) {
			return contains(currentNode.getRightNode(), data);
		}else {
			throw new IllegalArgumentException("invalid state");
		}
	}


}
