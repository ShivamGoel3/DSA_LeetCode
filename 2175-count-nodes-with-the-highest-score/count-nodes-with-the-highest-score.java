class Solution {
    long maxscore = -1;
    int ans = 0;

    int dfs(int node, ArrayList<ArrayList<Integer>> adj, int n) {
        int childnode = adj.get(node).size();
        long score = 1;
        for (Integer i : adj.get(node)) {
            int count = dfs(i, adj, n);
            childnode += count;
            // System.out
            score *= (count + 1);
        }
        int leftNode = n - childnode - 1;
        if (leftNode > 0)
            score *= leftNode;
        // System.out.println(node + " " + leftNode + " " + score);
        if (maxscore <= score) {
            if (maxscore < score)
                ans = 0;
            ans++;
            maxscore = score;
        }
        return childnode;
    }

    public int countHighestScoreNodes(int[] parents) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = parents.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int head = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                head = i;
                continue;
            }
            adj.get(parents[i]).add(i);
        }

        dfs(head, adj, n);
        // System.out.println(ans);
        return ans;
    }
}