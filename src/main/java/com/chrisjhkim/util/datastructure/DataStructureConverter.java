package com.chrisjhkim.util.datastructure;

import java.util.Arrays;

import com.chrisjhkim.tree.BinaryNode;
import com.chrisjhkim.tree.BinarySearchTree;

public class DataStructureConverter <T extends Comparable<T>>{

	public BinarySearchTree<T> convertSortedToBinarySearchTree(T[] input){
		BinarySearchTree<T> result = new BinarySearchTree<>();
		Arrays.stream(input)
		.forEach((T item)->result.insert(new BinaryNode<>(item)));
		
		for ( T item : input) {
			result.insert(new BinaryNode<>(item));
		}
		return result;
	}
}
