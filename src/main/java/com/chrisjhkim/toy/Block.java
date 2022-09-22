package com.chrisjhkim.toy;

public class Block {
	private int length;
	private int start;
	private int end;
	public Block() {
		super();
	}
	
	public Block(int length) {
		super();
		this.length = length;
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Block [length=" + length + ", start=" + start + ", end=" + end + "]";
	}
	
	

}
