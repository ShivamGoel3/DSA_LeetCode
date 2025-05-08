class Solution {
    int call(int i, int[] nums, int[] dp) {
        if (dp[i] != -1)
            return dp[i];
        if (i == 0)
            return dp[i] = nums[i];
        if (i == 1)
            return dp[i] = Math.max(nums[0], nums[1]);
        int a = nums[i] + call(i - 2, nums, dp);
        int b = call(i - 1, nums, dp);
        return dp[i] = Math.max(a, b);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }
        return call(nums.length - 1, nums, dp);
    }
}