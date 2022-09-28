package com.chrisjhkim.programmers.dfsbfs;

import java.util.Arrays;

public class FindPathToEnd {
	private int[][] directions = {{1,0},{0,1},{-1,0},{0,-1} };
	
	public int solution(int[][] mapRef) {
		int answer = 0;
		//System.out.println(Arrays.deepToString(mapRef));
		
		
		boolean[][] visited = new boolean[mapRef.length][];
		for ( int i = 0 ; i< visited.length ; i ++ ) {
			visited[i] = new boolean[mapRef[0].length];
		}
		answer = findPath(0,0, mapRef, visited , 0, Integer.MAX_VALUE);
		
		
		if ( answer == Integer.MAX_VALUE ) {
			return -1;
		}else {
			return answer+1;
		}
	}

	private int findPath(int y, int x, int[][] mapRef, boolean[][]visited,  int currentMoveSum, int currentBestPath) {
//		System.out.println("current = ["+y+"]["+x+"]");
		visited[y][x] = true;
		
		int bestPath = Integer.MAX_VALUE;
		if ( y+1 == mapRef.length  && x+1 == mapRef[0].length ) {
			System.out.println("finished with move="+currentMoveSum  );
			printVisited(visited);
			visited[y][x] = false;
			return currentMoveSum;
		}
		if ( currentMoveSum+1 < currentBestPath) {
			if ( y+1 < mapRef.length && !visited[y+1][x] && mapRef[y+1][x]==1 ){
				bestPath = Math.min(bestPath, findPath(y+1, x, mapRef, visited, currentMoveSum+1, bestPath));
			}
			if ( x+1 < mapRef.length && !visited[y][x+1] && mapRef[y][x+1]==1 ){
				bestPath = Math.min(bestPath, findPath(y, x+1, mapRef, visited, currentMoveSum+1, bestPath));
			}
			if ( y -1 >= 0 && !visited[y-1][x] && mapRef[y-1][x]==1 ){
				bestPath = Math.min(bestPath, findPath(y-1, x, mapRef, visited, currentMoveSum+1, bestPath));
			}
			if ( x-1 >= 0 && !visited[y][x-1] && mapRef[y][x-1]==1 ){
				bestPath = Math.min(bestPath, findPath(y, x-1, mapRef, visited, currentMoveSum+1, bestPath));
			}
			
		}
			
		visited[y][x] = false;
		return bestPath;
	}

	private void printVisited(boolean[][] visited) {
		for ( int i = 0 ; i < visited.length; i ++ ) {
			for ( int j = 0 ; j < visited[0].length ; j ++ ) {
				System.out.print(visited[i][j]?"O":"X");
			}
			System.out.println();
		}
		
	}
	
}
