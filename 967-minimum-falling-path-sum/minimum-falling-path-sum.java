class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0) {
                    int a = Integer.MAX_VALUE;
                    int b = Integer.MAX_VALUE;
                    int c = Integer.MAX_VALUE;
                    if (j - 1 >= 0)
                        a = dp[i - 1][j - 1];
                    b = dp[i - 1][j];
                    if (j + 1 < n)
                        c = dp[i - 1][j + 1];
                    dp[i][j] = Math.min(a, b);
                    dp[i][j] = Math.min(dp[i][j], c);

                }
                dp[i][j] += matrix[i][j];
                if (i == m - 1)
                    ans = Math.min(ans, dp[i][j]);
            }
        }
        return ans;
    }
}