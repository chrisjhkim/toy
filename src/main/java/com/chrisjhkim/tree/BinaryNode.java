package com.chrisjhkim.tree;

import com.chrisjhkim.util.GsonUtil;

public class BinaryNode<T> extends Node<T>{
	
	private BinaryNode<T> leftNode;
	private BinaryNode<T> rightNode;
	
//	private int size;
	
	public BinaryNode() {
		super();
	}
	public BinaryNode(T nodeData) {
		super(nodeData);
//		this.size = 1;
	}
	public BinaryNode<T> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryNode<T> leftNode) {
		this.leftNode = leftNode;
	}
	public BinaryNode<T> getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryNode<T> rightNode) {
		this.rightNode = rightNode;
	}
	
	public int size(){
		return size(this);
	}
//	public int sizeTest() {
//		return this.size;
//	}
	private int size(BinaryNode<T> currentNode) {
		int result = 1;
		if ( currentNode.getLeftNode() != null ) {
			result += size(currentNode.getLeftNode());
		}
		if ( currentNode.getRightNode() != null ) {
			result += size(currentNode.getRightNode());
		}
		return result;
	}
	
//	public void sizeUp() {
//		this.size ++;
//	}
//	public void sizeDown() {
//		this.size --;
//	}

	
	@Override
	public int height() {
		return getHeight(this, 1);
	}
	
	@Override
	public String toString() {
//		return "BinaryNode [leftNode=" + leftNode + ", this="+ super.getData() +", rightNode=" + rightNode + "]";
		return GsonUtil.gson.toJson(this);
	}
	public int getHeight(BinaryNode<T> currentNode, int currentHeight) {
		int maxHeight = currentHeight;
		if ( currentNode == null ) return 0;
		
		if ( currentNode.getLeftNode() != null ) {
			maxHeight = Math.max(maxHeight, getHeight(currentNode.getLeftNode(), currentHeight+1));
		}
		if ( currentNode.getRightNode() != null ) { 
			maxHeight = Math.max(maxHeight, getHeight(currentNode.getRightNode(), currentHeight+1));
		}
		return maxHeight;
	}
	
}
