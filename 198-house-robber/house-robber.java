class Solution {
    int call(int[] nums, int index, int[] dp) {
        if (index < 0)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int a = nums[index] + call(nums, index - 2, dp);
        int b = call(nums, index - 1, dp);
        return dp[index] = Math.max(a, b);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }
        return call(nums, nums.length - 1, dp);
    }
}