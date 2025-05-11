class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // int count = dp[n][m];
        // String ans = "";
        HashSet<Integer> set = new HashSet<>();
        StringBuilder s = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                set.add(j - 1);
                // ans = s1.charAt(i-1) + ans;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;

        }
        i = 0;
        j = 0;
        // System.out.println(set);
        while (i < n && j < m) {
            if (set.contains(j)) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    s.append(s2.charAt(j));
                    j++;
                    i++;
                } else {
                    s.append(s1.charAt(i));
                    i++;
                }
            } else {
                s.append(s2.charAt(j));
                j++;
            }
        }
        while (i < n) {
            s.append(s1.charAt(i));
            i++;
        }
        while (j < m) {
            s.append(s2.charAt(j));
            j++;
        }
        return s.toString();
    }
}