class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    dp[i][j] = 0;
                else {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else {
                        int a = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        a = Math.min(a, dp[i - 1][j - 1]);
                        dp[i][j] = a + 1;
                    }
                }
                count += dp[i][j];
            }
        }
        return count;
    }
}