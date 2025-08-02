class Solution {
    public int[][] generateMatrix(int n) {
        int minrow = 0, mincol = 0;
        int maxrow = n - 1;
        int maxcol = n - 1;
        int count = 1;
        int[][] ans = new int[n][n];
        while (count <= n * n) {
            for (int i = mincol; i <= maxcol && count <= n * n; i++) {
                ans[minrow][i] = count;
                count++;
            }
            minrow++;
            for (int i = minrow; i <= maxrow && count <= n * n; i++) {
                ans[i][maxcol] = count;
                count++;
            }
            maxcol--;
            for (int i = maxcol; i >= mincol && count <= n * n; i--) {
                ans[maxrow][i] = count;
                count++;
            }
            maxrow--;
            for (int i = maxrow; i >= minrow && count <= n * n; i--) {
                ans[i][mincol] = count;
                count++;
            }
            mincol++;
        }
        return ans;
    }
}