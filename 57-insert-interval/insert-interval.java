class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> a = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            a.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        a.add(newInterval);
        while (i < intervals.length) {
            a.add(intervals[i]);
            i++;
        }
        int[][] ans = new int[a.size()][2];
        i = 0;
        for (int[] j : a) {
            ans[i] = j;
            i++;
        }
        return ans;
    }
}