class Solution {
    int call(int[] coins, int amount, int index, int[][] dp) {
        if (index < 0) {
            if (amount == 0)
                return 0;
            else
                return Integer.MAX_VALUE;
        }
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (dp[index][amount] != -1)
            return dp[index][amount];
        int a = call(coins, amount, index - 1, dp);
        int b = call(coins, amount - coins[index], index, dp);
        if (b != Integer.MAX_VALUE) {
            b++;
        }
        return dp[index][amount] = Math.min(a, b);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        return call(coins, amount, n - 1, dp) == Integer.MAX_VALUE ? -1 : dp[n - 1][amount];
    }
}