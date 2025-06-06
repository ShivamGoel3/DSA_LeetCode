class Solution {
    int call(ArrayList<ArrayList<pair>> adj, int node, long[] mst, int[] dp) {
        if (node == 0)
            return 1;
        int count = 0;
        if (dp[node] != -1)
            return dp[node];
        for (pair i : adj.get(node)) {
            int nodes = i.node;
            long wt = i.time;
            if (mst[node] != mst[nodes] + wt)
                continue;
            count += call(adj, nodes, mst, dp);
            count %= 1000000007;
        }
        return dp[node] = count;
    }

    class pair {
        int node;
        long time;

        pair(int a, long b) {
            this.node = a;
            this.time = b;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new pair(roads[i][0], roads[i][2]));
            // adj.get(roads[i][1]).add(new int[] { roads[i][0], roads[i][2] });
        }
        // System.out.print(adj);
        // for (int i = 0; i < n; i++) {
        //     System.out.print(i +" -   ");
        //     for (int[] j : adj.get(i)) {
        //         System.out.print(j[0] + " " + j[1] + " - ");
        //     }
        //     System.out.println();
        // }
        long[] mst = new long[n];
        for (int i = 0; i < n; i++)
            mst[i] = Long.MAX_VALUE;
        mst[0] = 0;
        PriorityQueue<pair> q = new PriorityQueue<>(new Comparator<pair>() {
            public int compare(pair a, pair b) {
                return (int) (a.time - b.time);
            }
        });
        q.add(new pair(0, 0));
        while (q.size() > 0) {
            int node = q.poll().node;
            // System.out.println(node);
            for (pair i : adj.get(node)) {
                if (mst[i.node] > mst[node] + i.time) {
                    mst[i.node] = mst[node] + i.time;
                    // mst[i.node] %= 1000000007;
                    // q.add(new int[] { mst[i[0]], i[0] });
                    q.add(new pair(i.node, mst[i.node]));
                }
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
            // System.out.println(i + " - " + mst[i] + " ");
        }
        return call(adj, n - 1, mst, dp);
    }
}