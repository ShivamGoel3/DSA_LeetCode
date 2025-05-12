class Solution {
    int call(int[] prices, int fee, int index, int buy, int[][] dp) {
        if (index >= prices.length)
            return 0;
        if (dp[index][buy] != -1)
            return dp[index][buy];
        if (buy == 0) {
            int a = call(prices, fee, index + 1, buy, dp);
            int b = -prices[index] + call(prices, fee, index + 1, 1 - buy, dp);
            return dp[index][buy] = Math.max(a, b);
        } else {
            int a = call(prices, fee, index + 1, buy, dp);
            int b = prices[index] - fee + call(prices, fee, index + 1, 1 - buy, dp);
            return dp[index][buy] = Math.max(a, b);
        }
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                dp[i][j] = -1;
            }
        }
        return call(prices, fee, 0, 0, dp);
    }
}