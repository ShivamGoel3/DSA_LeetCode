class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1, ans = 0;
        int maxl = 0, maxr = 0;
        while (i < j) {
            maxl = Math.max(maxl, height[i]);
            maxr = Math.max(maxr, height[j]);
            ans += Math.min(maxl, maxr);
            if (height[i] < height[j]) {
                ans -= height[i];
                i++;
            } else {
                ans -= height[j];
                j--;
            }
        }
        return ans;
    }

}