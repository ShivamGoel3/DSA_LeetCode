class Solution {
    int call(int[] nums, int start, int end) {
        int[][] dp = new int[2][nums.length];
        dp[0][start] = nums[start];
        for (int i = start + 1; i <= end; i++) {
            dp[0][i] = nums[i] + dp[1][i - 1];
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
        }
        return Math.max(dp[0][end], dp[1][end]);
    }

    public int rob(int[] nums) {
        int ans = nums[0];
        if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        ans = Math.max(call(nums, 0, nums.length - 2), call(nums, 1, nums.length - 1));
        return ans;
    }
}