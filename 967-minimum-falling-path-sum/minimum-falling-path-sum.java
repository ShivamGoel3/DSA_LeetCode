class Solution {
    int call(int i, int j, int m, int n, int[][] matrix, int[][] dp) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return Integer.MAX_VALUE;
        if (dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        if (i == m - 1)
            return dp[i][j] = matrix[i][j];
        int a = call(i + 1, j - 1, m, n, matrix, dp);
        int b = call(i + 1, j, m, n, matrix, dp);
        int c = call(i + 1, j + 1, m, n, matrix, dp);

        int d = Math.min(a, b);
        d = Math.min(c, d);
        return dp[i][j] = d + matrix[i][j];
    }

    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                dp[i][j] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, call(0, i, m, n, matrix, dp));
        }
        return ans;
    }
}