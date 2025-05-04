class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int l = 0;
        for (int i = 0; i < height.length; i++) {
            l = Math.max(l, height[i]);
            prefix[i] = l;
            // System.out.print(l + " ");
            //l = Math.max(l, height[i]);
        }
        // System.out.println(" ");
        int r = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            r = Math.max(r, height[i]);
            suffix[i] = r;
            // System.out.print(r + " ");

        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            // System.out.println(prefix[i] + " " + suffix[i]);
            // if (height[i] == suffix[i] || height[i] == prefix[i])
            //     continue;
            ans += Math.min(suffix[i], prefix[i]) - height[i];
        }
        return ans;
    }

}