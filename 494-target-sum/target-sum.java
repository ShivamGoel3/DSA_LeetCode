class Solution {
    int call(int[] nums, int target, int index, int[][] dp, int sum) {
        if (index < 0) {
            if (target == 0)
                return 1;
            else
                return 0;
        }
        // System.out.println(index + " " + (target + sum));
        if (dp[index][target + sum] != -1)
            return dp[index][target + sum];
        int a = call(nums, target - nums[index], index - 1, dp, sum);
        int b = call(nums, target + nums[index], index - 1, dp, sum);
        return dp[index][target + sum] = a + b;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Math.abs(target);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int[][] dp = new int[n][2 * sum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                dp[i][j] = -1;
            }
        }
        return call(nums, target, n - 1, dp, sum);
    }
}