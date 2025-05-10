class Solution {
    public boolean canPartition(int[] num) {
        int n = num.length;
        int totalsum = 0;
        for (int i = 0; i < n; i++) {
            totalsum += num[i];
        }
        if (totalsum % 2 == 1)
            return false;
        int tar = totalsum / 2;
        boolean[][] dp = new boolean[n + 1][tar + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= tar; j++) {

                if (j < num[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num[i - 1]];

                }
            }
        }
        return dp[n][tar];
    }
}