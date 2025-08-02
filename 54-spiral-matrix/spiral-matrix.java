class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minrow = 0, mincol = 0;
        int maxrow = matrix.length - 1;
        int maxcol = matrix[0].length - 1;
        int n = matrix.length * matrix[0].length;
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        while (count < n) {
            for (int i = mincol; i <= maxcol && count < n; i++) {
                ans.add(matrix[minrow][i]);
                count++;
            }
            minrow++;
            for (int i = minrow; i <= maxrow && count < n; i++) {
                ans.add(matrix[i][maxcol]);
                count++;
            }
            maxcol--;
            for (int i = maxcol; i >= mincol && count < n; i--) {
                ans.add(matrix[maxrow][i]);
                count++;
            }
            maxrow--;
            for (int i = maxrow; i >= minrow && count < n; i--) {
                ans.add(matrix[i][mincol]);
                count++;
            }
            mincol++;
        }
        return ans;
    }
}