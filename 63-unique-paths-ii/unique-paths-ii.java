class Solution {
    int call(int i, int j, int[][] obstacleGrid, int[][] dp) {
        if (i < 0 || j < 0)
            return -1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (obstacleGrid[i][j] == 1)
            return dp[i][j] = 0;
        if (i == 0 && j == 0)
            return dp[i][j] = 1;
        int a = call(i - 1, j, obstacleGrid, dp);
        int b = call(i, j - 1, obstacleGrid, dp);
        int sum = 0;
        if (a != -1)
            sum += a;
        if (b != -1)
            sum += b;
        return dp[i][j] = sum;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length, m = obstacleGrid.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        }
        return call(m - 1, n - 1, obstacleGrid, dp);
    }
}