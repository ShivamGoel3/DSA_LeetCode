class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            prefix *= nums[i];
            ans = Math.max(ans, prefix);
            if (prefix == 0)
                prefix = 1;
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix *= nums[i];
            ans = Math.max(ans, suffix);
            if (suffix == 0)
                suffix = 1;
        }
        return ans;
    }
}