class Solution {
    int call(int n, int[] dp) {
        if (dp[n] != -1)
            return dp[n];
        if (n <= 2)
            return dp[n] = n;

        return dp[n] = call(n - 1, dp) + call(n - 2, dp);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = -1;
        return call(n, dp);
    }
}