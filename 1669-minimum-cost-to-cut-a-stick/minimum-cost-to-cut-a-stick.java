class Solution {

    int call(int i, int j, int[] cuts, HashMap<String, Integer> dp) {
        // if (index == cuts.length)
        //     return 0;
        // if (cuts[index] < i || cuts[index] > j)
        //     return 0;
        if (dp.containsKey("" + i + " " + j))
            return dp.get("" + i + " " + j);
        int ans = Integer.MAX_VALUE;
        boolean check = false;
        for (int k = 0; k < cuts.length; k++) {
            // swap(k, index, cuts);
            if (cuts[k] <= i || cuts[k] >= j)
                continue;
            check = true;
            int b = call(i, cuts[k], cuts, dp);
            int c = call(cuts[k], j, cuts, dp);
            ans = Math.min(ans, b + c + j - i);
            // System.out.println(i + " " + j + " " + k + " " + b + " " + c);
            // swap(k, index, cuts);
        }
        int a = check ? ans : 0;
        dp.put("" + i + " " + j, a);
        return a;
    }

    public int minCost(int n, int[] cuts) {
        // int[][] dp = new int[n + 1][n + 1];
        // for (int i = 0; i <= n; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        HashMap<String, Integer> dp = new HashMap<>();
        return call(0, n, cuts, dp);
    }
}