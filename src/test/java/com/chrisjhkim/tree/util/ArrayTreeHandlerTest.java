package com.chrisjhkim.tree.util;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArrayTreeHandlerTest {

	@Test
	void test() {
		Integer[] input = new Integer[] {null, 8, 3, 10, 1, 6, null, 14, null, null, 4, 7, null, null, 13};
		Integer[] inOrderResult = ArrayTreeHandler.getInOrder(input);
		System.out.println(Arrays.toString(inOrderResult));
		Integer[] preOrderResult = ArrayTreeHandler.getPreOrder(input);
		System.out.println(Arrays.toString(preOrderResult));
		
		Integer[] postOrderResult = ArrayTreeHandler.getPostOrder(input);
		System.out.println(Arrays.toString(postOrderResult));

		Integer[] levelOrderResult = ArrayTreeHandler.getLevelOrder(input);
		System.out.println(Arrays.toString(levelOrderResult));
	}

}
