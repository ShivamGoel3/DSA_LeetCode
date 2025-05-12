class Solution {
    int call(int[] prices, int index, int buy, int[][] dp) {
        if (index >= prices.length)
            return 0;
        if (dp[index][buy] != -1)
            return dp[index][buy];
        if (buy == 0) {
            int a = call(prices, index + 1, buy, dp);
            int b = -prices[index] + call(prices, index + 1, 1 - buy, dp);
            return dp[index][buy] = Math.max(a, b);
        } else {
            int a = call(prices, index + 1, buy, dp);
            int b = prices[index] + call(prices, index + 2, 1 - buy, dp);
            return dp[index][buy] = Math.max(a, b);
        }
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        int n = prices.length;
        dp[n - 1][1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                int profit = 0;
                if (j == 0) {
                    profit = Math.max(dp[i + 1][0], -prices[i] + dp[i + 1][1]);
                }
                if (j == 1) {
                    profit = Math.max(dp[i + 1][1], prices[i] + dp[i + 2][0]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }
}