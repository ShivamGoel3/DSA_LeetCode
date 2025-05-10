class Solution {
    int call(String word1, String word2, int i, int j, int[][] dp) {
        if (i <= 0)
            return j;
        if (j <= 0)
            return i;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return dp[i][j] = call(word1, word2, i - 1, j - 1, dp);
        } else {
            int a = call(word1, word2, i, j - 1, dp);
            int b = call(word1, word2, i - 1, j, dp);
            return dp[i][j] = 1 + Math.min(a, b);
        }
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return call(word1, word2, n, m, dp);
    }
}