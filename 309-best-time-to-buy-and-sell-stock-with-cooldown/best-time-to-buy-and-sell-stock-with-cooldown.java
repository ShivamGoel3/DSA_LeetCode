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
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= 1; j++) {
                dp[i][j] = -1;
            }
        }
        return call(prices, 0, 0, dp);
    }
}