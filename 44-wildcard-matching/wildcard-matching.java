class Solution {
    int call(String s, String p, int i, int j, int[][] dp) {
        if (i == 0 && j == 0)
            return 1;
        if (j == 0)
            return 0;
        if (i == 0) {
            int k = j;
            while (k > 0) {
                if (p.charAt(k - 1) != '*')
                    return 0;
                k--;
            }
            return 1;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i - 1) == p.charAt(j - 1)) {
            return dp[i][j] = call(s, p, i - 1, j - 1, dp);
        } else {
            if (p.charAt(j - 1) == '?')
                return dp[i][j] = call(s, p, i - 1, j - 1, dp);
            else if (p.charAt(j - 1) == '*') {
                int a = call(s, p, i - 1, j, dp);
                int b = call(s, p, i, j - 1, dp);
                // if(a==1 || b==1)
                return dp[i][j] = a | b;
            } else
                return dp[i][j] = 0;
        }
    }

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return call(s, p, n, m, dp) == 1;
    }
}