class Solution {
    boolean safe(int i, int j, int n, int m) {
        if (i <= 0 || j <= 0 || i > n || j > m)
            return false;
        return true;
    }

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int n = target[0];
        int m = target[1];
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        HashMap<String, Integer> mst = new HashMap<>();
        for (int i = 0; i < specialRoads.length; i++) {
            mst.put("" + specialRoads[i][0] + " " + specialRoads[i][1], Integer.MAX_VALUE);
            mst.put("" + specialRoads[i][2] + " " + specialRoads[i][3], Integer.MAX_VALUE);
        }
        mst.put("" + target[0] + " " + target[1], Math.abs(target[0] - start[0])
                + Math.abs(target[1] - start[1]));
        mst.put("" + start[0] + " " + start[1], 0);
        // System.out.println(mst);
        q.add(new int[] { start[0], start[1], 0 });
        while (q.size() > 0) {
            int[] a = q.poll();
            int i = a[0], j = a[1], dis = a[2];
            // System.out.println("\n" + i + " " + j + " " + dis);
            for (int z = 0; z < specialRoads.length; z++) {

                int k = specialRoads[z][0];
                int l = specialRoads[z][1];
                int x2 = specialRoads[z][2];
                int y2 = specialRoads[z][3];
                if (Math.abs(x2 - k) + Math.abs(y2 - l) < specialRoads[z][4])
                    continue;
                if (mst.get("" + k + " " + l) > mst.get("" + i + " " + j) + Math.abs(k - i) + Math.abs(l - j)) {
                    // System.out.print(" hey " + k + " " + l + " " + x2 + " " + y2 + " - ");
                    mst.put("" + k + " " + l, mst.get("" + i + " " + j) + Math.abs(k - i) + Math.abs(l - j));
                    q.add(new int[] { k, l, mst.get("" + k + " " + l) });
                }
                if (mst.get("" + x2 + " " + y2) > mst.get("" + k + " " + l) + specialRoads[z][4]) {
                    mst.put("" + x2 + " " + y2, mst.get("" + k + " " + l) + specialRoads[z][4]);
                    // System.out.print(" he " + k + " " + l + " " + x2 + " " + y2 + " - ");
                    q.add(new int[] { x2, y2, mst.get("" + x2 + " " + y2) });
                    // continue;
                }
            }
            if (mst.get("" + target[0] + " " + target[1]) > mst.get("" + i + " " + j) + Math.abs(target[0] - i)
                    + Math.abs(target[1] - j)) {
                // System.out.print(" hey " + k + " " + l + " " + x2 + " " + y2 + " - ");
                mst.put("" + target[0] + " " + target[1], mst.get("" + i + " " + j) + Math.abs(target[0] - i)
                        + Math.abs(target[1] - j));
            }
        }
        return mst.get("" + n + " " + m);
    }
}