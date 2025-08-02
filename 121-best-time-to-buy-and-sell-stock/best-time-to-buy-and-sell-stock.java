class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int mine = prices[0];
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - mine);
            mine = Math.min(prices[i], mine);
        }
        return ans;
    }
}