class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // int ans = 0;
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int l = 1; l <= k; l++) {
                    int profit = 0;
                    if (j == 0) {
                        profit = Math.max(dp[i + 1][0][l], -prices[i] + dp[i + 1][1][l]);
                    }
                    if (j == 1) {
                        profit = Math.max(dp[i + 1][1][l], prices[i] + dp[i + 1][0][l - 1]);
                    }
                    dp[i][j][l] = profit;
                    // if (j == 0 && i == 0) {
                    //     ans = dp[i][j][l];
                    // }
                }
            }
        }

        return dp[0][0][k];
    }
}