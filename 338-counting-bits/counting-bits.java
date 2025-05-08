class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int number = 0;
            for (int j = 0; j <= 31; j++) {
                int bit = (i >> j) & 1;
                if (bit == 1)
                    number++;
            }
            ans[i] = number;
        }
        return ans;
    }
}