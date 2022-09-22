package com.chrisjhkim.tree;

import com.chrisjhkim.util.GsonUtil;

public class BinarySearchNode <T extends Comparable<? super T>> extends BinaryNode<T>{
	private int height;

	
	public BinarySearchNode() {
		super();
		this.height = 1;
	}
	public BinarySearchNode(T nodeData) {
		super(nodeData);
		this.height = 1;
	}
	public BinarySearchNode(Node<T> node) {
		super(node.getData());
		this.height = 1;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getBalanceFactor() {
		return super.getHeight(super.getLeftNode(), 1) - super.getHeight(super.getRightNode(), 1);
	}
	public void updateHeight() {
		if ( this.getLeftNode() == null && this.getRightNode() == null ) {
			this.height = 1;
		}else {
			if ( this.getLeftNode() != null ) {
				this.height = Math.max(this.height, ((BinarySearchNode<T>)this.getLeftNode()).height+1);
			}
			if ( this.getRightNode() != null ) {
				this.height = Math.max(this.height, ((BinarySearchNode<T>)this.getRightNode()).height+1);
			}
		}
		
	}
	public boolean isUnBalanced() {
		int balanceFactor = getBalanceFactor();
		return (balanceFactor> 1 || balanceFactor < -1);
	}
	@Override
	public String toString() {
		return GsonUtil.gson.toJson(this);
	}
	
	public boolean isSmallerThan(BinaryNode<T> node) {
		if ( node == null) {
			return false;
		}else {
			return super.getData().compareTo(node.getData())< 0;
		}
	}
	public boolean isLargerThan(BinaryNode<T> node) {
		if ( node == null ) {
			return false;
		}else {
			return super.getData().compareTo(node.getData())>0;
		}
	}
	
	
}
