class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[][] dp = new int[2][nums.length];
        int maxcount = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0, freq = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (count < dp[0][j]) {
                        count = dp[0][j];
                        freq = dp[1][j];
                    } else if (count == dp[0][j])
                        freq += dp[1][j];
                }
                // else
                //     freq = 1;
            }
            // System.out.println(i + " " + count + " " + freq);
            dp[0][i] = count + 1;
            dp[1][i] = freq;
            if (maxcount < dp[0][i]) {
                maxcount = dp[0][i];
                ans = dp[1][i];
            } else if (maxcount == dp[0][i])
                ans += dp[1][i];
        }
        return ans;
    }
}