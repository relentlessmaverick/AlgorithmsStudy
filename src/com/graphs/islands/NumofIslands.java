package com.graphs.islands;

public class NumofIslands {
	public static int numIslands(char[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					result++;
					countIslands(grid, i, j);
				}
			}
		}
		return result;
	}

	private static void countIslands(char[][] grid, int r, int c) {

		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
			return;
		}
		grid[r][c] = '0';
		countIslands(grid, r + 1, c);
		countIslands(grid, r - 1, c);
		countIslands(grid, r, c - 1);
		countIslands(grid, r, c + 1);
	}

	public static void main(String[] args) {
		char array[][] = { { '1', '1', '0', '0', '0' }, 
						   { '1', '1', '0', '0', '0' }, 
						   { '0', '0', '1', '0', '0' },
				           { '0', '0', '0', '1', '1' } };

		System.out.println(numIslands(array));
	}
}
