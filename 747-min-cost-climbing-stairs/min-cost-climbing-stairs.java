class Solution {
    int call(int[] cost, int j, int[] dp) {
        if (dp[j] != -1)
            return dp[j];
        if (j < 2)
            return cost[j];
        int a = call(cost, j - 1, dp);
        int b = call(cost, j - 2, dp);
        if (j == cost.length)
            return dp[j] = Math.min(a, b);
        else
            return dp[j] = Math.min(a, b) + cost[j];
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 0; i <= cost.length; i++)
            dp[i] = -1;
        return call(cost, cost.length, dp);
    }
}