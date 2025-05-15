class Solution {
    public int[] findPeakGrid(int[][] mat) {
        // return new int[] {};
        int n = mat[0].length;
        int m = mat.length;
        int start = 0, end = n - 1;
        int maxelement = Integer.MIN_VALUE;
        int index = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            // int mine = mat[0][mid];
            if (maxelement == Integer.MIN_VALUE) {
                index = 0;
                maxelement = mat[0][mid];
            }
            for (int j = 0; j < m; j++) {
                if (mat[j][mid] > maxelement) {
                    index = j;
                    maxelement = mat[j][mid];
                }
            }
            if (mid + 1 < n && mat[index][mid] < mat[index][mid + 1]) {
                maxelement = mat[index][mid + 1];
                start = mid + 1;
            } else if (mid - 1 >= 0 && mat[index][mid] < mat[index][mid - 1]) {
                maxelement = mat[index][mid - 1];
                end = mid - 1;
            } else
                return new int[] { index, mid };

        }
        return new int[] { 0, 0 };
    }
}