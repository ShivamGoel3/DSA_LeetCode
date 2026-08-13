class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < color.length; i++)
            color[i] = -1;
        Queue<Integer> q = new LinkedList<>();
        for (int j = 0; j < graph.length; j++) {
            if (color[j] != -1)
                continue;
            q.add(j);
            color[j] = 0;
            while (q.size() > 0) {
                int node = q.peek();
                q.remove();
                for (int i = 0; i < graph[node].length; i++) {
                    if (color[graph[node][i]] == -1) {
                        color[graph[node][i]] = 1 - color[node];
                        q.add(graph[node][i]);
                    } else {
                        if (color[graph[node][i]] == color[node])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}