package com.chrisjhkim.toy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Blocks implements Cloneable{
	private List<Block> blockList;

	public Blocks(int[] prob) {
		blockList = new ArrayList<>();
		for ( int length : prob) {
			blockList.add(new Block(length));
		}
	}

	private Blocks() {
		this.blockList = new ArrayList<>();
		
		// TODO Auto-generated constructor stub
	}

	public List<Block> getBlockList() {
		return blockList;
	}

	public void setBlockList(List<Block> blockList) {
		this.blockList = blockList;
	}

	

	@Override
	public String toString() {
		return "Blocks [blockList=" + blockList + "]";
	}

	public static Blocks copy(Blocks origin) {
		Blocks result = new Blocks();
		result.blockList = new ArrayList<>(origin.blockList.size());
		Collections.copy(result.blockList, origin.blockList);
		return result;
	}
	
	

}
