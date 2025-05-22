class Solution {

    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> cut = new ArrayList<>();
        for (int i = 0; i < cuts.length; i++) {
            cut.add(cuts[i]);
        }
        cut.add(0);
        cut.add(n);
        Collections.sort(cut);
        int[][] dp = new int[cut.size()][cut.size()];

        for (int len = 2; len < cut.size(); len++) {
            int j = len;
            for (int i = 0; i < cut.size() && j < cut.size(); i++, j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k][j] + cut.get(j) - cut.get(i));
                }
            }
        }

        return dp[0][cut.size() - 1];
    }
}