class Solution {
    int call(int[] coins, int amount, int index, int[][] dp) {
        if (amount < 0)
            return 0;
        if (index < 0) {
            if (amount == 0)
                return 1;
            else
                return 0;
        }
        if (dp[index][amount] != -1)
            return dp[index][amount];
        int a = call(coins, amount, index - 1, dp);
        int b = call(coins, amount - coins[index], index, dp);
        return dp[index][amount] = a + b;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        return call(coins, amount, n - 1, dp);
    }
}