package com.chrisjhkim.tree.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chrisjhkim.util.MyMathUtil;

public class HeapTreeHandler {
	private static final Logger logger = LoggerFactory.getLogger(HeapTreeHandler.class);
	public enum TreeType{MIN_HEAP_TREE, MAX_HEAP_TREE};	

	public static Integer[] getMaxHeapTree(Integer[] inputData) {
		Integer[] result = null;
		for ( int i = 0 ; i < inputData.length ; i ++ ) {
			result = insertNodeToTree(result, inputData[i], TreeType.MAX_HEAP_TREE);
		}
		return result;
	}
	
	public static Integer[] getMinHeapTree(Integer[] inputData) {
		Integer[] result = null;
		for ( int i = 0 ; i < inputData.length ; i ++ ) {
			result = insertNodeToTree(result, inputData[i], TreeType.MIN_HEAP_TREE);
		}
		return result;
	}
	private static Integer[] insertNodeToTree(Integer[] tree, int node, TreeType treeType) {
		if ( tree == null || tree.length == 1) {
			tree = new Integer[2];
		}else if ( treeIsFull(tree)) {
			tree = Arrays.copyOf(tree, tree.length*2);
		}
		
		// 1. insert node to last position
		int p = getFirstEmptyPosition(tree);
		tree[p] = node;
		
		// 2. compare with parent
		// 3. if 2 is failed then change with parent
		while ( !positionIsValid(tree, p, treeType)) {
			int temp = tree[p];
			tree[p] = tree[p/2]; 
			tree[p/2] = temp;
			p = p/2;
		}
		return tree;
	}
	private static boolean positionIsValid(Integer[] tree, int p, TreeType treeType) {
		if (p ==1 ) {
			// root node
			return true;
		}else {
			if ( treeType == TreeType.MIN_HEAP_TREE) {
				return ( tree[p/2] < tree[p] ) ;
			}else if ( treeType == TreeType.MAX_HEAP_TREE) {
				return ( tree[p/2] > tree[p] ) ;
			}else{
				throw new IllegalArgumentException("not impl yet");
			}
		}
	}
	private static int getFirstEmptyPosition(Integer[] tree) {
		
		for ( int i = (int) Math.pow(2, getHeight(tree)-1) ; i <tree.length ; i++) {
			if ( tree[i] == null ) {
				return i;
			}
		}
		return -1;
	}
	private static boolean treeIsFull(Integer[] tree) {
		return tree[tree.length-1]!= null;
	}
	public static int getHeight(Integer[] heapData) {
		return (int) Math.ceil(MyMathUtil.log2(heapData.length));
	}
	public static void printTree(Integer[] heapData ) {
		List<String> list = getTreePrintString(heapData);
		for ( String line : list) {
			logger.info(line);
		}
	}
	public static List<String> getTreePrintString(Integer[] heapData ) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int testN = 2;
		int height = getHeight(heapData);
		for ( int i = 1 ; i < heapData.length ; i ++ ) {
			if ( i == testN/2 ) {
				for ( int j = 0 ; j < height- MyMathUtil.log2(i)-1 ; j ++ ) {
					sb.append(' ');
				}
			}
			sb.append(heapData[i]);
			sb.append(' ');
			if ( i+1 == testN || i+1 == heapData.length) {
				list.add(sb.toString());
				sb.setLength(0);
				testN = testN*2;
			}
		}
		return list;
	}
	public static void printAsTree(Object[] heapData, String ifNullString) {
		for ( Object[] line : getTreePrintingArrayList(heapData, ifNullString)) {
			logger.info(Arrays.toString(line));
		}
		
	}
	public static void printAsTree(Object[] heapData) {
		for ( Object[] line : getTreePrintingArrayList(heapData, null)) {
			logger.info(Arrays.toString(line));
		}
	}
	public static List<Object[]> getTreePrintingArrayList(Object[] heapData){
		return getTreePrintingArrayList(heapData,null);
	}
	public static List<Object[]> getTreePrintingArrayList(Object[] heapData, String ifNullString){
		List<Object[]> result = new ArrayList<>();
		if ( heapData == null || heapData.length ==1 ) {
			return result;
		}else {
			/**1
			 * 2 3
			 * 4 5 6 7
			 * 8 9 10 11 12 13 14 15
			 */
			Object[] line = new Object[1];
			int lineLength = 1;
			int lineP = 0;
			for ( int i = 1 ; i < heapData.length ; i ++ ) {
				if ( lineP == lineLength ) {
					result.add(line);
					lineLength = lineLength*2;
					line = new Object[lineLength];
					lineP = 0;
				}
				line[lineP] = heapData[i]!=null?heapData[i]:ifNullString;
				
				lineP++;
			}
			result.add(line);
		}
		
		return result;
	}
}
