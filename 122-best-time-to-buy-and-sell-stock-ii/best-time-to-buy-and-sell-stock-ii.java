class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, ele = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (ele <= prices[i]) {
                ans += prices[i] - ele;
            }
            ele = prices[i];
        }
        return ans;
    }
}