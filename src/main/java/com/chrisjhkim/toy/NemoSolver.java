package com.chrisjhkim.toy;

public class NemoSolver {
	private int size;
	private int[] prob;
	private int[] answer;

	public NemoSolver(int size, int[] prob) {
		super();
		this.size = size;
		this.prob = prob;
	}

	public int[] getProb() {
		return prob;
	}
	public void setProb(int[] prob) {
		this.prob = prob;
	}

	public int[] solve() {
		boolean isSame = false;
		while ( !isSame) {
			Blocks leftMost = getLeftMost();
			Blocks rightMost = getRightMost();
			int[] certains = getCertainsFromMosts(leftMost, rightMost);
			isSame = isSame(answer, certains);
			if ( !isSame ) {
				updateAnswer(certains);
			}
			
		}
		return null;
	}

	private void updateAnswer(Object duplicates) {
		// TODO Auto-generated method stub
		
	}

	private boolean isSame(int[] answer2, Object duplicates) {
		// TODO Auto-generated method stub
		return false;
	}

	private int[] getCertainsFromMosts(Blocks leftMost, Blocks rightMost) {
		// TODO Auto-generated method stub
		return null;
	}

	private Blocks getRightMost() {
		// TODO Auto-generated method stub
		return null;
	}

	private Blocks getLeftMost() {
		boolean finished = false;
		Blocks result = new Blocks(this.prob);
		while(!finished) {
			Blocks tempSave = Blocks.copy(result);
//			tryMethod1(result);
			
		}
		return null;
	}
	
}
