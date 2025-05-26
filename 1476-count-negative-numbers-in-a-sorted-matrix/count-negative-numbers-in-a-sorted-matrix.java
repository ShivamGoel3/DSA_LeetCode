class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while (j >= 0 && i < m) {
            if (grid[i][j] < 0) {
                ans += m - i;
                j--;
            } else
                i++;
        }
        return ans;
    }
}