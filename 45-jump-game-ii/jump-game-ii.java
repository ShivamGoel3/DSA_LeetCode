class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[nums.length - 1] = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            int c = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                c = Math.min(c, dp[j]);
            }
            if (c != Integer.MAX_VALUE)
                dp[i] = c + 1;
        }
        return dp[0];
    }
}