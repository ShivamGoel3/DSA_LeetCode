class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> a = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] > b[0])
                    return 1;
                if (a[0] < b[0])
                    return -1;
                return a[1] - b[1];
            }
        });
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] < intervals[i][0]) {
                index++;
                intervals[index] = intervals[i];
            } else {
                intervals[index][0] = Math.min(intervals[i][0], intervals[index][0]);
                intervals[index][1] = Math.max(intervals[i][1], intervals[index][1]);
            }
        }
        int[][] ans = new int[index + 1][2];
        for (int i = 0; i <= index; i++) {
            ans[i] = intervals[i];
        }
        return ans;
    }
}