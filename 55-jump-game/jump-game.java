class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            boolean check = false;
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (dp[j] == true) {
                    check = true;
                    break;
                }
            }
            if (check)
                dp[i] = true;
        }
        return dp[0];
    }
}