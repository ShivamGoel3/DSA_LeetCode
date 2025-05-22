class Solution {
    int call(String s, int i, int n, int[] dp) {
        if (i == n)
            return 1;
        int a = 0;
        int ans = 0;
        if (dp[i] != -1)
            return dp[i];
        for (int k = i; k < n; k++) {
            a *= 10;
            a += s.charAt(k) - '0';
            // System.out.println(a + " " + i);
            if (a > 0 && a <= 26) {
                ans += call(s, k + 1, n, dp);
            } else {
                break;
            }
        }
        return dp[i] = ans;
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = -1;
        }
        return call(s, 0, s.length(), dp);
    }
}