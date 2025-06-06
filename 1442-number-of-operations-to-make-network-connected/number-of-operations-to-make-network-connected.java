class Solution {
    void call(ArrayList<ArrayList<Integer>> adj, int node, int[] rank,
            int[] visited) {
        visited[node] = 1;
        rank[1]++;
        rank[0] += adj.get(node).size();
        for (Integer i : adj.get(node)) {
            if (visited[i] == 1)
                continue;
            // rank[0]++;
            call(adj, i, rank, visited);
        }
    }

    public int makeConnected(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < connections.length; i++) {
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        int count = 0;
        int extra = 0;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1)
                continue;
            int[] rank = new int[2];
            call(adj, i, rank, visited);
            rank[0] /= 2;
            // System.out.println(i + " " + rank[0] + " " + rank[1]);
            extra += rank[0] - (rank[1] - 1);
            count++;
        }
        // System.out.println(count + " " + extra);
        if (extra >= count - 1)
            return count - 1;
        else
            return -1;
    }
}