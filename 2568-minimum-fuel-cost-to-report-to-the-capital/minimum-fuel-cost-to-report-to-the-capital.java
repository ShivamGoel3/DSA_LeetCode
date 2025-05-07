class Solution {
    long[] call(ArrayList<ArrayList<Integer>> adj, int seats, int[] visited, int node) {
        visited[node] = 1;
        long men = 0;
        long fuel = 0;
        for (Integer i : adj.get(node)) {
            if (visited[i] == 1)
                continue;
            long[] a = call(adj, seats, visited, i);
            men += a[0];
            fuel += a[1];
        }
        if (node == 0) {
            return new long[] { men, fuel };
        } else {
            men++;
            // System.out.println(node + " " + men + " " + fuel + " " + (fuel + men / seats + 1));
            if (men % seats == 0)
                return new long[] { men, fuel + men / seats };
            else
                return new long[] { men, fuel + men / seats + 1 };
        }
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = roads.length + 1;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        long[] ans = call(adj, seats, visited, 0);
        return ans[1];
    }
}