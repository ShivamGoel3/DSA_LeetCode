class Solution {
    int call(String s1, String s2, int i, int j, int[][] dp) {
        if (i <= 0 || j <= 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return dp[i][j] = 1 + call(s1, s2, i - 1, j - 1, dp);
        else {
            return dp[i][j] = Math.max(
                    call(s1, s2, i - 1, j, dp),
                    call(s1, s2, i, j - 1, dp));
        }
    }

    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder s1 = new StringBuilder(s);
        s1.reverse();
        String s2 = s1.toString();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return n - call(s, s2, n, n, dp);
    }
}