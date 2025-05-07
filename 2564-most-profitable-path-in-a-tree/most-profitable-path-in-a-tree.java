class Solution {
    int ans = Integer.MIN_VALUE;

    boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, HashMap<Integer, Integer> arr, int[] visited1,
            int time) {
        visited1[node] = 1;
        if (node == 0) {
            return true;
        }
        for (Integer i : adj.get(node)) {
            if (visited1[i] == 1)
                continue;
            arr.put(i, time);
            if (dfs(i, adj, arr, visited1, time + 1))
                return true;
            arr.remove(i);
        }
        return false;
    }

    void dfs2(int node, ArrayList<ArrayList<Integer>> adj, HashMap<Integer, Integer> arr, int[] visited2,
            int time, int[] amount, int sum) {
        visited2[node] = 1;
        if (arr.containsKey(node)) {
            if (arr.get(node) == time) {
                sum += amount[node] / 2;
                // System.out.println(node + " " + sum + " " + " " + time);
            } else if (arr.get(node) > time) {
                sum += amount[node];
                // System.out.println(node + " " + sum + " " + time);
            }
        } else {
            sum += amount[node];
            // System.out.println(node + " " + sum + " " + time);
        }
        int count = 0;
        for (Integer i : adj.get(node)) {
            if (visited2[i] == 1)
                continue;
            count++;
            dfs2(i, adj, arr, visited2, time + 1, amount, sum);
        }

        if (count == 0)
            ans = Math.max(ans, sum);
        // return false;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        HashMap<Integer, Integer> arr = new HashMap<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length + 1;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] visited1 = new int[n];
        arr.put(bob, 0);
        dfs(bob, adj, arr, visited1, 1);
        // System.out.println(arr);

        int[] visited2 = new int[n];
        dfs2(0, adj, arr, visited2, 0, amount, 0);
        return ans;
    }
}