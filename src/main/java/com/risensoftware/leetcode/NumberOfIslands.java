package com.risensoftware.leetcode;

/*
Question:
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
return the number of islands.
*/
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    int islands = 0;

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (grid[row][col] == '1') {
          islands++;
          floodFill(grid, row, col);
        }
      }
    }

    return islands;
  }

  private void floodFill(char[][] grid, int row, int col) {
    if (
      row < 0 || row >= grid.length ||
      col < 0 || col >= grid[row].length ||
      grid[row][col] != '1'
    ) {
      return;
    }

    grid[row][col] = '0';
    floodFill(grid, row + 1, col);
    floodFill(grid, row - 1, col);
    floodFill(grid, row, col + 1);
    floodFill(grid, row, col - 1);
  }
}
