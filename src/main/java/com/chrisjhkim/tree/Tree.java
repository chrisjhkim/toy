package com.chrisjhkim.tree;


public interface Tree <T>{
	public int height();
	public int size();
//	public Node<T> 
	
	public void insert(Node<T> node);
	
	public Node<T> getRootNode();
	public void setRootNode(Node<T> rootNode);

}
