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
		return findNode(this.getRootNode(), data) != null;
	}

	@Override
	public void deleteNode(T data) {
		if ( data == null || super.getRootNode() == null) return;
		else if ( super.getRootNode().getData().equals(data)) {
			super.setRootNode(null);
		}else {
			BinaryNode<T> parentNode = findParentNodeOf(data, super.getRootNode());
			if ( parentNode == null ) {
				return;
			}else {
				
				BinaryNode<T> targetNode = null;
				if ( parentNode.getRightNode().getData().equals(data)) {
					targetNode = parentNode.getRightNode();
				}else {
					targetNode = parentNode.getLeftNode();
				}
				
				if ( targetNode.getLeftNode() == null && targetNode.getRightNode() == null ){
					targetNode = null;
				}else {
					
				}
			}
			
			
			
			
			
			
			
		}
		
	}

	private BinaryNode<T> findNode(BinaryNode<T> currentNode,  T data) {
		if ( data == null ) {
			return null;
		}else if ( currentNode.getData().equals(data)) {
			return currentNode;
		}else if ( data.compareTo(currentNode.getData()) < 0 ) {
			return findNode(currentNode.getLeftNode(), data);
		}else if ( currentNode.getData().compareTo(data) < 0 ) {
			return findNode(currentNode.getRightNode(), data);
		}else {
			throw new IllegalArgumentException("invalid state");
		}
	}
	private BinaryNode<T> findParentNodeOf(T data, BinaryNode<T> currentNode) {
		if ( currentNode == null ) return null;
		else if ( currentNode.getData().equals(data)) throw new IllegalArgumentException(" data is at root node. no parent exists");
		else if ( data.compareTo(currentNode.getData()) < 0 ) {
			// 왼쪽 확인
			if ( currentNode.getLeftNode() == null ) {
				return null;
			}else if ( currentNode.getLeftNode().getData().equals(data)) {
				return currentNode;
			}else {
				return findParentNodeOf(data, currentNode.getLeftNode());
			}
		}else if (currentNode.getData().compareTo(data) < 0 ) {
			// 오른쪽 확인
			if ( currentNode.getRightNode() == null ) {
				return null;
			}else if ( currentNode.getRightNode().getData().equals(data)) {
				return currentNode;
			}else {
				return findParentNodeOf(data, currentNode.getRightNode());
			}
		}else {
			throw new IllegalArgumentException("invalid state");
		}
		
		
	}

}
