class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int a = (n >> i) & 1;
            ans *= 2;
            ans += a;
            // System.out.print(a);
        }
        // 100
        return ans;
    }
}