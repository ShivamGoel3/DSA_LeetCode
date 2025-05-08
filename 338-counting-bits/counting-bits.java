class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        if (n == 0)
            return ans;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            int N = i;
            int logso = (int) (Math.log(N) / Math.log(2));
            // System.out.println(logso + " " + (Math.pow(2, logso)));
            ans[i] = 1 + ans[i - (int) (Math.pow(2, logso))];
        }
        return ans;
    }
}