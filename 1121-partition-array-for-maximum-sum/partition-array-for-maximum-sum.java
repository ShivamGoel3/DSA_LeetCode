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
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return call(arr, 0, n - 1, k, dp);
    }
}