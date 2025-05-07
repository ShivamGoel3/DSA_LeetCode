class Solution {
    boolean call(ArrayList<ArrayList<Integer>> adj, int[] visited, int source, int destination) {
        if (source == destination)
            return true;
        visited[source] = 1;
        for (Integer i : adj.get(source)) {
            if (visited[i] == 0) {
                boolean check = call(adj, visited, i, destination);
                if (check)
                    return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] visited = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        return call(adj, visited, source, destination);
    }
}