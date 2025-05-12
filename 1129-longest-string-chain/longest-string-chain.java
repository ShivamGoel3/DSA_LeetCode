class Solution {
    boolean lca(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (Math.abs(n - m) != 1)
            return false;
        int i = 0, j = 0;
        boolean check = true;
        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if (check)
                    check = false;
                else
                    return false;
                if (n > m)
                    i++;
                else
                    j++;
            }
        }
        return true;
    }

    public int longestStrChain(String[] words) {
        int ans = 0;
        int n = words.length;
        int[] dp = new int[n];
        Arrays.sort(words, new Comparator<>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        for (int i = 0; i < n; i++) {
            int c = 0;
            // System.out.println(words[i]);
            for (int j = 0; j < i; j++) {
                String word1 = words[i];
                String word2 = words[j];
                if (lca(word1, word2) == false)
                    continue;
                if (dp[j] > c)
                    c = dp[j];
            }
            dp[i] = c + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}