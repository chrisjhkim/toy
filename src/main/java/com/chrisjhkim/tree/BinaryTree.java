package com.chrisjhkim.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BinaryTree <T> implements Tree<T>{
	
	private static final Logger logger = LoggerFactory.getLogger(BinaryTree.class);

	private BinaryNode<T> rootNode;

	@Override
	public int height() {
		return rootNode.height();
	}

	@Override
	public int size() {
		return rootNode.size();
	}

	@Override
	public BinaryNode<T> getRootNode() {
		return this.rootNode;
	}
	@Override
	public void setRootNode(Node<T> node) {
		this.rootNode = (BinaryNode<T>) node;
	}
	
	
	public List<T> getInOrder() {
		List<T> listResult = new ArrayList<>();
		inOrder(this.rootNode, listResult);
		return listResult;
	}
	private void inOrder(BinaryNode<T> currentNode, List<T> listResult) {
		if ( currentNode.getLeftNode() != null ) {
			inOrder(currentNode.getLeftNode(), listResult);
		}
		listResult.add(currentNode.getData());
		if ( currentNode.getRightNode() != null ) {
			inOrder(currentNode.getRightNode(), listResult);
		}
	}
	public List<T> getPreOrder() {
		List<T> listResult = new ArrayList<>();
		preOrder(this.rootNode, listResult);
		return listResult;
	}
	private void preOrder(BinaryNode<T> currentNode, List<T> listResult) {
		listResult.add(currentNode.getData());
		if ( currentNode.getLeftNode() != null ) {
			preOrder(currentNode.getLeftNode(), listResult);
		}
		if ( currentNode.getRightNode() != null ) {
			preOrder(currentNode.getRightNode(), listResult);
		}
	}
	public List<T> getPostOrder() {
		List<T> listResult = new ArrayList<>();
		postOrder(this.rootNode, listResult);
		return listResult;
	}
	private void postOrder(BinaryNode<T> currentNode, List<T> listResult) {
		if ( currentNode.getLeftNode() != null ) {
			postOrder(currentNode.getLeftNode(), listResult);
		}
		if ( currentNode.getRightNode() != null ) {
			postOrder(currentNode.getRightNode(), listResult);
		}
		listResult.add(currentNode.getData());
	}
	public List<T> getLevelOrder() {
		List<T> listResult = new ArrayList<>();
		
		Deque<BinaryNode<T>> queue = new ArrayDeque<>();
		BinaryNode<T> focusNode = this.rootNode;
		queue.add(focusNode);
		while ( !queue.isEmpty() ) {
			focusNode = queue.pop();
			listResult.add(focusNode.getData());
			if ( focusNode.getLeftNode() != null ) {
				queue.add(focusNode.getLeftNode());
			}
			if ( focusNode.getRightNode() != null ) {
				queue.add(focusNode.getRightNode());
			}
		}
		return listResult;
	}
	public T getSmallest() {
		if  ( this.rootNode == null ) { 
			return null;
		}else {
			BinaryNode<T> target = this.rootNode;
			while( target.getLeftNode() != null ) {
				target = target.getLeftNode();
			}
			return target.getData();
		}
	}
	public T getLargest() {
		if  ( this.rootNode == null ) { 
			return null;
		}else {
			BinaryNode<T> target = this.rootNode;
			while( target.getRightNode() != null ) {
				target = target.getRightNode();
			}
			return target.getData();
		}
	}

	
	public Object[] toHeapArray() {
		Object[] result = new Object[(int) Math.pow(2, height())];
		result[0] = null;
		if ( this.rootNode != null ) {
			result[1] = this.rootNode.getData();
			for ( int i = 2 ; i < result.length ; i ++ ) {
				result[i] = getProperNode(i, this);
			}
			
		}
		
		return result;
	}
	private T getProperNode(int index , BinaryTree<T> binaryTree) {
		logger.info("@@ {}", this.rootNode);
		if ( index == 0 ) {
			return null;
		}else {
			String binaryString = Integer.toBinaryString(index);
			logger.info("index={} -> binaryString={}", index, binaryString);
			// first 1 = node
			// from second, 0=L / 1=R
			BinaryNode<T> focusNode = this.rootNode;
			for ( int i = 1 ;i < binaryString.length() ; i ++ ) {
				if ( binaryString.charAt(i) == '0' ) {
					focusNode = focusNode.getLeftNode();
				}else if ( binaryString.charAt(i) == '1') {
					focusNode = focusNode.getRightNode();
				}
			}
			T result = focusNode==null?null:focusNode.getData();
			logger.info("{} -> {}", index, result);
			return result;
		}
		
	}

	public List<String> getPrintStringWithNulls(){ 
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		Queue<BinaryNode<T>> globalQueue = new ArrayDeque<>();
		Queue<BinaryNode<T>> lineQueue = new ArrayDeque<>();
		if ( this.rootNode != null ) {
			globalQueue.add(this.rootNode);
			while ( !globalQueue.isEmpty()) {
				sb.setLength(0);
				BinaryNode<T> item = globalQueue.poll();
				sb.append(item.getData());
				sb.append(' ');
				if ( item.getLeftNode() != null ) 
					lineQueue.add(item.getLeftNode());
				if ( item.getRightNode() != null ) 
					lineQueue.add(item.getRightNode());
				
				
			}
		}
	
		
		return result;
	}
	
	

}
