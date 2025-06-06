class Solution {

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
        }
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
        int[] dp = new int[n];
        dp[0] = 1;
        while (q.size() > 0) {
            pair a = q.poll();
            int node = a.node;
            long dis = a.time;
            for (pair i : adj.get(node)) {
                if (mst[i.node] > dis + i.time) {
                    mst[i.node] = dis + i.time;
                    q.add(new pair(i.node, mst[i.node]));
                    dp[i.node] = dp[node];
                    // System.out.println(i.node + " " + mst[i.node] + " " + dp[i.node]);
                } else if (mst[i.node] == dis + i.time) {
                    dp[i.node] += dp[node];
                    // System.out.println(i.node + " " + mst[i.node] + " " + dp[i.node]);
                }

                dp[i.node] %= 1000000007;
            }
        }
        return dp[n - 1];
    }
}