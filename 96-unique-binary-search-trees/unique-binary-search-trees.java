class Solution {
    int call(int[] dp, int n) {
        if (dp[n] != -1)
            return dp[n];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int a = 1;
            if (n - i != 1)
                a *= call(dp, n - i);
            if (i - 1 != 1)
                a *= call(dp, i - 1);
            sum += a;
        }
        return dp[n] = sum;
    }

    public int numTrees(int n) {
        if (n < 3)
            return n;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        return call(dp, n);
    }
}