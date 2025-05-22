class Solution {

    int call(int i, int j, ArrayList<Integer> cut, int[][] dp) {
        if (j - i == 1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            // System.out.println(i + " " + k + " " + j);
            int b = call(i, k, cut, dp);
            int c = call(k, j, cut, dp);
            ans = Math.min(ans, b + c + cut.get(j) - cut.get(i));
            // System.out.println(i + " " + j + " " + k + " " + b + " " + c);
        }
        int a = ans != Integer.MAX_VALUE ? ans : 0;
        dp[i][j] = a;
        return a;
    }

    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> cut = new ArrayList<>();
        for (int i = 0; i < cuts.length; i++) {
            cut.add(cuts[i]);
        }
        cut.add(0);
        cut.add(n);
        Collections.sort(cut);
        int[][] dp = new int[cut.size()][cut.size()];
        for (int i = 0; i < cut.size(); i++) {
            for (int j = 0; j < cut.size(); j++) {
                dp[i][j] = -1;
            }
        }
        return call(0, cut.size() - 1, cut, dp);
    }
}