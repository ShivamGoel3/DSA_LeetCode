class Solution {
    int call(int n, int[] dp) {
        if (n < 3)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = call(n - 1, dp) + call(n - 2, dp);
    }

    public int climbStairs(int n) {
        if (n < 3)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = -1;
        }
        return call(n, dp);
    }
}