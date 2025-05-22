class Solution {
    int call(int[] arr, int i, int j, int m, int[][] dp) {
        if (i > j)
            return 0;
        int ans = 0;
        int a = 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        for (int k = i; k <= j && k - i + 1 <= m; k++) {
            a = Math.max(a, arr[k]);
            ans = Math.max(ans,
                    (k - i + 1) * a + call(arr, k + 1, j, m, dp));
        }
        return dp[i][j] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int a = 0;
            int ans = 0;
            for (int j = i; j < n && j - i + 1 <= k; j++) {
                a = Math.max(a, arr[j]);
                ans = Math.max(ans,
                        (j - i + 1) * a + dp[j + 1]);
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}