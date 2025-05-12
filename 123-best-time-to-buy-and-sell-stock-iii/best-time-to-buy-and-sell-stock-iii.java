class Solution {
    int call(int[] prices, int index, int buy, int count, int[][][] dp) {
        if (index >= prices.length)
            return 0;
        if (count >= 2)
            return 0;
        if (dp[index][buy][count] != -1)
            return dp[index][buy][count];
        if (buy == 0) {
            int a = call(prices, index + 1, buy, count, dp);
            int b = -prices[index] + call(prices, index + 1, 1 - buy, count, dp);
            return dp[index][buy][count] = Math.max(a, b);
        } else {
            int a = call(prices, index + 1, buy, count, dp);
            int b = prices[index] + call(prices, index + 1, 1 - buy, count + 1, dp);
            return dp[index][buy][count] = Math.max(a, b);
        }
    }

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return call(prices, 0, 0, 0, dp);
    }
}