package com.chrisjhkim.tree;

public abstract class Node<T> {
	private T nodeData;
	
	protected Node() {
		super();
	}
	protected Node(T nodeData) {
		super();
		this.nodeData = nodeData;
	}
	public T getData() {
		return nodeData;
	}
	public void setData(T nodeData) {
		this.nodeData = nodeData;
	}
	
	
	public abstract int height();
	public abstract int size();
	
}
