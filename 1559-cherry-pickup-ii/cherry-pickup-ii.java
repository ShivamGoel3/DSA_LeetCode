class Solution {
    int call(int row, int col1, int col2, int[][][] dp, int[][] grid, int m, int n) {
        if (col1 < 0 || col2 < 0 || col1 >= n || col2 >= n)
            return Integer.MIN_VALUE;
        if (dp[row][col1][col2] != -1)
            return dp[row][col1][col2];
        if (row == m - 1) {
            if (col1 == col2)
                return dp[row][col1][col2] = grid[row][col1];
            else
                return dp[row][col1][col2] = grid[row][col1] + grid[row][col2];
        }
        int a = Integer.MIN_VALUE;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                a = Math.max(a, call(row + 1, col1 + i, col2 + j, dp, grid, m, n));
            }
        }
        if (col1 == col2)
            return dp[row][col1][col2] = a + grid[row][col1];
        else
            return dp[row][col1][col2] = a + grid[row][col1] + grid[row][col2];
    }

    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int i = 0;
        return call(i, 0, n - 1, dp, grid, m, n);
    }
}