package com.graphs.islands;

import java.util.PriorityQueue;

public class MaxAreaofIslands {
	public static void main(String[] args) {
		
//		System.out.println(maxAreaOfIsland(
//				new int[][] { { 1, 1, 0, 0, 0 }, 
//						      { 1, 1, 0, 0, 0 },
//						      { 0, 0, 0, 1, 1 }, 
//						      { 0, 0, 0, 1, 1 } }));
		
//		System.out.println(maxAreaOfIsland(
//				new int[][] { { 1, 1, 1, 1, 1 }, 
//						      { 0, 0, 0, 0, 0 },
//						      { 0, 0, 0, 0, 0 }, 
//						      { 0, 0, 0, 0, 0 } }));
		
		System.out.println(maxAreaOfIsland(
				new int[][] { { 1, 1, 0, 0, 1 }, 
						      { 1, 0, 0, 0, 0 },
						      { 0, 0, 0, 0, 1 }, 
						      { 1, 0, 0, 1, 1 } }));
		System.out.println(findKthLargest(new int[] {3,2,1,5,6,4},2));
	}

	public static int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		boolean seen [][] = new boolean [grid.length][grid[0].length]; 
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				maxArea = Math.max(maxArea, area(grid, i, j, seen));
			}
		}
		return maxArea;
	}

	private static int area(int[][] grid, int r, int c, boolean[][] seen) {
		if(r < 0 || r >=grid.length || c < 0 || c >= grid[0].length || seen[r][c] || grid[r][c] == 0) {
			return 0;
		}
		seen[r][c] = true;
		return 1 + area(grid, r + 1, c, seen)
		         + area(grid, r - 1, c, seen)
		         + area(grid, r, c + 1, seen)
		         + area(grid, r, c - 1, seen);
	}
	
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0; i < nums.length; i++){
            pq.offer(i);
        }
        int n = 0;
        int result = 0;
        while(n < k-1){
            result = pq.remove();
            n++;
        }
        return result;
    }
}
