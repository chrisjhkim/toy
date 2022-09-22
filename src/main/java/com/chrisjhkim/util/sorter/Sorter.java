package com.chrisjhkim.util.sorter;

import com.chrisjhkim.tree.AVLTree;
import com.chrisjhkim.tree.BinarySearchTree;

public interface Sorter <T extends Comparable<T>>{

	public enum Order{
		ASCENDING, DESCENDING
	}
	
	
	public void sort(T[] input);
	public void sort(T[] input, Order order);
	
	public T[] merge(T[] input1, T[] input2);
	public T[] merge(T[] input1, T[] input2, Order order);
	
	public BinarySearchTree<T> toBinarySearchTree(T[] input);
	public AVLTree<T> toAVLTree(T[] input);
	
}
