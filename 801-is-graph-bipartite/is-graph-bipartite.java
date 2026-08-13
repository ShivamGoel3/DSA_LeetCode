class Solution {
    boolean call(int node, int[][] graph, int[] color) {
        for (int i = 0; i < graph[node].length; i++) {
            if (color[graph[node][i]] == -1) {
                color[graph[node][i]] = 1 - color[node];
                boolean check = call(graph[node][i], graph, color);
                if (check == false)
                    return false;
            } else {
                if (color[graph[node][i]] == color[node])
                    return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < color.length; i++)
            color[i] = -1;
        for (int j = 0; j < graph.length; j++) {
            if (color[j] != -1)
                continue;
            color[j] = 0;
            boolean check = call(j, graph, color);
            if (check == false)
                return false;
        }
        return true;
    }
}