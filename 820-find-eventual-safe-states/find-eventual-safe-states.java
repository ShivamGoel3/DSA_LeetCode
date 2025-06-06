class Solution {
    boolean call(int[][] graph, int node, int[] visited, int[] res, int[] rank) {
        visited[node] = 1;
        res[node] = 1;
        for (int i = 0; i < graph[node].length; i++) {
            if (visited[graph[node][i]] == 0) {
                boolean check = call(graph, graph[node][i], visited, res, rank);
                if (check) {
                    rank[graph[node][i]] = 1;
                    return true;
                }
            } else if (res[graph[node][i]] == 1 || rank[graph[node][i]] == 1) {
                rank[graph[node][i]] = 1;
                return true;
            }
        }
        res[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] rank = new int[n];
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1)
                continue;
            int[] res = new int[n];
            boolean c = call(graph, i, visited, res, rank);
            if (c)
                rank[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (rank[i] == 0)
                ans.add(i);
        }
        return ans;
    }
}