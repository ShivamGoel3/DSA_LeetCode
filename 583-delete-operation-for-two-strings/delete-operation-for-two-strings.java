class Solution {

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // if (i == 0) {
                //     dp[i][j] = j;
                //     continue;
                // } else if (j == 0) {
                //     dp[i][j] = i;
                //     continue;
                // }
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int a = dp[i - 1][j];
                    int b = dp[i][j - 1];
                    dp[i][j] = Math.max(a, b);
                }
            }
        }
        return n + m - 2 * dp[n][m];
    }
}