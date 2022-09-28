package com.chrisjhkim.programmers.dfs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.chrisjhkim.programmers.dfsbfs.FindPathToEnd;

class FindPathToEndTest {
	FindPathToEnd solver = new FindPathToEnd();
	@Test
	void test() {
//		assertEquals(11, solver.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
//		assertEquals(-1, solver.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
//		assertEquals(3, solver.solution(new int[][]{{1,0},{1,1}}));
//		assertEquals(3, solver.solution(new int[][]{{1,1},{1,1}}));
//		assertEquals(5, solver.solution(new int[][]{{1,1,1},{1,1,1},{1,1,1}}));
//		assertEquals(5, solver.solution(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));

		
		int[][] map = new int[10][];
		for ( int i = 0 ; i < map.length ;i ++ ) {
			map[i] = new int[10];
			for ( int j = 0 ; j < map[i].length ; j ++ ) {
				map[i][j] = 1;
			}
		}
		map[0][0] = 0;
		
		/**
		 * maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
		 */
		assertEquals(-1, solver.solution(map ));
		
	}

}
