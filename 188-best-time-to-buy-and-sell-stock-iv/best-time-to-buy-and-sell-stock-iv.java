class Solution {
    int call(int[] prices, int index, int buy, int count, int[][][] dp, int max) {
        if (index >= prices.length)
            return 0;
        if (count >= max)
            return 0;
        if (dp[index][buy][count] != -1)
            return dp[index][buy][count];
        if (buy == 0) {
            int a = call(prices, index + 1, buy, count, dp, max);
            int b = -prices[index] + call(prices, index + 1, 1 - buy, count, dp, max);
            return dp[index][buy][count] = Math.max(a, b);
        } else {
            int a = call(prices, index + 1, buy, count, dp, max);
            int b = prices[index] + call(prices, index + 1, 1 - buy, count + 1, dp, max);
            return dp[index][buy][count] = Math.max(a, b);
        }
    }

    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int l = 0; l < k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return call(prices, 0, 0, 0, dp, k);
    }
}