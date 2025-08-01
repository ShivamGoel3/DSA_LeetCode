class Solution {
    public int trap(int[] height) {
        int[] right = new int[height.length];
        int[] left = new int[height.length];
        int leftlarge = 0;
        int rightlarge = 0;
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            leftlarge = Math.max(height[i], leftlarge);
            left[i] = leftlarge;
            // System.out.print(left[i] + " ");
        }
        // System.out.print("\n");
        for (int i = height.length - 1; i >= 0; i--) {
            rightlarge = Math.max(height[i], rightlarge);
            right[i] = rightlarge;
            // System.out.print(right[i] + " ");
        }
        for (int i = 0; i < height.length; i++) {
            // System.out.println(left[i] + " " + right[i]);
            int a = Math.min(left[i], right[i]);
            ans += a - height[i];
        }
        return ans;
    }
}