class Solution {
    public int rob(int[] nums) {
        int ans = nums[0];
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[1][i] = dp[0][i - 1];
            } else {
                dp[0][i] = nums[i] + dp[1][i - 1];
                dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            }

        }
        ans = Math.max(ans, dp[1][nums.length - 1]);
        int[][] dp1 = new int[2][nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp1[0][i] = nums[i] + dp1[1][i - 1];
            dp1[1][i] = Math.max(dp1[0][i - 1], dp1[1][i - 1]);
            // System.out.println(dp[0][i] + " " + dp[1][i]);
        }
        ans = Math.max(ans, dp1[1][nums.length - 1]);
        ans = Math.max(ans, dp1[0][nums.length - 1]);
        return ans;
    }
}