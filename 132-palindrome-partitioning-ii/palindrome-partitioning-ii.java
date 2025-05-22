class Solution {
    boolean call2(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    int call(String s, int i, int j, int[] dp) {
        if (j - i == 0)
            return 0;
        if (i > j)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int ans = j - i;
        // StringBuilder g = new StringBuilder();
        for (int k = i; k <= j; k++) {
            // g.append(s.charAt(k));
            boolean check = call2(s, i, k);
            if (check == false)
                continue;
            // System.out.println(i + " " + k + " " + j +" "+s.substring(i, k+1));
            ans = Math.min(ans,
                    (k == j ? 0 : 1) + call(s, k + 1, j, dp));
        }
        return dp[i] = ans;
    }

    public int minCut(String s) {
        int j = s.length();
        int[] dp = new int[j];
        for (int i = 0; i < j; i++) {
            //for (int k = 0; k < j; k++) {
            dp[i] = -1;
            //}
        }
        return call(s, 0, j - 1, dp);
    }
}