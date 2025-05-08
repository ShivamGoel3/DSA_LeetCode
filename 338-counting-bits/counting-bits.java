class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        if (n == 0)
            return ans;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            int N = i;
            int logso = N & (N - 1);
            ans[i] = 1 + ans[logso];
        }
        return ans;
    }
}