package com.test2.getit.leetcode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @ClassName: Solution
 * @Description:
 * @Author Chen Gavin
 * @Date 2021/12/7
 * @Version 1.0
 */

@Component
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

    public String toLowerCase(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int theASCII = s.charAt(i);
            if (theASCII >= 65 && theASCII <= 90) {
                sb.append((char)(theASCII + 32));
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[][] sight = getSight(grid);
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result += Math.min(sight[0][i], sight[1][j]) - grid[i][j];
            }
        }
        return result;
    }
    public int[][] getSight(int[][] grid) {
        int[][] result = new int[2][grid.length];
        int[][] tGrid = new int[grid[0].length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            int maxNum = -Integer.MIN_VALUE;
            for (int j = 0; j < grid[0].length; j++) {
                maxNum = (grid[i][j] > maxNum) ? grid[i][j] : maxNum;
                tGrid[j][i] = grid[i][j];
            }
            result[0][i] = maxNum;
        }
        for (int i = 0; i < tGrid.length; i++) {
            int maxNum = -Integer.MIN_VALUE;
            for (int j = 0; j < tGrid[0].length; j++) {
                maxNum = (tGrid[i][j] > maxNum) ? tGrid[i][j] : maxNum;
            }
            result[1][i] = maxNum;
        }
        return result;
    }

    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null != node.left || null != node.right) {
                TreeNode tem = node.left;
                node.left = node.right;
                node.right = tem;
            }
            if (null != node.left) {
                queue.add(node.left);
            }
            if (null != node.right) {
                queue.add(node.right);
            }
        }
        return root;
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        String[] fizzBuzz = {"FizzBuzz", "Fizz", "Buzz"};
        for (int i = 1; i <= n; i++) {
            if ((i%3)==0 && (i%5)==0) {
                list.add(fizzBuzz[0]);
            }
            else if ((i%3)==0) {
                list.add(fizzBuzz[1]);
            }
            else if ((i%5)==0) {
                list.add(fizzBuzz[2]);
            }
            else{
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        row.addAll(rowSet);
        col.addAll(colSet);
        for (int oneRow : row) {
            for (int i = 0; i < n; i++) {
                matrix[oneRow][i] = 0;
            }
        }
        for (int oneCol : col) {
            for (int i = 0; i < m; i++) {
                matrix[i][oneCol] = 0;
            }
        }
    }

    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, List<Integer>> trustMap = new HashMap<>();
        HashSet<Integer> trustOthers = new HashSet<>();
        for (int[] combine : trust) {
            if (trustMap.containsKey(combine[1])) {
                trustMap.get(combine[1]).add(combine[0]);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(combine[0]);
                trustMap.put(combine[1], list);
            }
            trustOthers.add(combine[0]);
        }
        for (Map.Entry<Integer, List<Integer>> entry : trustMap.entrySet()) {
            if (!trustOthers.contains(entry.getKey()) && entry.getValue().size()==n) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int dayOfYear(String date) {
        String[] dateList = date.split("-");
        int year = Integer.parseInt(dateList[0]);
        int month = Integer.parseInt(dateList[1]);
        int day = Integer.parseInt(dateList[2]);
        int[] theMonthList = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            theMonthList[1] = 29;
        }
        int[] lastMonths = Arrays.copyOfRange(theMonthList, 0, month-1);
        return Arrays.stream(lastMonths).sum() + day;
    }

    public boolean isLeapYear(int year) {
        if (year%400 == 0 || (year%400 != 0 && year%4 == 0)) {
            return true;
        }
        return false;
    }

}
