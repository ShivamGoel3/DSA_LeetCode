class Solution {
    int calldp(int n, int[] dp) {
        if (n < 3)
            return n;
        if (dp[n] != 0)
            return dp[n];
        dp[n] =  calldp(n - 1, dp) + calldp(n - 2, dp);
        return dp[n];
    }

    public int climbStairs(int n) {
        if(n<3)
        return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return calldp(n, dp);
    }
}