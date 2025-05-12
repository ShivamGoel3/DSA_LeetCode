class Solution {
    int call(int[] prices, int[][] dp, int index, int buy) {
        if (index >= prices.length)
            return 0;
        if (dp[index][buy] != -1)
            return dp[index][buy];
        if (buy == 1) {
            int a = call(prices, dp, index + 1, buy);
            int b = -prices[index] + call(prices, dp, index + 1, 0);
            return dp[index][buy] = Math.max(a, b);
        } else {
            int a = call(prices, dp, index + 1, buy);
            int b = prices[index] + call(prices, dp, index + 1, 1);
            return dp[index][buy] = Math.max(a, b);
        }
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return call(prices, dp, 0, 1);
    }
}