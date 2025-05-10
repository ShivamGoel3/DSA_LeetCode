class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i]) {
                    int a = j - coins[i];
                    if (dp[i][a] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][a] + 1);
                    }

                }
            }
        }
        return dp[n - 1][amount] == Integer.MAX_VALUE ? -1 : dp[n - 1][amount];
    }
}