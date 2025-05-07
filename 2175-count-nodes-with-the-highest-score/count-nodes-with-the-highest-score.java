class Solution {
    int updatechildcount(int node, ArrayList<ArrayList<Integer>> adj, int[] dp) {
        int count = adj.get(node).size();
        for (Integer i : adj.get(node)) {
            count += updatechildcount(i, adj, dp);
        }
        dp[node] = count;
        return count;
    }

    long maxscore = -1;
    int ans = 0;

    void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] dp, int n) {
        int sumChildNode = dp[node];
        long score = 1;
        for (Integer i : adj.get(node)) {
            dfs(i, adj, dp, n);
            // System.out
            score *= (dp[i] + 1);
        }
        int leftNode = n - sumChildNode - 1;
        if (leftNode > 0)
            score *= leftNode;
        // System.out.println(node + " " + leftNode + " " + score);
        if (maxscore <= score) {
            if (maxscore < score)
                ans = 0;
            ans++;
            maxscore = score;
        }
    }

    public int countHighestScoreNodes(int[] parents) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = parents.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int head = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                head = i;
                continue;
            }
            adj.get(parents[i]).add(i);
        }
        updatechildcount(head, adj, dp);
        // for(int i=0;i<n;i++){
        //     System.out.print(dp[i]+" ");
        // }

        dfs(head, adj, dp, n);
        // System.out.println(ans);
        return ans;
    }
}