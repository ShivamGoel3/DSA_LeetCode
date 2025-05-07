class Solution {
    boolean safe(int i, int j, int[][] visited, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return false;
        return visited[i][j] == 0;
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        q.add(new int[] { 0, 0, 0, 1 });
        int[][] visited = new int[n][m];
        visited[0][0] = 1;
        while (q.size() > 0) {
            int[] node = q.poll();
            if (node[0] == n - 1 && node[1] == m - 1)
                return node[2];
            int i = node[0], j = node[1], time = node[2];
            int oldtimer = node[3];
            int newtimer = node[3] == 1 ? 2 : 1;
            if (safe(i + 1, j, visited, n, m)) {
                visited[i + 1][j] = 1;
                q.add(new int[] { i + 1, j, Math.max(time, moveTime[i + 1][j]) + oldtimer,
                        newtimer });
            }
            if (safe(i - 1, j, visited, n, m)) {
                visited[i - 1][j] = 1;
                q.add(new int[] { i - 1, j, Math.max(time, moveTime[i - 1][j]) + oldtimer, newtimer });
            }
            if (safe(i, j + 1, visited, n, m)) {
                visited[i][j + 1] = 1;
                q.add(new int[] { i, j + 1, Math.max(time, moveTime[i][j + 1]) + oldtimer, newtimer });
            }
            if (safe(i, j - 1, visited, n, m)) {
                visited[i][j - 1] = 1;
                q.add(new int[] { i, j - 1, Math.max(time, moveTime[i][j - 1]) + oldtimer, newtimer });
            }
        }
        return -1;
    }
}