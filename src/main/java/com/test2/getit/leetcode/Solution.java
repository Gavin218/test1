package com.test2.getit.leetcode;

/**
 * @ClassName: Solution
 * @Description:
 * @Author Chen Gavin
 * @Date 2021/12/7
 * @Version 1.0
 */


public class Solution {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int originalColor = grid[row][col];
        dfs(grid, row, col, originalColor);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isCentre(grid, i, j)) {
                    grid[i][j] = -2;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = color;
                }
                if (grid[i][j] == -2) {
                    grid[i][j] = originalColor;
                }
            }
        }
        return grid;
    }
    public void dfs(int[][] grid, int i, int j, int oriColor) {
        grid[i][j] = -1;
        if (i - 1 >= 0 && grid[i-1][j] == oriColor) {
            dfs(grid, i-1, j, oriColor);
        }
        if (i + 1 < grid.length && grid[i+1][j] == oriColor) {
            dfs(grid, i+1, j, oriColor);
        }
        if (j - 1 >= 0 && grid[i][j-1] == oriColor) {
            dfs(grid, i, j-1, oriColor);
        }
        if (j + 1 < grid[0].length && grid[i][j+1] == oriColor) {
            dfs(grid, i, j+1, oriColor);
        }
    }
    public boolean isCentre(int[][] grid, int i, int j) {
        if (grid[i][j] == -1 && i > 0 && i < grid.length-1 && j > 0 && j < grid[0].length-1) {
            if (grid[i-1][j] < 0 && grid[i][j-1] < 0 && grid[i+1][j] < 0 && grid[i][j+1] < 0) {
                return true;
            }
        }
        return false;
    }

}
