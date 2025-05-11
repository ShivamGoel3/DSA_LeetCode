class Solution {
    int call(String s, String t, int i, int j, int[][] dp) {
        if (i == 0 && j == 0)
            return 1;
        if (i == 0)
            return 0;
        if (j == 0)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            return dp[i][j] = call(s, t, i - 1, j - 1, dp) + call(s, t, i - 1, j, dp);
        } else {
            return dp[i][j] = call(s, t, i - 1, j, dp);
        }
    }

    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return call(s, t, n, m, dp);
    }
}