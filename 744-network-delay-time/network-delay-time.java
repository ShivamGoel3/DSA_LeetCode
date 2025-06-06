class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new int[] { times[i][1], times[i][2] });
        }
        int[] mst = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            mst[i] = Integer.MAX_VALUE;
        }
        mst[k] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        q.add(new int[] { 0, k });
        while (q.size() > 0) {
            int node = q.poll()[1];
            for (int[] i : adj.get(node)) {
                if (mst[i[0]] > mst[node] + i[1]) {
                    q.add(new int[] { mst[i[0]], i[0] });
                    mst[i[0]] = mst[node] + i[1];
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, mst[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}