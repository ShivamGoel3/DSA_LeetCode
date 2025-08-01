class Solution {
    public int trap(int[] height) {
        int leftlarge = 0;
        int rightlarge = 0;
        int i = 0, j = height.length - 1;
        int ans = 0;
        while (i < j) {
            leftlarge = Math.max(leftlarge, height[i]);
            rightlarge = Math.max(rightlarge, height[j]);
            if (height[i] <= height[j]) {
                ans += Math.min(leftlarge, rightlarge) - height[i];
                i++;
            } else {
                ans += Math.min(leftlarge, rightlarge) - height[j];
                j--;
            }
        }
        return ans;
    }
}