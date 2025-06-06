class Solution {
    boolean call(int[][] graph, int node, int[] visited, int[] res) {
        visited[node] = 1;
        res[node] = 1;
        for (int i = 0; i < graph[node].length; i++) {
            if (visited[graph[node][i]] == 0) {
                boolean check = call(graph, graph[node][i], visited, res);
                if (check) {
                    return true;
                }
            } else if (res[graph[node][i]] == 1) {
                return true;
            }
        }
        res[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] res = new int[n];
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1)
                continue;
            call(graph, i, visited, res);
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == 0)
                ans.add(i);
        }
        return ans;
    }
}